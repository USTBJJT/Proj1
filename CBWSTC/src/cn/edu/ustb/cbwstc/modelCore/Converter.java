package cn.edu.ustb.cbwstc.modelCore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.util.Base64;
import org.apache.xmlbeans.impl.util.HexBin;

import net.sf.json.JSONObject;
import nl.flotsam.xeger.Xeger;
import cn.edu.ustb.cbwstc.model.Condition;
import cn.edu.ustb.cbwstc.model.Constants;
import cn.edu.ustb.cbwstc.model.Edge;
import cn.edu.ustb.cbwstc.model.Graph;
import cn.edu.ustb.cbwstc.model.Node;
import cn.edu.ustb.cbwstc.tcg.XmlInputFormat;

public class Converter {
	
	private Map<String,XmlInputFormat> mapXI = new HashMap<String, XmlInputFormat>();
	public Converter(Map<String,XmlInputFormat> map) {
		mapXI = map;
		IDGenerator.getInstance().clear(); //节点初始化
	}
	
	public void convert(String name, boolean flag) {
		Graph g = process(name, flag);
		processEdge(g);
		writeToFile(g,name);
		ModelVisualization mv = new ModelVisualization();
		mv.graphToPic(g,0);
		String source = "@startuml\n" + mv.getPlantumlP() +"@enduml";
		System.out.println(source);
		mv.visualizationGen(name,source);
	}
	
	private Graph process(String name, boolean flag)  {
		Graph graph = new Graph(); //创建空图
		graph.setName(name);
		// 生成头结点
		Node snode = new Node();
		snode.setId(IDGenerator.getInstance().getNextId());
		snode.setName("start");
		snode.setType(Constants.INITIAL); //把该节点类型设置为开始节点
		// 图内添加节点
		graph.getNodes().add(snode);
		
		//生成结束节点
		Node enode = new Node();
		enode.setId(IDGenerator.getInstance().getNextId());
		enode.setName("end");
		enode.setType(Constants.END);
		graph.getNodes().add(enode);
		
		//读取model文件进行模型创建
		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/Model/model.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			String str = null;
			int count = 0;
			try {
				while((str = br.readLine()) != null) {
					if(count == 0) {
						String json = str.split("#")[1];
						if(! json.equals("NullDocumentation")) {
							JSONObject obj = JSONObject.fromObject(json);
							String endTime = obj.getString("eTime");
							graph.setEndTime(endTime);
						}else
							graph.setEndTime("null");
						
					}else 
					{
						String Opr = str.split("#")[0];
						String OprI = str.split("#")[1];
						String OprO = str.split("#")[2];
						
						Node OprIN = new Node();
						OprIN.setId(IDGenerator.getInstance().getNextId());
						OprIN.setName(Opr +"."+ OprI);
						OprIN.setType(Constants.Input);
						OprIN.setCondition(processCondition(OprIN,Opr));
						snode.getAfterNodes().add(OprIN); //将新的节点加入到上一个节点的后继中
						OprIN.getBeforeNodes().add(snode); //将原来的节点加入到新节点的前继
						graph.getNodes().add(OprIN);
						
						Node OprON = new Node();
						OprON.setId(IDGenerator.getInstance().getNextId());
						OprON.setName(Opr +"."+ OprO);
						OprON.setType(Constants.Output);
						OprIN.getAfterNodes().add(OprON); //将新的节点加入到上一个节点的后继中
						OprON.getBeforeNodes().add(OprIN); //将原来的节点加入到新节点的前继
						OprON.getAfterNodes().add(enode);
						enode.getBeforeNodes().add(OprON);
						graph.getNodes().add(OprON);
						
					}
					count++;
				
				}
				
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return graph;
	}
	
	private void processEdge(Graph g) {// 生成边的集合
		ArrayList<Node> nodes = g.getNodes();
		ArrayList<Edge> edges = g.getEdges();
		for (int i = 0; i < nodes.size(); i++) {
			Node node = (Node) nodes.get(i); //获取一个节点
			for (int j = 0; j < node.getAfterNodes().size(); j++) { //找到该节点的全部后继节点
				Node childNode = (Node) node.getAfterNodes().get(j); //选取一个后继节点
				Edge edge = new Edge();
				edge.setFrom(node.getId()); //从该节点
				edge.setTo(childNode.getId()); //到后继节点
				edges.add(edge); //创建一条边
			}
		}
	}
	
	private ArrayList<Condition> processCondition(Node OprIN,String Opr) {
		XmlInputFormat xlf = mapXI.get(Opr);
		Map<String, SchemaType> map = xlf.format.simpleTypes;
		ArrayList<Condition> condition = new ArrayList<Condition>();
		int id = 0;
		for (Map.Entry<String, SchemaType> entry : map.entrySet()) {
			Condition e = new Condition();
			SchemaType sType = entry.getValue();
			e.setId(id);
			e.setName(entry.getKey());
			e.setType(getParType(sType));
			e.setMaxE(sType.getFacet(sType.FACET_MAX_EXCLUSIVE)==null?null:sType.getFacet(sType.FACET_MAX_EXCLUSIVE).getStringValue());
			e.setMaxI(sType.getFacet(sType.FACET_MAX_INCLUSIVE)==null?null:sType.getFacet(sType.FACET_MAX_INCLUSIVE).getStringValue());
			e.setMinE(sType.getFacet(sType.FACET_MIN_EXCLUSIVE)==null?null:sType.getFacet(sType.FACET_MIN_EXCLUSIVE).getStringValue());
			e.setMinI(sType.getFacet(sType.FACET_MIN_INCLUSIVE)==null?null:sType.getFacet(sType.FACET_MIN_INCLUSIVE).getStringValue());
			XmlAnySimpleType[] enumValues = sType.getEnumerationValues();
			String enumValuesS = null;
			if (enumValues != null && enumValues.length > 0) {
				enumValuesS = "";
				for(int i = 0;i<enumValues.length;i++){
					enumValuesS = enumValuesS + "[" + enumValues[i].getStringValue() + "]";
				}
			}
			e.setEnumeration(enumValuesS);
			e.setPattern(sType.getFacet(sType.FACET_PATTERN)==null?null:sType.getFacet(sType.FACET_PATTERN).getStringValue());
			System.out.println(e.getContent());
			condition.add(e);
			id++;
		}
		return condition;
//		condition.add(index, element);
//		OprIN.setCondition(condition);
	}
	
	private String getParType(SchemaType sType) {
		SchemaType primitiveType = sType.getPrimitiveType();
		switch (primitiveType.getBuiltinTypeCode()) {
			default:
			case SchemaType.BTC_NOT_BUILTIN:
				return "notbuiltin";// 没有内置类型
			case SchemaType.BTC_ANY_TYPE:
				return "anyType";
			case SchemaType.BTC_ANY_SIMPLE:
				return "anySimpleType";
			case SchemaType.BTC_BOOLEAN:
				return "boolean";
			case SchemaType.BTC_BASE_64_BINARY:
				return "base64Binary";
			case SchemaType.BTC_HEX_BINARY:
				return "hexBinary";
			case SchemaType.BTC_ANY_URI:
				return "anyURI";
			case SchemaType.BTC_QNAME:
				return "QName";
			case SchemaType.BTC_NOTATION:
				return "NOTATION";
			case SchemaType.BTC_FLOAT:
				return "float";
			case SchemaType.BTC_DOUBLE:
				return "double";
			case SchemaType.BTC_DECIMAL:
				switch (closestBuiltin(sType).getBuiltinTypeCode()) {
				case SchemaType.BTC_SHORT:
					return "short";
				case SchemaType.BTC_UNSIGNED_SHORT:
					return "unsignedShort";
				case SchemaType.BTC_BYTE:
					return "byte";
				case SchemaType.BTC_UNSIGNED_BYTE:
					return "unsignedByte";
				case SchemaType.BTC_INT:
					return "int";
				case SchemaType.BTC_UNSIGNED_INT:
					return "unsignedInt";
				case SchemaType.BTC_LONG:
					return "long";
				case SchemaType.BTC_UNSIGNED_LONG:
					return "unsignedLong";
				case SchemaType.BTC_INTEGER:
					return "integer";
				case SchemaType.BTC_NON_POSITIVE_INTEGER:
					return "nonPositiveInteger";
				case SchemaType.BTC_NEGATIVE_INTEGER:
					return "negativeInteger";
				case SchemaType.BTC_NON_NEGATIVE_INTEGER:
					return "nonNegativeInteger";
				case SchemaType.BTC_POSITIVE_INTEGER:
					return "positiveInteger";
				default:
				case SchemaType.BTC_DECIMAL:
					return "decimal";
				}
			case SchemaType.BTC_STRING: {
					switch (closestBuiltin(sType).getBuiltinTypeCode()) {
					case SchemaType.BTC_STRING:
						return "string";
					case SchemaType.BTC_NORMALIZED_STRING:
						return "normalizedString";
					case SchemaType.BTC_TOKEN:
						return "token";
					default:
						return "String";
					}
			}
			case SchemaType.BTC_DURATION:
				return "duration";
			case SchemaType.BTC_DATE_TIME:
				return "dateTime";
			case SchemaType.BTC_TIME:
				return "time";
			case SchemaType.BTC_DATE:
				return "date";
			case SchemaType.BTC_G_YEAR_MONTH:
				return "gYearMonth";
			case SchemaType.BTC_G_YEAR:
				return "gYear";
			case SchemaType.BTC_G_MONTH_DAY:
				return "gMonthDay";
			case SchemaType.BTC_G_DAY:
				return "gDay";
			case SchemaType.BTC_G_MONTH:
				return "gMonth";
		}
		
	}
	
	private SchemaType closestBuiltin(SchemaType sType) {
		while (!sType.isBuiltinType())
			sType = sType.getBaseType();
		return sType;
	}
	
	private void writeToFile(Graph g,String name) {
		try {
			FileOutputStream out = new FileOutputStream("CBWSTC_WorkSpace/Projects/" + name + "/Graph/graph.txt");
			BufferedWriter outfile = new BufferedWriter(new OutputStreamWriter(
					out));

			ArrayList<Node> nodes = g.getNodes();
			ArrayList<Edge> edges = g.getEdges();
			outfile.write("nodes.size()" + nodes.size() + "\r\n");
			for (int i = 0; i < nodes.size(); i++) {
				outfile.write(nodes.get(i).getId() + " ");
				outfile.write(nodes.get(i).getName() + " ");
				outfile.write(nodes.get(i).getType() + "\r\n");
			}
			outfile.write("edges.size()" + edges.size() + "\r\n");
			for (int i = 0; i < edges.size(); i++) {
				outfile.write(edges.get(i).toString() + "\r\n");
			}

			outfile.flush();
			outfile.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
