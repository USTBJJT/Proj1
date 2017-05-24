package cn.edu.ustb.cbwstc.wsdl.parser;


import java.io.File;
import java.util.List;

import org.apache.ws.commons.schema.XmlSchemaMaxExclusiveFacet;
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeRestriction;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlDateTime;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.w3c.dom.NodeList;

public class GetParameter {
	
//	static org.w3c.dom.Document xsddocument = XMLHelper.DomRead("CBWSTC_WorkSpace/Projects/ExpenseReimbursementSystem/XSD/ExpenseReimbursementSystem.xsd");
//	public static boolean isSimpleType(Element e) {
//		List<Element> list = e.elements();
//		if(list.isEmpty()) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	
//	public static void A(String name,String OprI) {//
//		try {
//			File f = new File("CBWSTC_WorkSpace/Projects/ExpenseReimbursementSystem/XSD/ExpenseReimbursementSystem.xsd");
//			XmlObject xobj;
//			try {
//				xobj = XmlObject.Factory.parse(f);
//				XmlObject[] xobjS = null;
//				XmlBeans.loadXsd(xobjS);
//				List<XmlObject> xobjl = new ArrayList();
//				xobjl.add(xobj);
//				try {
//					SchemaUtils.getSchemas(wsdlUrl, loader)
//				} catch (SchemaException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println(SchemaUtils.getTargetNamespace(xobj));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		} catch (XmlException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Document document = XMLHelper.openXMLFile("CBWSTC_WorkSpace/Projects/ExpenseReimbursementSystem/XSD/ExpenseReimbursementSystem.xsd");
//		Element root = document.getRootElement();
//		Element sequence = root.element("element").element("complexType").element("sequence");
//		List<Element> list = sequence.elements();
//		for(Element e : list) {
//			SchemaUtils.getTargetNamespace(s)
//			SchemaType type = e.getNodeType();
//		}
//		Document document = XMLHelper.openXMLFile("CBWSTC_WorkSpace/Projects/" + name + "/XML/" + OprI + ".xml");
//		Element root = document.getRootElement();
//		Element body = root.element("Body");
//		Element OpIP = body.element(OprI);
//		List<Element> list = OpIP.elements();
//		for(Element e : list) {
//			if(isSimpleType(e)) {
//				if(e.getName().equals("stafflevel")) {
//					System.out.println(e.attributeValue("type"));
//					XmlSchemaSimpleTypeRestriction restriction = new XmlSchemaSimpleTypeRestriction();
//			        XmlSchemaMaxExclusiveFacet maxExclusive = new XmlSchemaMaxExclusiveFacet();
//			        restriction.addMetaInfo(maxExclusive, "5");
//					int Type = SchemaType.BTC_BOOLEAN;
//					SchemaType s = (SchemaType) OpIP;
//					System.out.println(SchemaType.BTC_BOOLEAN);
//				}
//				System.out.println(e.getName());
//				System.out.println(e.getPath());
//				
//			}else {
//				
//			}
//		}
//	}
	
//	public static void main(String[] args) {
//		A();
//		String f = "CBWSTC_WorkSpace/Projects/ExpenseReimbursementSystem/XSD/ExpenseReimbursementSystem.xsd";
//		org.w3c.dom.Document d = XMLHelper.javaxXML(f);
//		org.w3c.dom.Element root = d.getDocumentElement();
//		NodeList rcollegeNodes = root.getElementsByTagName("element");
//		for(int i = 0; i < rcollegeNodes.getLength(); i++) {
//			org.w3c.dom.Node rcollege = rcollegeNodes.item(i);
//			if(rcollege.getAttributes().getNamedItem("name").getNodeValue().equals("totalAmount")) {
//				NodeList ecollegeNodes = rcollege.getChildNodes();
//				for(int j = 0; j < ecollegeNodes.getLength(); j++) {
//					org.w3c.dom.Node ecollege = ecollegeNodes.item(j);
//					if(ecollege.getAttributes().getNamedItem("name").getNodeValue().equals(""))
//					{
//						
//					}else {
//						System.out.println("kk" + ecollege.getAttributes().getNamedItem("name").getNodeValue());
//					}
//					
//					if(ecollege.getAttributes().getNamedItem("name").getNodeValue() == "tstafflevel") {
//						System.out.println(ecollege.getAttributes().getNamedItem("name").getNodeValue());
//						org.w3c.dom.Element ecollegeE = (org.w3c.dom.Element) ecollege;
//						System.out.println(ecollegeE.getSchemaTypeInfo());
//					}
//				}
//			}
//		}
//		System.out.println(root.getElementsByTagName("element").item(0).getAttributes().getNamedItem("name").getNodeValue());
//		NodeList collegeNodes = root.getChildNodes();
//		System.out.println(collegeNodes.getLength());
//		for(int i = 0; i < collegeNodes.getLength(); i++) {  
//            org.w3c.dom.Node college = collegeNodes.item(i);
//            System.out.println(college.getNodeType());
//		}
//		System.out.println(root.getAttribute("elementFormDefault"));
//		SchemaType stype = new SchemaType();
//		Document d = XMLHelper.openXMLFile(f);
//		Element root = d.getRootElement();
//		List<org.dom4j.Element> elist = (List<org.dom4j.Element>)root.elements();
//		for (Element e : elist) {
//			if(e.attribute("name").getValue().equals("totalAmountResponse")) {
//				Element rElement = e.element("complexType").element("sequence").element("element");
//				GetXML.myJtry(rElement.getQName());
//			}
////			System.out.println(e.attribute("name").getValue());
//		}
//		System.out.println(root.getQName());
//		Element e = root.element("totalAmount");
//		System.out.println(root.getPath());
		
//		XMLHelper.myXMLBean(f);
//		A("ExpenseReimbursementSystem","airfareReimbursement");
//	}
	
	

}
