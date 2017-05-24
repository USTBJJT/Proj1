package cn.edu.ustb.cbwstc.wsdl.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.wsdl.Part;





import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.dom4j.QName;
import org.w3c.dom.Node;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;
import com.eviware.soapui.impl.wsdl.support.xsd.SchemaLoader;
import com.eviware.soapui.impl.wsdl.support.xsd.SchemaUtils;
import com.eviware.soapui.support.SoapUIException;

public class GetXML {
	
	public static void getParameter(String wsdlURL, String Operation, String OpIName, String name) {
		WsdlInterface iface;
			try {
				iface = WsdlInterfaceFactory.importWsdl(
						new WsdlProject(), wsdlURL, true)[0];
				WsdlOperation operation0 = (WsdlOperation) iface.getOperationByName(Operation);
				String requestFram0 =  operation0.createRequest(true);//生成测试框架(测试数据未填充)
				File fw = new File("CBWSTC_WorkSpace/Projects/" + name + "/XML/" + OpIName + ".xml");
				BufferedWriter bw = new BufferedWriter(new FileWriter(fw));
				bw.write(requestFram0);
				bw.flush();
				bw.close();
			} catch (SoapUIException | XmlException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //获取port接口
	}
	
//	public static void myJtry(javax.xml.namespace.QName q) {
//		WsdlInterface iface;
//		try {
//			iface = WsdlInterfaceFactory.importWsdl(
//					new WsdlProject(), "http://localhost:8080/axis2/services/ExpenseReimbursementSystem?wsdl", true)[0];
//			WsdlContext wsdlContext = iface.getWsdlContext();
//			try {
//				SchemaType element = wsdlContext.getSchemaTypeLoader().findDocumentType(q);
////				XmlObject object = XmlObject.Factory.newInstance()
////				XmlCursor cursor = object.newCursor();
////				cursor.beginElement("stafflevel");
////				Node simpleNode = cursor.getDomNode();
//				
//				System.out.println("##############");
////				System.out.println(element.getContentModel().getIntMaxOccurs());
//				System.out.println(element.getName());
////				SchemaParticle sp;
////				sp.
//				System.out.println("##############");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (SoapUIException | XmlException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
