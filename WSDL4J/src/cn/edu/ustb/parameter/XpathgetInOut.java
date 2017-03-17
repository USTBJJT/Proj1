package cn.edu.ustb.parameter;


import java.util.List;



import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;



/**
 * 该类进行操作消息的参数解析，存在如下几个情况：
 * 1.相应消息无参数(无输入或者输出):根element标签下没有element了,且该根element没有type
 * 2.相应消息有输入输出:根element下有element(根element标签下没有element了但根element有type),但是该element的type为用户定义(此刻需要搜索用户定义的type所在的complex或者simple标签)
 * 3.相应消息有输入输出:根element下有element,但是该element没有type,则该element有约束,搜素其下面的simple，找到约束和base type即可
 * @author Administrator
 *
 */
public class XpathgetInOut {
	
	
	private static Element root;
	/**
	 * 判断该参数类型是否为用户自定义类型，如果不是，则返回true
	 * @param typestring
	 * @return
	 */
	public static boolean isSchema(String typestring) {
		if(typestring.substring(0,typestring.indexOf(":")).equals("xsd")) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断该节点中是否含有Type属性
	 * @param node 要做判断的节点
	 * @return
	 */
	public static boolean hasType(Node node) {
		
		if(node.selectSingleNode("attribute::type") != null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * 获取需要解析的操作消息
	 * (此功能并不解析该类型约束信息及用户自定义类型详细解析)
	 * @param url xsd文件路径
	 * @param PartElementName 指定操作消息的partElementName
	 */
	public static void getPartElementName_Element(String url, String PartElementName) {
		
		//使用Dom4j读取XSD文档，并获取根节点,该文档从schema标签开始
		Document doc = XMLHelper.openXSDFile(url);
		root = doc.getRootElement();
		
		//获取schema节点
//		Element e_schema = root.element("types").element("schema");
//		e_schema.element("element").elementByID(PartElementName);
//		List<org.dom4j.Element> e_ele_list = (List<org.dom4j.Element>)e_schema.elements("element");
//		for (org.dom4j.Element e : e_ele_list) {
//		}
		
		//找到指定的PartElementName的操作消息所在的element
		String xpathExpr_InOut_elment = "/schema/element[@name='"+ PartElementName  +"']";
		Element InOut_elment = (Element) root.selectSingleNode(xpathExpr_InOut_elment);
//		String testxml = InOut_elment.asXML();
//		System.out.println(testxml);
		getBasicTypes_Element(InOut_elment);
			
	}
	
	/**
	 * 获取每个操作消息的基础参数名称及其类型(此功能并不解析该类型约束信息)
	 * @param ele
	 */
	public static void getBasicTypes_Element(Element ele) {
		//获取当前element节点下的所有子孙element节点
				@SuppressWarnings("unchecked")
				List<Element> param_element = (List<Element>)ele.selectNodes("descendant::element");
				List<Element> param_attribute = (List<Element>)ele.selectNodes("descendant::attribute");
				//如果存在该节点
				if(param_element != null && param_element.size() > 0) {
					//遍历该节点，获取参数名称及类型
					for(Element e: param_element) {
					
						String param_name = e.attribute("name").getValue();
						System.out.println(param_name);
						
						if(hasType(e)) {
							
							String param_type = e.selectSingleNode("attribute::type").getText();
							
							if(isSchema(param_type)) {
								
								System.out.println(param_type);
								
							}else {//如果参数类型不为schema类型，即为用户自定义类型，有可能是复合类型或者该参数有其他约束
								param_type = param_type.split(":")[1];
								String find_comples_path = "//complexType[@name='" + param_type  +"']";
								Element e_complexType = (Element) root.selectSingleNode(find_comples_path);
								String find_simple_path = "//simpleType[@name='" + param_type  +"']";
								Element e_simpleType = (Element) root.selectSingleNode(find_simple_path);
								
								if(e_complexType != null) {//复合类型，找该类型的complexType标签下的element
									getBasicTypes_Element(e_complexType);
								}else if(e_simpleType != null) {//有约束，找该类型的simpleType标签下的restriction
									findRestriction(e_simpleType);
								}else {
									System.out.println("该类型没有定义");
								}
								
							}
						}else { //该参数有其他约束的参数
							findRestriction(e);
						}
						
					}
				
				}else if(param_attribute != null && param_attribute.size() > 0) {
					for(Element e: param_attribute) {
						String param_attribute_name = e.selectSingleNode("attribute::name").getText();
						String param_attribute_type = e.selectSingleNode("attribute::type").getText();
						System.out.println(param_attribute_name);
						System.out.println(param_attribute_type);
					}
					
				}else {
					//该消息也许是响应消息，并且该消息没有返回值,或者说是输入参数为空的消息
					String param_name = ele.attribute("name").getValue();
					System.out.println(param_name);
					
					
					if(hasType(ele)) {
						String param_type = ele.selectSingleNode("attribute::type").getText();

						if(isSchema(param_type)) {
							
							System.out.println(param_type);
							
						}else {//如果参数类型不为schema类型，即为用户自定义类型
							param_type = param_type.split(":")[1];
							String find_comples_path = "//complexType[@name='" + param_type  +"']";
							Element e_complexType = (Element) root.selectSingleNode(find_comples_path);
							String find_simple_path = "//simpleType[@name='" + param_type  +"']";
							Element e_simpleType = (Element) root.selectSingleNode(find_simple_path);
							
							if(e_complexType != null) {//复合类型，找该类型的complexType标签下的element
								getBasicTypes_Element(e_complexType);
							}else if(e_simpleType != null) {//有约束，找该类型的simpleType标签下的restriction
								findRestriction(e_simpleType);
							}else {
								System.out.println("该类型没有定义");
							}
							
						}
					}else {
						System.out.println("Null(该消息没有输入参数要求或返回值)");
					}
					
				}
	}
	
	/**
	 * 获取某一参数的基本约束(base\length\pattern\minInclusive\maxInclusive\minExclusive\maxExclusive\minlength\maxlength)
	 * @param re
	 */
	public static void findRestriction(Element re) {
		
		String restriction = "descendant::restriction";
		
		Element type_res = (Element) re.selectSingleNode(restriction);
		String base = "attribute::base";
		String type_res_xml = type_res.asXML();
		String type =  type_res.selectSingleNode(base).getText();
		System.out.println(type);
		System.out.println(type_res_xml);
		
	}
	
//	public static void main(String[] args) {
//		
//		getPartElementName_Element("E://ExFile//Air.xsd","feeCalculation");
//		System.out.println("===================================================");
//		getPartElementName_Element("E://ExFile//Air.xsd","feeCalculationResponse");
//		System.out.println("===================================================");
//		getPartElementName_Element("E://ExFile//Air.xsd","MACException");
////		getPartElementName_Element("E://ExFile//ATM.xsd","loginRequest");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","loginResponse");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","withdrawRequest");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","withdrawResponse");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","depositRequest");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","depositResponse");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","transferRequest");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","transferResponse");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","queryBalanceRequest");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","changePasswordRequest");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","changePasswordResponse");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","insertAccountRequest");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","insertAccountResponse");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","deleteAccountRequest");
////		System.out.println("===================================================");
////		getPartElementName_Element("E://ExFile//ATM.xsd","deleteAccountResponse");
//	}

}
