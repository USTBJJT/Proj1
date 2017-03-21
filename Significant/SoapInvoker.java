package cn.edu.ustb.invokeWebS;

import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.WsdlSubmit;
import com.eviware.soapui.impl.wsdl.WsdlSubmitContext;
import com.eviware.soapui.model.iface.Request.SubmitException;
import com.eviware.soapui.model.iface.Response;

/**
 * 
 * @author JJT
 *����request����ʹ��SOAPUI���÷��񣬻�ȡ���ý��
 */
public class SoapInvoker {
	
	public Response invoke(WsdlRequest request) throws SubmitException {
		WsdlSubmit submit = (WsdlSubmit) request.submit(new WsdlSubmitContext(
				request), false);

		// wait for the response
		Response response = submit.getResponse();
		return response;
	}

	public Object invoke(Object request) {
		if (request instanceof WsdlRequest) {
			try {
				WsdlRequest wsdlRequest = (WsdlRequest) request;
				return invoke(wsdlRequest);
			} catch (SubmitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return null;
	}

}
