package cn.edu.ustb.cbwstc.util;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.model.iface.Request.SubmitException;
import com.eviware.soapui.support.SoapUIException;

public class InvokeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvokeTest it = new InvokeTest();
		it.testAgent();
		System.exit(0);

	}
	/**
	 * ʹ��SOAPUI����web service
	 */
	public void testAgent() {
		String wsdl = "http://localhost:8080/ABBSDome0/services/AirlinesBaggageBillingService?wsdl";
		WsdlInterface iface;
		try {
			iface = WsdlInterfaceFactory.importWsdl(
					new WsdlProject(), wsdl, true)[0]; //��ȡport�ӿ�
			System.out.println("Operations:");
			
			//��ȡ������ں��е�ȫ������
			for (int i = 0; i < iface.getOperationCount(); i++) {
				System.out.println("    Operation" + (i + 1) + ":"
						+ iface.getOperationList().get(i).getName());
			}
			WsdlOperation operation0 = (WsdlOperation) iface.getOperationByName("loginin");
			System.out.println(operation0.createRequest(true));
			String requestFram0 =  operation0.createRequest(true);//���ɲ��Կ��(��������δ���)
			System.out.println("***********************");
			System.out.println(operation0.getOperationType());
			System.out.println(requestFram0);
			System.out.println("***********************");
			WsdlRequest requestSource0 = operation0.addNewRequest("requestSource");
			String soapWithData0 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:abbs=\"http://abbs.simple.ws\"><soapenv:Header/><soapenv:Body><abbs:loginin><abbs:name>userName</abbs:name></abbs:loginin></soapenv:Body></soapenv:Envelope>";
			requestSource0.setRequestContent(soapWithData0);
//			requestSource0.setEndpoint("");
			SoapInvoker si0 = new SoapInvoker();
			try {
				//��ȡ���
				System.out.println(si0.invoke(requestSource0).getContentAsString());
			} catch (SubmitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			//�������һ����������
			WsdlOperation operation = (WsdlOperation) iface
				.getOperationByName("feeCalculation");
			//operation.createRequest(true); ���Ի�ȡ����opration�Ŀ��(�����Ŀ��)
			System.out.println(operation.createRequest(true));
			
			String requestFram =  operation.createRequest(true);//���ɲ��Կ��(��������δ���)
			
			//����������(�޸Ĳ��Կ��)
			WsdlRequest requestSource = operation
					.addNewRequest("requestSource");
			String soapWithData = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:abbs=\"http://abbs.simple.ws\"><soapenv:Header/><soapenv:Body><abbs:feeCalculation><abbs:chooseAirClass>2</abbs:chooseAirClass><abbs:chooseArea>0</abbs:chooseArea><abbs:isStudent>true</abbs:isStudent><abbs:luggage>50</abbs:luggage><abbs:economicfee>300</abbs:economicfee></abbs:feeCalculation></soapenv:Body></soapenv:Envelope>";
			requestSource.setRequestContent(soapWithData);
//			System.out.println(requestSource.getEndpoint());
			
			//׼�����÷������
			SoapInvoker si = new SoapInvoker();
			try {
				//��ȡ���
				System.out.println(si.invoke(requestSource).getContentAsString());
			} catch (SubmitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(requestSource.getRequestContent());
//			WsdlSubmitContext wsmc = new WsdlSubmitContext(requestSource);
//			System.out.println(wsmc);
			//requestSource.setRequestContent("");
		} catch (SoapUIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
