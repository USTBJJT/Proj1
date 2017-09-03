package cn.edu.ustb.cbwstc.Experiment;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import cn.edu.ustb.cbwstc.util.SoapInvoker;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.model.iface.Request.SubmitException;
import com.eviware.soapui.support.SoapUIException;

/**
 * 针对调用操作发送测试数据，获取测试结果
 * @author Administrator
 *
 */
public class SendWsdlInterface {
	
	private  String wsdl = "";
	private WsdlInterface iface;
	
	public SendWsdlInterface(String wsdl) {
		this.wsdl = wsdl;
		try {
			iface = WsdlInterfaceFactory.importWsdl(new WsdlProject(), wsdl, true)[0];
		} catch (SoapUIException | XmlException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String sendSoap(String oper,String soapMessage) {
		String soapResult = "";
		WsdlOperation operation = (WsdlOperation) iface.getOperationByName(oper);
		WsdlRequest requestSource = operation.addNewRequest("");
		String soapWithData = soapMessage;
		requestSource.setRequestContent(soapWithData);
		SoapInvoker si = new SoapInvoker();
		try {
			//获取结果
			soapResult = si.invoke(requestSource).getContentAsString();
		} catch (SubmitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soapResult;
	}

}
