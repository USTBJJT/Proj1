package cn.edu.ustb.parser;

import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.Types;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

public class ReadDef {
	
	public static void DefInterface(String str) {
		
		System.out.println("---------------Service Parse---------------");
		Definition mydef = readWsdl10(str);
		System.out.println("WSDL Target Namespace: " + mydef.getTargetNamespace());
		Map services = mydef.getServices();
		Binding2Operation.B2OInterface(services);
	}
	
	
	/**
	 * A real WSDL Reader for WSDL1.1
	 * @author JiaJingting
	 *
	 */
	public static Definition readWsdl10(String WsdlURL) {
		WSDLFactory factory;
		try {
			
			factory = WSDLFactory.newInstance();
			WSDLReader reader=factory.newWSDLReader();
			
			/*public void setFeature(java.lang.String name,boolean value) throws java.lang.IllegalArgumentException
			if "javax.wsdl.verbose" is true, status messages will be displayed.
			状态消息将被显示
			if "javax.wsdl.importDocuments" is true, imported WSDL documents will be retrieved and processed
			导入的WSDL文件将被检索和处理*/
			reader.setFeature("javax.wsdl.verbose",true);  
			reader.setFeature("javax.wsdl.importDocuments",true);
			
			//获取服务的definitions根节点
			Definition def=reader.readWSDL(WsdlURL);
			return def;
			
		} catch (WSDLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return null;
	}

}
