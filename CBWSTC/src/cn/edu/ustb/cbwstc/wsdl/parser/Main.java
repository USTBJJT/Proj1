package cn.edu.ustb.cbwstc.wsdl.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.xmlbeans.SchemaType;

import cn.edu.ustb.cbwstc.config.ConfigWorkSpace;
import cn.edu.ustb.cbwstc.config.CreatMkdir;
import cn.edu.ustb.cbwstc.modelCore.Converter;
import cn.edu.ustb.cbwstc.tcg.XmlInputFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ReadWsdl.DefInterface("http://localhost:8080/axis2/services/ExpenseReimbursementSystem?wsdl");
		
		/**
		 * 初始化目录过程：
		 */
		ConfigWorkSpace.configFile();
		
		/**
		 * 进行wsdl文件的解析：包括，wsdl文件拷贝（本地或联网）、xsd文件的生成、model源文件的生成、
		 */
		//针对选定的服务地址，进行相关目录的生成
		String WsdlURI = "http://localhost:8080/axis2/services/ExpenseReimbursementSystem?wsdl";//http://localhost:8080/axis2/services/ExpenseReimbursementSystem?wsdl  E:/ExFile/JustService.wsdl
		String name = WsdlURI.substring(WsdlURI.lastIndexOf("/")+1, WsdlURI.length()-5);
		String directoryXSD = "CBWSTC_WorkSpace/Projects/" + name + "/XSD";
		String directoryXML = "CBWSTC_WorkSpace/Projects/" + name + "/XML";
		String directoryModel = "CBWSTC_WorkSpace/Projects/" + name + "/Model";
		String directoryGraph = "CBWSTC_WorkSpace/Projects/" + name + "/Graph";
		String directoryTC = "CBWSTC_WorkSpace/Projects/" + name + "/TC";
		String directoryResult = "CBWSTC_WorkSpace/Projects/" + name + "/Result";
		CreatMkdir.creatMkdir(directoryXSD);
		CreatMkdir.creatMkdir(directoryXML);
		CreatMkdir.creatMkdir(directoryModel);
		CreatMkdir.creatMkdir(directoryGraph);
		CreatMkdir.creatMkdir(directoryTC);
		CreatMkdir.creatMkdir(directoryResult);
		
		//目录存在后，逻辑业务开始
		
		//解析WSDL，将WSDL导入到本地工程文件夹、生成每个操作请求的格式、每个操作的参数(进行模型约束及测试用例生成时备用)
		ReadWsdl readwsdl = new ReadWsdl(WsdlURI);
		readwsdl.DefInterface(name); 
		Map<String, XmlInputFormat> map = new HashMap<String, XmlInputFormat>();
		map = readwsdl.getXmlInputFormatMap();
		for (Entry<String, XmlInputFormat> entry : map.entrySet()) {
			System.out.println("key= " + entry.getKey());
			XmlInputFormat InP = entry.getValue();
			Map<String, SchemaType> mapxl = InP.format.simpleTypes;
			for (Map.Entry<String, SchemaType> entryxl : mapxl.entrySet()) {
				System.out.println("key= " + entryxl.getKey() + " and value= " + entryxl.getValue().getPrimitiveType().getBuiltinTypeCode());
//				entryxl.getValue().getBaseType()
			}
		}
		
//		for(int i = 0; i < Ops.size(); i++) {
//			BindingOperation bop = (BindingOperation) Ops.get(i);
//			XmlInputFormat InP = readwsdl.getInputFormat(WsdlURI, bop);
//			Map<String, SchemaType> map = InP.format.simpleTypes;
//			System.out.println("*****************");
//			for (Map.Entry<String, SchemaType> entry : map.entrySet()) {
//				   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//				   SchemaType stype = entry.getValue();
//				   System.out.println(stype.getFacet(SchemaType.FACET_MIN_INCLUSIVE));
//				   XmlTcgUtils xtu = new XmlTcgUtils();
//				   System.out.println(xtu.sampleDataForSimpleType(stype));
//			}
//			System.out.println("*****************");
//			
//		}
		GetXsd.getXsd(WsdlURI,name);//获取wsdl里面的xsd文件(进行模型约束生成时使用、进行测试用例格式正确校验时使用)
		
//		Converter c = new Converter(map);//生成模型
//		c.convert(name, true);
		
		//退出
		System.exit(0);
		
	}

}
