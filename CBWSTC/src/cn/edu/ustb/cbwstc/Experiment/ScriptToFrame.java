package cn.edu.ustb.cbwstc.Experiment;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.xml.sax.SAXException;

import cn.edu.ustb.cbwstc.model.Graph;
import cn.edu.ustb.cbwstc.model.Node;
import cn.edu.ustb.cbwstc.tsg.TeatSequence;
import cn.edu.ustb.cbwstc.util.RexpMatching;
import cn.edu.ustb.cbwstc.wsdl.parser.XMLHelper;

/**
 * �������Խű������пͻ���ģ�⣬���в���������ִ�� ��Ҫgraph��TestSequenceModel
 * @author Administrator
 *
 */
public class ScriptToFrame {
	
	private static String uri = "";
	private static String name = "";
	private Graph g = new Graph();
	private ArrayList<TeatSequence> tss  = new ArrayList<TeatSequence>();
	
	private static HashMap<String,String> eTimeC = new HashMap<String,String>();
	private static HashMap<String,String> paramRangeC = new HashMap<String,String>();
	private static HashMap<String,String> sequenceC = new HashMap<String,String>();
	private static HashMap<String,String> callC = new HashMap<String,String>();
	private static HashMap<String,String> paramRelationC = new HashMap<String,String>();
	private static HashMap<String,String> invokeC = new HashMap<String,String>();
	private static HashMap<String,String> ipRangeC = new HashMap<String,String>();
	
	public ScriptToFrame(String uri, Graph g, ArrayList<TeatSequence> tss) {
		this.uri = uri;
		this.name = uri.substring(uri.lastIndexOf("/")+1, uri.length()-5);
		this.g = g;
		this.tss = tss;
	}
	
//	public static void main(String[] args) {
//		String wsdlURI = "http://localhost:8080/axis2/services/ParkingFeeCalculator?wsdl";
//		ScriptToFrame stc = new ScriptToFrame(wsdlURI);
//		SendWsdlInterface si = new SendWsdlInterface(uri);
//		for(int index=0;index<=2;index++) {
//			ArrayList<String> dfilePathN = stc.findXMLTestCase("", index);
////			paramRangeC.clear();
////			sequenceC.clear();
////			callC.clear();
////			paramRelationC.clear();
//			for(int i=0;i<dfilePathN.size();i++) {
//				if(wsdlURI.equals("http://localhost:8080/axis2/services/ParkingFeeCalculator?wsdl")) {
//					InitExperiment init = new InitExperiment();
//					init.init();
//				}
//				stc.readXMlTestCase(si,"CBWSTC_WorkSpace/Projects/" + name +"/TC/" + dfilePathN.get(i),dfilePathN.get(i));
//			}
//		}
//		System.exit(0);
//	}
	
	public void testProcess(int tsNum) {
		SendWsdlInterface si = new SendWsdlInterface(uri);
		for(int index=0;index<tss.size();index++) {
			int tsId = tss.get(index).getTcId();
			ArrayList<String> dfilePathN = findXMLTestCase(tsId); //��ȡ��index��Ӧ���ļ���
//			paramRangeC.clear();
//			sequenceC.clear();
//			callC.clear();
//			paramRelationC.clear();
			for(int i=0;i<dfilePathN.size();i++) {
				if(uri.contains("ParkingFeeCalculator")) {
					InitExperiment init = new InitExperiment();
					init.init();
				}
				readXMlTestCase(si,"CBWSTC_WorkSpace/Projects/" + name +"/TC/" + dfilePathN.get(i),dfilePathN.get(i),tss.get(index).getTs());
			}
		}
	}
	
	/**
	 * �ҵ��ò���������صĲ��Խű�
	 * @param ts
	 * @param tsId
	 * @return
	 */
	public ArrayList<String> findXMLTestCase(int tsId) {
		String[] filePathN = null;
		ArrayList<String> dfilePathN = new ArrayList<String>();
		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/TC");
		filePathN = f.list();
//		System.out.println("���������");
		for(int i=0; i<filePathN.length; i++) {
//			System.out.println(filePathN[i]);
			if(filePathN[i].split("#")[1].equals(tsId + "")) {
//				System.out.println(filePathN[i]);
				dfilePathN.add(filePathN[i]);
			}
		}
		return dfilePathN;
	}
	/**
	 * ��ȡ���Խű�
	 * ���ձ�ǩ����
	 * @param path
	 */
	public void readXMlTestCase(SendWsdlInterface si,String path,String tc,String ts) {
		String testResult = "";
		String sequence= "";
		String resultFile = "CBWSTC_WorkSpace/Projects/" + name + "/Result/" + tc;
		Document document = XMLHelper.openXMLFile(path);
		Element root = document.getRootElement();
		List<?> nodes = root.elements("Operation");
		for (Iterator<?> it = nodes.iterator(); it.hasNext();) {     
		      Element elm = (Element) it.next();
		      String opName = elm.attribute("name").getText();
//		      elm.asXML();//������elm�ı�ǩ
		      Element elmEnvelope = elm.element("Envelope");
		      Element body = elmEnvelope.element("Body").element(opName);
		      if(validateXMLSchema(body.asXML())) { //�������XSD���
		    	  String soapReturn = si.sendSoap(opName,elmEnvelope.asXML());
		    	  int flag = findSoapReturn(soapReturn);
		    	  if(flag == 0) { //�������XSD���
		    		  sequence = sequence + opName + opName + "Response_succ";
		    		  testResult = testResult + soapReturn  + "\r\n";
		    	  }else if(flag == 1){ //No such method
		    		  testResult = testResult + soapReturn  + "\r\nError: The Service Implementation does not match the Description, No such method: " + opName + "\r\n";
		    		  String errorLog = "Error: The Service Implementation does not match the Description, No such method: " + opName; 
		    		  System.out.println(tc + " Error: The Service Implementation does not match the Description, No such method: " + opName);
		    		  eTimeC.put(tc,errorLog);
		    		  break;
		    	  }else {
		    		  //TODO Υ��������Լ��������Լ��(˳���ظ�����)������Լ����������ϵԼ���ĸ�Լ�������� ��һ���ж�
		    		  //�ж��Ƿ�Υ���˵���Լ��
		    		  Node gnode = g.getNode(opName);
		    		  if(!assertIp(gnode.getIpRegionC())) { //����Լ��
		    			  testResult = testResult + soapReturn + "\r\nError: Violating the Ip Region Constraint when calling " + opName + " operation\r\n";
	    				  String errorLog = "Error: Violating the Ip Region Constraint when calling " + opName + " operation";
	    				  System.out.println(tc + " Error: Violating the Ip Region Constraint when calling " + opName + " operation");
	    				  ipRangeC.put(tc,errorLog);
	    				  break;
		    		  }
		    		  if(!gnode.getIterationC()) {// ���ظ�����Լ��
		    			  String rule = gnode.getName() + "Response_succ#ef#" + gnode.getName();
		    			  if(ts.contains(rule)) {
		    				  testResult = testResult + soapReturn + "\r\nError: Violating the Repeating Calls Constraint when calling " + opName + " operation\r\n";
		    				  String errorLog = "Error: Violating the Repeating Calls Constraint when calling " + opName + " operation";
		    				  System.out.println(tc + " Error: Violating the Repeating Calls Constraint when calling " + opName + " operation");
		    				  callC.put(tc,errorLog);
		    				  break;
		    			  }
		    		  }
		    		  if(! gnode.getPreOpC().equals("NullConstraint")){ // ������Լ��
		    			  String regEx = gnode.getPreOpC();
		    			  RexpMatching rem = new RexpMatching();
		    			  if(! rem.check(sequence, regEx)) {
		    				  testResult = testResult + soapReturn + "\r\nError: Violating the Sequence Constraint when calling " + opName + " operation\r\n";
		    				  String errorLog = "Error: Violating the Sequence Constraint when calling " + opName + " operation";
		    				  System.out.println(tc + " Error: Violating the Sequence Constraint when calling " + opName + " operation");
		    				  sequenceC.put(tc,errorLog);
		    				  break;
		    			  }
		    		  }
		    		  if(gnode.getParaRelationC() != null && gnode.getParaRelationC().size() != 0) { // �в�����ϵԼ��
		    			  testResult = testResult + soapReturn + "\r\nError: Violating the Parameter Relation Constraint when calling " + opName + " operation\r\n";
		    			  String errorLog = "Error: Violating the Parameter Relation Constraint when calling " + opName + " operation";
		    			  System.out.println(tc + " Error: Violating the Parameter Relation Constraint when calling " + opName + " operation");
		    			  paramRelationC.put(tc,errorLog);
		    			  break;
		    		  }
		    		  if(gnode.getInvokeOpC() != null && gnode.getInvokeOpC().size() !=0) { //����Լ��
		    			  testResult = testResult + soapReturn + "\r\nError: Violating the Invoke Constraint when calling " + opName + " operation\r\n";
		    			  String errorLog = "Error: Violating the Invoke Constraint when calling " + opName + " operation";
		    			  System.out.println(tc + " Error: Violating the Invoke Constraint when calling " + opName + " operation");
		    			  invokeC.put(tc,errorLog);
		    			  break;
		    		  }
		    		  
		    		  testResult = testResult + soapReturn + "\r\nError: Unknown error when invoke " + opName + " operation\r\n";
	    			  System.out.println(tc + " Error: Unknown error when invoke " + opName + " operation");
	    			  break;
		    		  
		    	  }
		      }else {
		    	  testResult = testResult  + "Error: Violating the Parameter Range Constraint when calling " + opName + " operation\r\n";
//		    	  paramRangeC.add(tc);
		    	  String errorLog = "Error: Violating the parameter range constraint when calling " + opName + " operation";
		    	  System.out.println(tc + " Error: Violating the parameter range constraint when calling " + opName + " operation");
		    	  paramRangeC.put(tc,errorLog);
		    	  break;
		    	  //TDOD Υ���˲���Լ����������Ҫ��������
		      }
//		      System.out.println("++++++++++++++++++");
//		      System.out.println(elmEnvelope.asXML());
//		      System.out.println("*****************");
//		      String soapReturn = si.sendSoap(opName,elmEnvelope.asXML());
//		      System.out.println(soapReturn);
//		      System.out.println("*****************");
//		      System.out.println(findSoapReturn(soapReturn));
//		      System.out.println(opName);
//		      System.out.println(body.asXML());
//		      System.out.println(validateXMLSchema(body.asXML()));

		}
		writeResultFile(resultFile,testResult);
	}
	
	/**
	 * �ж�SOAP�е�body�����Ƿ����xsd���
	 * @param opName
	 * @param envelope
	 * @param body
	 * @return
	 */
	public boolean validateXMLSchema(String body) {
		File xsdPath = new File("CBWSTC_WorkSpace/Projects/" + name + "/XSD/" + name + ".xsd");
		SchemaFactory factory = 
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema;
		try {
			schema = factory.newSchema(xsdPath);
			Validator validator = schema.newValidator();
			InputStream is = new ByteArrayInputStream(body.getBytes());
			InputStreamReader ir = new InputStreamReader(is);
            validator.validate(new StreamSource(ir));
//			validator.validate(new StreamSource(body));
		} catch (IOException | SAXException |NullPointerException e) {
			// TODO Auto-generated catch block
//			System.out.println("Exception: "+e.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * ִ�е��ò����󣬻�ȡ�����body���ݣ����ڽ��з��ظ�ʽ��֤
	 * @param soapResult
	 * @return
	 */
	public int findSoapReturn(String soapResult) { //ԭ����public String findSoapReturn(String soapResult)
		int flag = 0;
//		String body = "";
//		try {
//			Document document = DocumentHelper.parseText(soapResult);
//			Element root = document.getRootElement();
//			List<?> nodes = root.element("Body").elements();
//			Element elm = (Element)nodes.get(0);
//			body = elm.asXML();
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return body;
		if(soapResult.contains("No such method") && soapResult.contains("soapenv:Server")) {
			flag = 1; //�����ṩ�Ĳ������Ƴ�
			return flag;
		}else if(soapResult.contains("soapenv:Fault") && soapResult.contains("faultcode") && soapResult.contains("faultstring")) {
			flag = 2; //����ִ�г���
			return flag;
		}else {
			return flag;
		}
	}
	
	public void writeResultFile(String path,String content) {
		FileOutputStream out;
		try {
			out = new FileOutputStream(path);
			BufferedWriter outfile = new BufferedWriter(new OutputStreamWriter(out));
			try {
				outfile.write(content);
				outfile.flush();
				outfile.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HashMap<String,String> geteTimeC() {
		return eTimeC;
	}
	
	public HashMap<String,String> getparamRangeC() {
		return paramRangeC;
	}
	
	public HashMap<String,String> getsequenceC() {
		return sequenceC;
	}
	
	public HashMap<String,String> getcallC() {
		return callC;
	}
	
	public HashMap<String,String> getparamRelationC() {
		return paramRelationC;
	}
	
	public HashMap<String,String> getinvokeC() {
		return invokeC;
	}
	
	public HashMap<String,String> getipRangeC() {
		return ipRangeC;
	}
	
	public void getArray() {
		
		System.out.println("eTimeC: " + eTimeC.size());
		System.out.println("paramRangeC: " + paramRangeC.size());
		System.out.println("sequenceC: " + sequenceC.size());
		System.out.println("callC: " + callC.size());
		System.out.println("paramRelationC: " + paramRelationC.size());
		System.out.println("invokeC: " + invokeC.size());
	}
	
	private boolean assertIp(String ipSection) {
		if(ipSection.equals("NullConstraint")) {
			return true;
		}
		ipSection = ipSection.trim();

        String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       int idx = ipSection.indexOf('-');

        String beginIP = ipSection.substring(0, idx);

        String endIP = ipSection.substring(idx + 1);

       return getIp2long(beginIP)<=getIp2long(ip) &&getIp2long(ip)<=getIp2long(endIP);
	}
	
	private static long getIp2long(String ip) {

        ip = ip.trim();

        String[] ips = ip.split("\\.");

       long ip2long = 0L;

       for (int i = 0; i < 4; ++i) {

            ip2long = ip2long << 8 | Integer.parseInt(ips[i]);

        }

       return ip2long;

    }

}
