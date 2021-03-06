package cn.edu.ustb.invokeWebS;

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

	}
	/**
	 * 使用SOAPUI测试web service
	 */
	public void testAgent() {
		String wsdl = "E://AirlinesBaggageBillingService.wsdl";
		WsdlInterface iface;
		try {
			iface = WsdlInterfaceFactory.importWsdl(
					new WsdlProject(), wsdl, true)[0]; //获取port接口
			System.out.println("Operations:");
			
			//获取该入口内含有的全部操作
			for (int i = 0; i < iface.getOperationCount(); i++) {
				System.out.println("    Operation" + (i + 1) + ":"
						+ iface.getOperationList().get(i).getName());
			}
			
			//针对其中一个操作进行
			WsdlOperation operation = (WsdlOperation) iface
				.getOperationByName("feeCalculation");
			//operation.createRequest(true); 可以获取调用opration的框架(参数的框架)
			System.out.println(operation.createRequest(true));
			
			String requestFram =  operation.createRequest(true);//生成测试框架(测试数据未填充)
			
			//填充测试数据(修改测试框架)
			WsdlRequest requestSource = operation
					.addNewRequest("requestSource");
			String soapWithData = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:abbs=\"http://abbs.simple.ws\"><soapenv:Header/><soapenv:Body><abbs:feeCalculation><abbs:chooseAirClass>0</abbs:chooseAirClass><abbs:chooseArea>0</abbs:chooseArea><abbs:isStudent>true</abbs:isStudent><abbs:luggage>50</abbs:luggage><abbs:economicfee>300</abbs:economicfee></abbs:feeCalculation></soapenv:Body></soapenv:Envelope>";
			requestSource.setRequestContent(soapWithData);
			System.out.println(requestSource.getEndpoint());
			
			//准备调用服务操作
			SoapInvoker si = new SoapInvoker();
			try {
				//获取结果
				System.out.println(si.invoke(requestSource).getContentAsString());
			} catch (SubmitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(requestSource.getRequestContent());
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
