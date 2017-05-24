package cn.edu.ustb.cbwstc.wsdl.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

public class GetXsd {
	
	public static void getXsd(String WsdlURI,String name) {
		XMLHelper.getWsdlDoc(WsdlURI,name);
		File f = new File("CBWSTC_WorkSpace/Sources/" + name + ".wsdl");
		if(f.exists()) {
			readXsd("CBWSTC_WorkSpace/Sources/" + name + ".wsdl",name);
		}
	}
	
	public static void readXsd(String f,String name) {
		Document document = XMLHelper.openXMLFile(f);
		Element definitions = document.getRootElement();
		Element types = definitions.element("types");
		Element schema = types.element("schema");
		File fw = new File("CBWSTC_WorkSpace/Projects/" + name + "/XSD/" + name + ".xsd");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fw));
			bw.write(schema.asXML());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
