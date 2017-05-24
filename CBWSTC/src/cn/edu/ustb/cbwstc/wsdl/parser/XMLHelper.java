package cn.edu.ustb.cbwstc.wsdl.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLHelper {
	
	public static Document openXMLFile(String filePath) {
		Document document = null;
		SAXReader reader = new SAXReader();
		try {
			File file = new File(filePath);
			document = reader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}
	
//	public static org.w3c.dom.Document javaxXML(String file) {
//		org.w3c.dom.Document doc = null;
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		try {
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			try {
//				doc = builder.parse(file);
//			} catch (SAXException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return doc;
//	}
	
//	public static void myXMLBean(File filePath) {
//		
//			
//		XmlObject xobj;
//			try {
//				try {
//					xobj = XmlObject.Factory.parse(filePath);
//					Node root = xobj.getDomNode();
//					Node schema = root.getFirstChild();
//					Node e = schema.getFirstChild();
//					System.out.println(schema.getPrefix());
//					System.out.println(schema.getLocalName());
//					System.out.println(schema.getNamespaceURI());
////					Element e = (Element) schema;
////					SchemaType etype = (SchemaType) e.getSchemaTypeInfo();
////					SchemaLocalElement element = (SchemaLocalElement) e.getFirstChild();
////					System.out.println(root.getFirstChild().getNodeName());
//				} catch (XmlException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//	
//	}
	
	public static void getWsdlDoc(String WsdlURI,String name) {
		//String name = WsdlURI.substring(WsdlURI.lastIndexOf("/")+1, WsdlURI.length()-5);
		WSDLFactory factory;
		try {
			factory = WSDLFactory.newInstance();
			WSDLReader reader = factory.newWSDLReader();
			reader.setFeature("javax.wsdl.verbose", true);
			reader.setFeature("javax.wsdl.importDocuments", false);
			Definition def = reader.readWSDL(WsdlURI);
			Writer xmlWriter;
			try {
				xmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("CBWSTC_WorkSpace/Sources/" + name + ".wsdl")));
				WSDLWriter wsdlWriter = factory.newWSDLWriter();
				wsdlWriter.writeWSDL(def, xmlWriter);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		} catch (WSDLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
