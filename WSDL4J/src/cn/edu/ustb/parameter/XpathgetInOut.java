package cn.edu.ustb.parameter;


import java.util.List;



import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;



/**
 * ������в�����Ϣ�Ĳ����������������¼��������
 * 1.��Ӧ��Ϣ�޲���(������������):��element��ǩ��û��element��,�Ҹø�elementû��type
 * 2.��Ӧ��Ϣ���������:��element����element(��element��ǩ��û��element�˵���element��type),���Ǹ�element��typeΪ�û�����(�˿���Ҫ�����û������type���ڵ�complex����simple��ǩ)
 * 3.��Ӧ��Ϣ���������:��element����element,���Ǹ�elementû��type,���element��Լ��,�����������simple���ҵ�Լ����base type����
 * @author Administrator
 *
 */
public class XpathgetInOut {
	
	
	private static Element root;
	/**
	 * �жϸò��������Ƿ�Ϊ�û��Զ������ͣ�������ǣ��򷵻�true
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
	 * �жϸýڵ����Ƿ���Type����
	 * @param node Ҫ���жϵĽڵ�
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
	 * ��ȡ��Ҫ�����Ĳ�����Ϣ
	 * (�˹��ܲ�������������Լ����Ϣ���û��Զ���������ϸ����)
	 * @param url xsd�ļ�·��
	 * @param PartElementName ָ��������Ϣ��partElementName
	 */
	public static void getPartElementName_Element(String url, String PartElementName) {
		
		//ʹ��Dom4j��ȡXSD�ĵ�������ȡ���ڵ�,���ĵ���schema��ǩ��ʼ
		Document doc = XMLHelper.openXSDFile(url);
		root = doc.getRootElement();
		
		//��ȡschema�ڵ�
//		Element e_schema = root.element("types").element("schema");
//		e_schema.element("element").elementByID(PartElementName);
//		List<org.dom4j.Element> e_ele_list = (List<org.dom4j.Element>)e_schema.elements("element");
//		for (org.dom4j.Element e : e_ele_list) {
//		}
		
		//�ҵ�ָ����PartElementName�Ĳ�����Ϣ���ڵ�element
		String xpathExpr_InOut_elment = "/schema/element[@name='"+ PartElementName  +"']";
		Element InOut_elment = (Element) root.selectSingleNode(xpathExpr_InOut_elment);
//		String testxml = InOut_elment.asXML();
//		System.out.println(testxml);
		getBasicTypes_Element(InOut_elment);
			
	}
	
	/**
	 * ��ȡÿ��������Ϣ�Ļ����������Ƽ�������(�˹��ܲ�������������Լ����Ϣ)
	 * @param ele
	 */
	public static void getBasicTypes_Element(Element ele) {
		//��ȡ��ǰelement�ڵ��µ���������element�ڵ�
				@SuppressWarnings("unchecked")
				List<Element> param_element = (List<Element>)ele.selectNodes("descendant::element");
				List<Element> param_attribute = (List<Element>)ele.selectNodes("descendant::attribute");
				//������ڸýڵ�
				if(param_element != null && param_element.size() > 0) {
					//�����ýڵ㣬��ȡ�������Ƽ�����
					for(Element e: param_element) {
					
						String param_name = e.attribute("name").getValue();
						System.out.println(param_name);
						
						if(hasType(e)) {
							
							String param_type = e.selectSingleNode("attribute::type").getText();
							
							if(isSchema(param_type)) {
								
								System.out.println(param_type);
								
							}else {//����������Ͳ�Ϊschema���ͣ���Ϊ�û��Զ������ͣ��п����Ǹ������ͻ��߸ò���������Լ��
								param_type = param_type.split(":")[1];
								String find_comples_path = "//complexType[@name='" + param_type  +"']";
								Element e_complexType = (Element) root.selectSingleNode(find_comples_path);
								String find_simple_path = "//simpleType[@name='" + param_type  +"']";
								Element e_simpleType = (Element) root.selectSingleNode(find_simple_path);
								
								if(e_complexType != null) {//�������ͣ��Ҹ����͵�complexType��ǩ�µ�element
									getBasicTypes_Element(e_complexType);
								}else if(e_simpleType != null) {//��Լ�����Ҹ����͵�simpleType��ǩ�µ�restriction
									findRestriction(e_simpleType);
								}else {
									System.out.println("������û�ж���");
								}
								
							}
						}else { //�ò���������Լ���Ĳ���
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
					//����ϢҲ������Ӧ��Ϣ�����Ҹ���Ϣû�з���ֵ,����˵���������Ϊ�յ���Ϣ
					String param_name = ele.attribute("name").getValue();
					System.out.println(param_name);
					
					
					if(hasType(ele)) {
						String param_type = ele.selectSingleNode("attribute::type").getText();

						if(isSchema(param_type)) {
							
							System.out.println(param_type);
							
						}else {//����������Ͳ�Ϊschema���ͣ���Ϊ�û��Զ�������
							param_type = param_type.split(":")[1];
							String find_comples_path = "//complexType[@name='" + param_type  +"']";
							Element e_complexType = (Element) root.selectSingleNode(find_comples_path);
							String find_simple_path = "//simpleType[@name='" + param_type  +"']";
							Element e_simpleType = (Element) root.selectSingleNode(find_simple_path);
							
							if(e_complexType != null) {//�������ͣ��Ҹ����͵�complexType��ǩ�µ�element
								getBasicTypes_Element(e_complexType);
							}else if(e_simpleType != null) {//��Լ�����Ҹ����͵�simpleType��ǩ�µ�restriction
								findRestriction(e_simpleType);
							}else {
								System.out.println("������û�ж���");
							}
							
						}
					}else {
						System.out.println("Null(����Ϣû���������Ҫ��򷵻�ֵ)");
					}
					
				}
	}
	
	/**
	 * ��ȡĳһ�����Ļ���Լ��(base\length\pattern\minInclusive\maxInclusive\minExclusive\maxExclusive\minlength\maxlength)
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
