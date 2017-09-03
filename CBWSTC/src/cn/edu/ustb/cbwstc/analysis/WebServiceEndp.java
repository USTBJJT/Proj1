package cn.edu.ustb.cbwstc.analysis;

import java.io.IOException;
import java.util.HashSet;

import org.apache.xmlbeans.XmlException;

import cn.edu.ustb.cbwstc.util.SoapInvoker;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.model.iface.Request.SubmitException;
import com.eviware.soapui.support.SoapUIException;

public class WebServiceEndp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mytry();
		System.exit(0);
	}
	
	public static void setSet() {
		HashSet<String> s = new HashSet<String>();
		
	}
	
	public static void mytry() {
		String wsdl = "http://localhost:8080/axis2/services/ExpenseReimbursementSystem?wsdl";
		WsdlInterface iface;
		try {
			iface = WsdlInterfaceFactory.importWsdl(
					new WsdlProject(), wsdl, true)[0];
			WsdlOperation operation0 = (WsdlOperation) iface.getOperationByName("calculateReimbursementAmount");
//			System.out.println(operation0.createRequest(true));
//			System.out.println(operation0.getInterface());
			WsdlRequest requestSource0 = operation0.addNewRequest("");
			String soapWithData0 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exp=\"http://exp.simple.ws\"><soapenv:Header/><soapenv:Body><exp:calculateReimbursementAmount><exp:stafflevel>seniormanager</exp:stafflevel><exp:actualmonthlymileage>300</exp:actualmonthlymileage></exp:calculateReimbursementAmount></soapenv:Body></soapenv:Envelope>";
			requestSource0.setRequestContent(soapWithData0);
			requestSource0.setEndpoint("http://localhost:8080/axis2/services/ExpenseReimbursementSystemAORB_1/");
			SoapInvoker si0 = new SoapInvoker();
			try {
				//获取结果
				System.out.println(si0.invoke(requestSource0).getContentAsString());
			} catch (SubmitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SoapUIException | XmlException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //获取port接口
		
	}

}
