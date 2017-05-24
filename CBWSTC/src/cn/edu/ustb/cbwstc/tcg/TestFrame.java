package cn.edu.ustb.cbwstc.tcg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.support.SoapUIException;

public class TestFrame {
	
	/**
	 * ’Î∂‘…˙≥…≤‚ ‘øÚº‹
	 * @param wsdlURL
	 * @param Operation
	 * @param OpIName
	 * @param name
	 */
	public static void generTestF(String wsdlURL, String Operation, String OpIName, String name) {
		WsdlInterface iface;
		try {
			iface = WsdlInterfaceFactory.importWsdl(
					new WsdlProject(), wsdlURL, true)[0];
			WsdlOperation operation0 = (WsdlOperation) iface.getOperationByName(Operation);
			String requestFram0 =  operation0.createRequest(true);//…˙≥…≤‚ ‘øÚº‹(≤‚ ‘ ˝æ›Œ¥ÃÓ≥‰)
			File fw = new File("CBWSTC_WorkSpace/Projects/" + name + "/XML/" + OpIName + ".xml");
			BufferedWriter bw = new BufferedWriter(new FileWriter(fw));
			bw.write(requestFram0);
			bw.flush();
			bw.close();
		} catch (SoapUIException | XmlException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
