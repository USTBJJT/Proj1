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
import java.util.ArrayList;
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
	
	private static ArrayList<String> paramRangeC = new ArrayList<String>();
	private static ArrayList<String> sequenceC = new ArrayList<String>();
	private static ArrayList<String> callC = new ArrayList<String>();
	private static ArrayList<String> paramRelationC = new ArrayList<String>();
	
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
				if(uri.equals("http://localhost:8080/axis2/services/ParkingFeeCalculator?wsdl")) {
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
		      if(validateXMLSchema(body.asXML())) {
		    	  String soapReturn = si.sendSoap(opName,elmEnvelope.asXML());
		    	  boolean flag = findSoapReturn(soapReturn);
		    	  if(flag) {
		    		  sequence = sequence + opName + opName + "Response_succ";
		    		  testResult = testResult + soapReturn  + "\r\n";
		    	  }else {
		    		  //TODO Υ��������Լ��������Լ����������ϵԼ������Լ�������� ��һ���ж�
		    		  //�ж��Ƿ�Υ���˵���Լ��
		    		  Node gnode = g.getNode(opName);
		    		  if(!gnode.getIterationC()) {// ���ظ�����Լ��
		    			  String rule = gnode.getName() + "Response_succ#ef#" + gnode.getName();
		    			  if(ts.contains(rule)) {
		    				  testResult = testResult + soapReturn + "\r\nError: Violating the Repeating Calls Constraint when calling " + opName + " operation\r\n";
		    				  System.out.println(tc + " Error: Violating the Repeating Calls Constraint when calling " + opName + " operation");
		    				  break;
		    			  }
		    		  }
		    		  if(! gnode.getPreOpC().equals("NullConstraint")){// ������Լ��
		    			  String regEx = gnode.getPreOpC();
		    			  RexpMatching rem = new RexpMatching();
		    			  if(! rem.check(sequence, regEx)) {
		    				  testResult = testResult + soapReturn + "\r\nError: Violating the Sequence Constraint when calling " + opName + " operation\r\n";
		    				  System.out.println(tc + " Error: Violating the Sequence Constraint when calling " + opName + " operation");
		    				  break;
		    			  }
		    		  }
		    		  testResult = testResult + soapReturn + "\r\nError: Violating the Parameter Relation Constraint when calling " + opName + " operation\r\n";
		    		  System.out.println(tc + " Error: Violating the Parameter Relation Constraint when calling " + opName + " operation");
		    		  break;
		    	  }
		      }else {
		    	  testResult = testResult  + "Error: Violating the Parameter Range Constraint when calling " + opName + " operation\r\n";
//		    	  paramRangeC.add(tc);
		    	  System.out.println(tc + " Error: Violating the parameter range constraint when calling " + opName + " operation");
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
	public boolean findSoapReturn(String soapResult) { //ԭ����public String findSoapReturn(String soapResult)
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
		
		if(soapResult.contains("soapenv:Fault") || soapResult.contains("faultcode") ||soapResult.contains("faultstring")) {
			return false;
		}else {
			return true;
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

}
