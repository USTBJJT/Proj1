package cn.edu.ustb.cbwstc.Experiment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.xmlbeans.XmlException;

import cn.edu.ustb.cbwstc.config.CreatMkdir;
import cn.edu.ustb.cbwstc.util.SoapInvoker;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.model.iface.Request.SubmitException;
import com.eviware.soapui.support.SoapUIException;

public class WebServiceEndp {
	
	private static HashSet<String> s = new HashSet<String>(); //变异体集合
	private static File[] array; //测试用例集合
	private static WsdlOperation operation;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		init();
//		runTestCase();
////		runTestCase();
//		findSMutants();
		String sendMessage = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pfc=\"http://pfc.simple.ws\"><soapenv:Header/><soapenv:Body><pfc:login><!--anonymous type--><pfc:License>京K86333</pfc:License><!--anonymous type--><pfc:loginTime>3</pfc:loginTime></pfc:login></soapenv:Body></soapenv:Envelope>";
		String endpoint = "";
		System.out.println(soapSend(sendMessage,endpoint));
		System.exit(0);
	}
	/**
	 * 初始化测试用例集和变异体集合
	 */
	public static void init() {
		
		//get Mutants Name
		File f = new File("E:/GraduateExpermentalPrograms/Experiment/ERS/Random/calculateReimbursementAmount/Mutants/mutants.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String str = null;
			try {
				while((str = br.readLine()) != null) {
					s.add(str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get Test Cases
		 File file = new File("E:/GraduateExpermentalPrograms/Experiment/ERS/Random/calculateReimbursementAmount/TestCase");
		 array = file.listFiles();
		 
		 String wsdl = "http://localhost:8080/axis2/services/ExpenseReimbursementSystem?wsdl";
		 WsdlInterface iface;
		 try {
			iface = WsdlInterfaceFactory.importWsdl(new WsdlProject(), wsdl, true)[0];
			operation = (WsdlOperation) iface.getOperationByName("calculateReimbursementAmount");
		} catch (SoapUIException | XmlException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	/**
	 * 读取测试用例内容
	 * @param tcPath
	 * @return
	 */
	public static String getTestCase(String tcPath) {
		String soapWithData = "";
		File file = new File(tcPath);
		Long fileLengthLong = file.length();  
		byte[] fileContent = new byte[fileLengthLong.intValue()];  
		try {  
		        FileInputStream inputStream = new FileInputStream(file);  
		        inputStream.read(fileContent);  
		        inputStream.close();  
		} catch (Exception e) {  
		    // TODO: handle exception  
		}  
		soapWithData = new String(fileContent);
		return soapWithData;
	}
	
	public static void writeResult(String path,String result) {
		FileWriter fw;
		try {
			fw = new FileWriter(path, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(result);// 往已有的文件上添加字符串
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 执行测试用例
	 */
	public static void runTestCase() {
		for(int i=0;i<array.length;i++){
			ArrayList<String> kill = new ArrayList<String>(); //被杀死的变异体
			String tcrMkdir = "E:/GraduateExpermentalPrograms/Experiment/ERS/Random/calculateReimbursementAmount/Results/" + array[i].getName().split("\\.")[0];
			CreatMkdir.creatMkdir(tcrMkdir);
			String original = soapSend(getTestCase(array[i].getAbsolutePath()),"");
			writeResult(tcrMkdir + "/source.txt",original);
			Object[] so = s.toArray();
			for(int j=0;j<so.length;j++) {
				String mutant = soapSend(getTestCase(array[i].getAbsolutePath()),so[j].toString());
				if(!original.equals(mutant)) {
					String resultFile = tcrMkdir + "/" + so[j] + ".txt";
					writeResult(resultFile,mutant);
					kill.add(so[j].toString());
				}
			}
			for(int k=0;k<kill.size();k++) {
				s.remove(kill.get(k));
			}
			
//			System.out.println(getTestCase(array[i].getAbsolutePath()));
//			 //array[i].getAbsolutePath() 文件绝对路径，读取时使用，
//			 tc.add(array[i].getName().split("\\.")[0]);
		 }
//		String wsdl = "http://localhost:8080/axis2/services/ExpenseReimbursementSystem?wsdl";
//		WsdlInterface iface;
//		try {
//			iface = WsdlInterfaceFactory.importWsdl(
//					new WsdlProject(), wsdl, true)[0];
//			WsdlOperation operation0 = (WsdlOperation) iface.getOperationByName("calculateReimbursementAmount");
////			System.out.println(operation0.createRequest(true));
////			System.out.println(operation0.getInterface());
//			WsdlRequest requestSource0 = operation0.addNewRequest("");
//			String soapWithData0 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exp=\"http://exp.simple.ws\"><soapenv:Header/><soapenv:Body><exp:calculateReimbursementAmount><exp:stafflevel>seniormanager</exp:stafflevel><exp:actualmonthlymileage>300</exp:actualmonthlymileage></exp:calculateReimbursementAmount></soapenv:Body></soapenv:Envelope>";
//			requestSource0.setRequestContent(soapWithData0);
//			requestSource0.setEndpoint("http://localhost:8080/axis2/services/ExpenseReimbursementSystemAORB_1/");
//			SoapInvoker si0 = new SoapInvoker();
//			try {
//				//获取结果
//				System.out.println(si0.invoke(requestSource0).getContentAsString());
//			} catch (SubmitException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (SoapUIException | XmlException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} //获取port接口
		
	}
	
	public static String soapSend(String sendMessage,String endpoint) {
		String result = "";
		WsdlRequest requestSource = operation.addNewRequest("");
		String soapWithData = sendMessage;
		requestSource.setRequestContent(soapWithData);
		requestSource.setEndpoint("http://localhost:8080/axis2/services/ParkingFeeCalculator" + endpoint + "/");
		SoapInvoker si = new SoapInvoker();
		try {
			//获取结果
			result = si.invoke(requestSource).getContentAsString();
		} catch (SubmitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void findSMutants() {
			System.out.println(s.size()-18);
	}

}
