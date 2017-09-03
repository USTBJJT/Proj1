package cn.edu.ustb.cbwstc.modelCore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDuration;
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

import java.util.Date;

public class Converter {
	
	private Map<String,XmlInputFormat> mapXI = new HashMap<String, XmlInputFormat>();
	private Map<String,String> mapSq = new HashMap<String, String>();
	public Converter(Map<String,XmlInputFormat> map,Map<String,String> mapSq) {
		mapXI = map;
		this.mapSq = mapSq;
		IDGenerator.getInstance().clear(); //节点初始化
	}
	
	public void convert(String name, boolean flag) {
		Graph g = process(name, flag);
		assignNodeId(g);
		processEdge(g);
		writeToGraph(g,name);
		writeToModel(g,name);
		ModelVisualization mv = new ModelVisualization();
		mv.visualizationGen(name);
//		mv.graphToPic(g,0);
//		String source = "@startuml\n" + mv.getPlantumlP() +"@enduml";
//		System.out.println(source);
//		mv.visualizationGen(name,source);
	}
	
	private Graph process(String name, boolean flag)  {
		
		Graph graph = new Graph(); //创建空图
		graph.setName(name); //模型名称
		
		// 生成头结点
		Node snode = new Node();
//		snode.setId(IDGenerator.getInstance().getNextId());
		snode.setName("Start");
		snode.setType(Constants.INITIAL); //把该节点类型设置为开始节点
		// 图内添加节点
		graph.getNodes().add(snode);
		
		//生成结束节点
		Node enode = new Node();
//		enode.setId(IDGenerator.getInstance().getNextId());
		enode.setName("end");
		enode.setType(Constants.END);
		graph.getNodes().add(enode);
		
		//读取mapSq集合,进行行为模型创建(实例化)
//		Node cnode = null;
		for (String key : mapSq.keySet()) {
			String[] set = key.split("#");
			Node cnode = snode;
			if(graph.hasNode(set[0])) {
				Node temp = graph.getNode(set[0]);
				temp.getBeforeNodes().add(cnode);
				cnode.getAfterNodes().add(temp);
				cnode = temp;
			}else {
				Node OprIN = new Node();
				OprIN.setName(set[0]);
				OprIN.setType(Constants.Input);
//				OprIN.setCondition(processCondition(OprIN,set[0].split("\\.")[0]));
				cnode.getAfterNodes().add(OprIN); //将新的节点加入到上一个节点的后继中
				OprIN.getBeforeNodes().add(cnode); //将原来的节点加入到新节点的前继
				graph.getNodes().add(OprIN);
				cnode = OprIN;
			}
			
			for(int n=1;n<set.length -1;n++) {
				if(graph.hasNode(set[n])) {
					Node temp = graph.getNode(set[n]);
					temp.getBeforeNodes().add(cnode);
					cnode.getAfterNodes().add(temp);
					cnode = temp;
				}else {
					Node midNode = new Node();
					midNode.setName(set[n]);
					if(n%2 ==0) {
						midNode.setType(Constants.Input);
//						midNode.setCondition(processCondition(midNode,set[n].split("\\.")[0]));
						
					}else {
						midNode.setType(Constants.Output);
					}
					midNode.getBeforeNodes().add(cnode);
					cnode.getAfterNodes().add(midNode);
					graph.getNodes().add(midNode);
					cnode = midNode;
				}
			}
			if(graph.hasNode(set[set.length-1])) {
				Node temp = graph.getNode(set[set.length-1]);
				temp.getBeforeNodes().add(cnode);
				cnode.getAfterNodes().add(temp);
				temp.getAfterNodes().add(enode);
				enode.getBeforeNodes().add(temp);
			}else {
				Node OprOUT = new Node();
//				OprOUT.setId(IDGenerator.getInstance().getNextId());
				OprOUT.setName(set[set.length-1]);
				OprOUT.setType(Constants.Output);
				OprOUT.getBeforeNodes().add(cnode); //将原来的节点加入到新节点的前继
				cnode.getAfterNodes().add(OprOUT);
				OprOUT.getAfterNodes().add(enode); //新节点后继为结束节点
				enode.getBeforeNodes().add(OprOUT);
				graph.getNodes().add(OprOUT);
			}
			
//			if(!hashCNode(graph,set[0])) {
//				Node OprIN = new Node();
//				OprIN.setId(IDGenerator.getInstance().getNextId());
//				OprIN.setName(set[0]);
//				OprIN.setType(Constants.Input);
//				OprIN.setCondition(processCondition(OprIN,set[0].split("\\.")[0]));
//				snode.getAfterNodes().add(OprIN); //将新的节点加入到上一个节点的后继中
//				OprIN.getBeforeNodes().add(snode); //将原来的节点加入到新节点的前继
//				graph.getNodes().add(OprIN);
//				cnode = OprIN;
//			}
//			else {
//				cnode = graph.getNode(set[0]);
//			}
//			for(int n=1;n<set.length -1;n++) {
//				if(!hashCNode(graph,set[n])) {
//					Node midnode = new Node();
//					midnode.setId(IDGenerator.getInstance().getNextId());
//					midnode.setName(set[n]);
//					if(n%2 ==0) {
//						midnode.setType(Constants.Input);
//						midnode.setCondition(processCondition(midnode,set[n].split("\\.")[0]));
//						
//					}else {
//						midnode.setType(Constants.Output);
//					}
//					midnode.getBeforeNodes().add(cnode);
//					cnode.getAfterNodes().add(midnode);
//					graph.getNodes().add(midnode);
//					cnode = midnode;
//				}else {
//					cnode = graph.getNode(set[n]);
//				}
//			}
//			if(!hashCNode(graph,set[set.length-1])) {
//				Node OprOUT = new Node();
//				OprOUT.setId(IDGenerator.getInstance().getNextId());
//				OprOUT.setName(set[set.length-1]);
//				OprOUT.setType(Constants.Output);
//				OprOUT.getBeforeNodes().add(cnode); //将原来的节点加入到新节点的前继
//				cnode.getAfterNodes().add(OprOUT);
//				OprOUT.getAfterNodes().add(enode); //新节点后继为结束节点
//				enode.getBeforeNodes().add(OprOUT);
//				graph.getNodes().add(OprOUT);
//			} else {
//				if(!isenodesB(enode,set[set.length-1])) {
//					graph.getNode(set[set.length-1]).getAfterNodes().add(enode);
//					enode.getBeforeNodes().add(graph.getNode(set[set.length-1]));
//				}
//			}
		}
		
//		//读取model文件进行模型创建
//		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/Model/model.txt");
//		BufferedReader br;
//		try {
//			br = new BufferedReader(new FileReader(f));
//			String str = null;
//			int count = 0;
//			try {
//				while((str = br.readLine()) != null) {
//					if(count == 0) {
//						String json = str.split("#")[1];
//						if(! json.equals("NullDocumentation")) {
//							JSONObject obj = JSONObject.fromObject(json);
//							String endTime = obj.getString("eTime");
//							graph.setEndTime(endTime);
//						}else
//							graph.setEndTime("null");
//						
//					}else 
//					{
//						String Opr = str.split("#")[0];
//						String OprI = str.split("#")[1];
//						String OprO = str.split("#")[2];
//						
//						Node OprIN = new Node();
//						OprIN.setId(IDGenerator.getInstance().getNextId());
//						OprIN.setName(Opr +"."+ OprI);
//						OprIN.setType(Constants.Input);
//						OprIN.setCondition(processCondition(OprIN,Opr));
//						snode.getAfterNodes().add(OprIN); //将新的节点加入到上一个节点的后继中
//						OprIN.getBeforeNodes().add(snode); //将原来的节点加入到新节点的前继
//						graph.getNodes().add(OprIN);
//						
//						Node OprON = new Node();
//						OprON.setId(IDGenerator.getInstance().getNextId());
//						OprON.setName(Opr +"."+ OprO);
//						OprON.setType(Constants.Output);
//						OprIN.getAfterNodes().add(OprON); //将新的节点加入到上一个节点的后继中
//						OprON.getBeforeNodes().add(OprIN); //将原来的节点加入到新节点的前继
//						OprON.getAfterNodes().add(enode);
//						enode.getBeforeNodes().add(OprON);
//						graph.getNodes().add(OprON);
//						
//					}
//					count++;
//				
//				}
//				
//			} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			}
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		return graph;
	}
	
//	private boolean hashCNode(Graph g,String nodeName) {
//		ArrayList<Node> nodes = g.getNodes();
//		for (int i = 0; i < nodes.size(); i++) {
//			if(nodes.get(i).getName().equals(nodeName)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
//	private boolean isenodesB(Node node,String nodeName) {
//		ArrayList<Node> nodes = node.getBeforeNodes();
//		for (int i = 0; i < nodes.size(); i++) {
//			if(nodes.get(i).getName().equals(nodeName)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	/**
	 * 给所有节点编号
	 * @param g
	 */
	private void assignNodeId(Graph g) {
		LinkedHashSet<Node> nodes = g.getNodes();
		for(Node node : nodes) {
			node.setId(IDGenerator.getInstance().getNextId());
		}
	}
	
	private void processEdge(Graph g) {// 生成边的集合
		LinkedHashSet<Node> nodes = g.getNodes();
		ArrayList<Edge> edges = g.getEdges();
		for (Node node: nodes) {
			LinkedHashSet<Node> childNodes = node.getAfterNodes();
			for (Node childNode: childNodes) {
				Edge edge = new Edge();
				edge.setFrom(node.getId()); //从该节点
				edge.setTo(childNode.getId()); //到后继节点
				edges.add(edge); //创建一条边
			}
		}
//		for (int i = 0; i < nodes.size(); i++) {
//			Node node = (Node) nodes.get(i); //获取一个节点
//			for (int j = 0; j < node.getAfterNodes().size(); j++) { //找到该节点的全部后继节点
//				Node childNode = (Node) node.getAfterNodes().get(j); //选取一个后继节点
//				Edge edge = new Edge();
//				edge.setFrom(node.getId()); //从该节点
//				edge.setTo(childNode.getId()); //到后继节点
//				edges.add(edge); //创建一条边
//			}
//		}
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
			System.out.println(enumValuesS);
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
						return "String";
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
	
	private void writeToGraph(Graph g,String name) {
		try {
			FileOutputStream out = new FileOutputStream("CBWSTC_WorkSpace/Projects/" + name + "/Model/graph.txt");
			BufferedWriter outfile = new BufferedWriter(new OutputStreamWriter(
					out));

			LinkedHashSet<Node> nodes = g.getNodes();
			ArrayList<Edge> edges = g.getEdges();
			outfile.write("nodes.size()" + nodes.size() + "\r\n");
			for(Node node : nodes) {
				outfile.write(node.getId() + " ");
				outfile.write(node.getName() + " ");
				outfile.write(node.getType() + "\r\n");
			}
//			for (int i = 0; i < nodes.size(); i++) {
//				outfile.write(nodes.get(i).getId() + " ");
//				outfile.write(nodes.get(i).getName() + " ");
//				outfile.write(nodes.get(i).getType() + "\r\n");
//			}
			outfile.write("edges.size()" + edges.size() + "\r\n");
			for (int i = 0; i < edges.size(); i++) {
				outfile.write(edges.get(i).getName() + " ");
				outfile.write(edges.get(i).toString() + "\r\n");
			}

			outfile.flush();
			outfile.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeToModel(Graph g,String name) {
		
		try {
			FileOutputStream out = new FileOutputStream("CBWSTC_WorkSpace/Projects/" + name + "/Model/Model.txt");
			BufferedWriter outfile = new BufferedWriter(new OutputStreamWriter(
				out));
			LinkedHashSet<Node> nodes = g.getNodes();
			ArrayList<Edge> edges = g.getEdges();
			String consStr = "		Cons[shape=record,label=\"{Node Condition";
			outfile.write("digraph G{\r\n"
					+ "graph[fontname=\"Microsoft YaHei\"]\r\n"
					+ "	subgraph cluster_g{\r\n"
					+ "		label=<Web Service Behavior Model>;\r\n"
					+ "		node[shape=record,fontname=\"Microsoft YaHei\"];\r\n"
					+ "		edge[fontname=\"Microsoft YaHei\"];\r\n");
			for(Node node : nodes) {
				outfile.write("		node"+ node.getId() + "[label=\"node" + node.getId() + "\",shape=circle];\r\n");
				consStr = consStr + "|node" + node.getId() + "\\nname: " + node.getName() + "\\nCondition:\\n";
			}
			consStr = consStr + "}\"];\r\n"; 
			for (int i = 0; i < edges.size(); i++) {
				outfile.write("		node" + edges.get(i).getFrom() + "->node"+ edges.get(i).getTo() + "\r\n");
			}
			outfile.write("	}\r\n");
			outfile.write("	subgraph cluster_c{\r\n");
			outfile.write(consStr);
			outfile.write("	}\r\n}");
			outfile.flush();
			outfile.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//从下面开始是新的逻辑：
	public Converter(Map<String,XmlInputFormat> map) {
		mapXI = map;
		IDGenerator.getInstance().clear(); //节点初始化
	}
	
	public Graph initialNode(String name) {
		Graph g = new Graph();
		g = process(name);
		return g;
	}
	
	public void setupConnection(Graph g,String from, String to) {
		Node nodef = g.getNode(from);
		Node nodet = g.getNode(to);
		nodef.getAfterNodes().add(nodet);
		nodet.getBeforeNodes().add(nodef);
	}
	
	public void convert(Graph g,String name) {
		setEdge(g);
		writeGraph(g,name);
		writeToPngText(g,name);
		writeToTargetModel(g, name);
		ModelVisualization mv = new ModelVisualization();
		mv.visualizationGen(name);
	}
	
	private ArrayList<Condition> processInputCondition(String Opr) {
		ArrayList<Condition> condition = new ArrayList<Condition>();
		XmlInputFormat xlf = mapXI.get(Opr);
		System.out.println(Opr);
		Map<String, SchemaType> map = xlf.format.simpleTypes;
		int id = 0;
		for (Map.Entry<String, SchemaType> entry : map.entrySet()) {
//			System.out.println(entry.getKey());
			Condition e = new Condition();
			SchemaType sType = entry.getValue();
			/**
			 * 参数的pattern约束
			 */
			//TODO
			if(sType.hasPatternFacet() == false) { //如果没有pattern约束
//				System.out.println("没有pattern约束");
				XmlAnySimpleType[] enumValues = sType.getEnumerationValues();
				String enumValuesS = "";
				if (enumValues != null && enumValues.length > 0) {
					for(int i = 0;i<enumValues.length;i++){
						if(i == 0) {
							enumValuesS = enumValuesS + enumValues[i].getStringValue();
						}else {
							enumValuesS = enumValuesS + "|" + enumValues[i].getStringValue();
						}
					
					}
				}
//				System.out.println(enumValuesS);
				e.setPattern(enumValuesS);
			}else {
//				System.out.println("有pattern约束");
//				System.out.println(sType.getPatterns()[0]);
				e.setPattern(sType.getPatterns()[0]);
			}
			/**
			 * 
			 */
			
			/**
			 * 参数的范围limit约束,根据minI minE maxI maxE 获取
			 */
			e.setNumLimite(true);
			BigDecimal lowN = null;
			boolean low = true;
			XmlDecimal xmlD;
			xmlD = (XmlDecimal) sType.getFacet(SchemaType.FACET_MIN_INCLUSIVE);
			BigDecimal minI = xmlD != null ? xmlD.getBigDecimalValue() : null;
			
			xmlD = (XmlDecimal) sType.getFacet(SchemaType.FACET_MIN_EXCLUSIVE);
			BigDecimal minE = xmlD != null ? xmlD.getBigDecimalValue() : null;
			
			if (minI != null && minE != null) {
				if(minI.compareTo(minE) > 0) {
					lowN = minI;
				}else {
					lowN = minE;
				}
			}else if(minI != null) {
				lowN = minI;
			}else if(minE != null) {
				lowN = minE;
			}else {
				low = false;
			}

			BigDecimal highN = null;
			boolean high = true;
			xmlD = (XmlDecimal) sType.getFacet(SchemaType.FACET_MAX_INCLUSIVE);
			BigDecimal maxI = xmlD != null ? xmlD.getBigDecimalValue() : null;
			
			xmlD = (XmlDecimal) sType.getFacet(SchemaType.FACET_MAX_EXCLUSIVE);
			BigDecimal maxE = xmlD != null ? xmlD.getBigDecimalValue() : null;
			
			if (maxI != null && maxE != null) {
				if(maxI.compareTo(maxE) < 0) {
					highN = maxI;
				}else {
					highN = maxE;
				}
			}else if(minI != null) {
				highN = maxI;
			}else if(minE != null) {
				highN = maxE;
			}else {
				high = false;
			}
			
			if(high && low) {
//				System.out.println("有high low");
				e.setHighLimite(highN.toString());
				e.setLowLimite(lowN.toString());
//				System.out.println(highN.toString());
//				System.out.println(lowN.toString());
			}else if(high && !low) {
//				System.out.println("有high");
				e.setHighLimite(highN.toString());
				lowN = highN.add(new BigDecimal(-50));
				e.setLowLimite(lowN.toString());
//				System.out.println(highN.toString());
//				System.out.println(lowN.toString());
			}else if(!high && low) {
//				System.out.println("有low");
				e.setLowLimite(lowN.toString());
				highN = lowN.add(new BigDecimal(50));
//				System.out.println(highN.toString());
//				System.out.println(lowN.toString());
			}else {
//				System.out.println("没有high low");
				e.setNumLimite(false);
			}
			/**
			 * 
			 */
			
			e.setId(id);
			e.setContent(Opr + "_?_" + entry.getKey() + "#" + getParType(sType));
			condition.add(e);
			id++;
		}
		return condition;
	}
	
	private void setEdge(Graph g) {// 生成边的集合
		LinkedHashSet<Node> nodes = g.getNodes();
		ArrayList<Edge> edges = g.getEdges();
		int id = 0;
		for (Node node: nodes) {
			LinkedHashSet<Node> childNodes = node.getAfterNodes();
			for (Node childNode: childNodes) {
				Edge edge = new Edge();
				edge.setFrom(node.getId()); //从该节点
				edge.setTo(childNode.getId()); //到后继节点
				edge.setName("e" + id);
				edges.add(edge); //创建一条边
				id++;
			}
		}
	}
	
	private Graph process(String name)  {
		
		Graph graph = new Graph(); //创建空图
		graph.setName(name); //模型名称
		
		// 生成头结点
		Node snode = new Node();
		snode.setId(IDGenerator.getInstance().getNextId());
		snode.setName("Start");
		snode.setType(Constants.INITIAL); //把该节点类型设置为开始节点
		// 图内添加节点
		graph.getNodes().add(snode);
		
		//初始节点
		Node inode = new Node();
		inode.setId(IDGenerator.getInstance().getNextId());
		inode.setName("Init");
		inode.setType(Constants.INITIAL); //把该节点类型设置为开始节点
		// 图内添加节点
		graph.getNodes().add(inode);
		
		//节点连接
		snode.getAfterNodes().add(inode);
		inode.getBeforeNodes().add(snode);
		
		//存储output节点，为了后续连接end节点使用
		LinkedHashSet<Node> outputnodes = new LinkedHashSet<Node>();
		//遍历文件进行模型其他节点的生成
		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/Parser/result.txt");
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
						}else {
							//当时的时间加一天即可
							Date d = new Date();
							Calendar cal = Calendar.getInstance();
							cal.setTime(d);
							cal.add(Calendar.DATE, 1);
							graph.setEndTime(cal.getTime());
						}
					}else {
						String Opr = str.split("#")[0];//ws操作名称
						String OprI = str.split("#")[1];//调用节点名称
						String OprO = str.split("#")[2];//响应节点名称
					
						Node nodeI = new Node();
						nodeI.setId(IDGenerator.getInstance().getNextId());
						nodeI.setName(OprI);
						nodeI.setType(Constants.Input);
						
						//设置输入参数约束
						nodeI.setCondition(processInputCondition(Opr));
						//设置约束
						if(str.split("#")[3].equals("NullDocumentation")) {
							//没有约束
							nodeI.setInvokeOpC("NullConstraint");
							nodeI.setIpRegionC("NullConstraint");
							nodeI.setIterationC(true);
							nodeI.setPreOpC("NullConstraint");
							nodeI.setParaRelationC("NullConstraint");
						}else {
							String json = str.split("#")[3];
							JSONObject obj = JSONObject.fromObject(json);
							String ParaRelationC = obj.getString("paraRelation");
							if(ParaRelationC.trim().equals("")) {
								nodeI.setParaRelationC("NullConstraint");
							}else {
								nodeI.setParaRelationC(ParaRelationC.trim());
							}
							String IpRegionC = obj.getString("ipRegion");
							if(IpRegionC.trim().equals("")) {
								nodeI.setIpRegionC("NullConstraint");
							}else {
								nodeI.setIpRegionC(IpRegionC.trim());
							}
							String InvokeOpC = obj.getString("invokeOp");
							if(InvokeOpC.trim().equals("")) {
								nodeI.setInvokeOpC("NullConstraint");
							}else {
								nodeI.setInvokeOpC(InvokeOpC.trim());
							}
							String preOpC = obj.getString("preOp");
							if(preOpC.trim().equals("")) {
								nodeI.setPreOpC("NullConstraint");
							}else {
								nodeI.setPreOpC(preOpC.trim());
							}
							String IterationC = obj.getString("Iteration");
							if(IterationC.trim().equals("")) {
								nodeI.setIterationC(true);
							}else {
								nodeI.setIterationC(Boolean.parseBoolean(IterationC.trim()));
							}
						}
						//节点添加进图
						graph.getNodes().add(nodeI);
						
						if(nodeI.getPreOpC().equals("NullConstraint")){
							inode.getAfterNodes().add(nodeI);
							nodeI.getBeforeNodes().add(inode);
						}
						
						Node nodeOS = new Node();
						nodeOS.setId(IDGenerator.getInstance().getNextId());
						nodeOS.setName(OprO + "_succ");
						nodeOS.setType(Constants.Output);
						graph.getNodes().add(nodeOS);
						outputnodes.add(nodeOS);
						nodeI.getAfterNodes().add(nodeOS);
						nodeOS.getBeforeNodes().add(nodeI);
						if(nodeI.getIterationC()) {
							nodeOS.getAfterNodes().add(nodeI);
							nodeI.getBeforeNodes().add(nodeOS);
						}
						
						Node nodeOF = new Node();
						nodeOF.setId(IDGenerator.getInstance().getNextId());
						nodeOF.setName(OprO + "_fail");
						nodeOF.setType(Constants.Output);
						graph.getNodes().add(nodeOF);
						outputnodes.add(nodeOF);
						nodeI.getAfterNodes().add(nodeOF);
						nodeOF.getBeforeNodes().add(nodeI);
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
		Node nodeEnd = new Node();
		nodeEnd.setId(IDGenerator.getInstance().getNextId());
		nodeEnd.setName("End");
		nodeEnd.setType(Constants.END);
		graph.getNodes().add(nodeEnd);
		for(Node node: outputnodes) {
			node.getAfterNodes().add(nodeEnd);
			nodeEnd.getBeforeNodes().add(node);
		}
		return graph;
	}
	
	private void writeGraph(Graph g,String name) {
		try {
			FileOutputStream out = new FileOutputStream("CBWSTC_WorkSpace/Projects/" + name + "/Model/graph.txt");
			BufferedWriter outfile = new BufferedWriter(new OutputStreamWriter(
					out));

			LinkedHashSet<Node> nodes = g.getNodes();
			ArrayList<Edge> edges = g.getEdges();
			outfile.write("nodes.size()" + nodes.size() + "\r\n");
			for(Node node : nodes) {
				outfile.write(node.getId() + " ");
				outfile.write(node.getName() + " ");
				outfile.write(node.getType() + " ");
				ArrayList<Condition> c = node.getCondition();
				for(int i=0;i<c.size();i++) {
					outfile.write(c.get(i).getContent() + " ");
				}
				outfile.write(node.getParaRelationC() + " ");
				outfile.write(node.getIpRegionC() + " ");
				outfile.write(node.getInvokeOpC() + " ");
				outfile.write(node.getPreOpC() + " ");
				outfile.write(node.getIterationC() + "\r\n");
			}
//			for (int i = 0; i < nodes.size(); i++) {
//				outfile.write(nodes.get(i).getId() + " ");
//				outfile.write(nodes.get(i).getName() + " ");
//				outfile.write(nodes.get(i).getType() + "\r\n");
//			}
			outfile.write("edges.size()" + edges.size() + "\r\n");
			for (int i = 0; i < edges.size(); i++) {
				outfile.write(edges.get(i).getName() + " ");
				outfile.write(edges.get(i).toString() + "\r\n");
			}

			outfile.flush();
			outfile.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeToPngText(Graph g,String name) { //生成可视化文件
		
		try {
			FileOutputStream out = new FileOutputStream("CBWSTC_WorkSpace/Projects/" + name + "/Model/ModelPng.txt");
			BufferedWriter outfile = new BufferedWriter(new OutputStreamWriter(
				out));
			LinkedHashSet<Node> nodes = g.getNodes();
			ArrayList<Edge> edges = g.getEdges();
			String consStr = "		Cons[shape=record,label=\"{Node Condition";
			outfile.write("digraph G{\r\n"
					+ "graph[fontname=\"Microsoft YaHei\"]\r\n"
					+ "	subgraph cluster_g{\r\n"
					+ "		label=<Web Service Behavior Model>;\r\n"
					+ "		node[shape=record,fontname=\"Microsoft YaHei\"];\r\n"
					+ "		edge[fontname=\"Microsoft YaHei\"];\r\n");
			for(Node node : nodes) {
				outfile.write("		n"+ node.getId() + "[label=\"n" + node.getId() + "\",shape=circle];\r\n");
				consStr = consStr + "|n" + node.getId() + "\\nname: " + node.getName() + "\\n";
			}
			consStr = consStr + "}\"];\r\n"; 
			for (int i = 0; i < edges.size(); i++) {
				outfile.write("		n" + edges.get(i).getFrom() + "->n"+ edges.get(i).getTo() + "[label=\"" + edges.get(i).getName() +"\"];\r\n");
			}
			outfile.write("	}\r\n");
			outfile.write("	subgraph cluster_c{\r\n");
			outfile.write(consStr);
			outfile.write("	}\r\n}");
			outfile.flush();
			outfile.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void writeToTargetModel(Graph g,String name) {
		try {
			FileOutputStream out = new FileOutputStream("CBWSTC_WorkSpace/Projects/" + name + "/Model/Model.graphml");
			BufferedWriter outfile = new BufferedWriter(new OutputStreamWriter(
				out));
			LinkedHashSet<Node> nodes = g.getNodes();
			ArrayList<Edge> edges = g.getEdges();
			String StandHead = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n"
					+ "<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\" xmlns:java=\"http://www.yworks.com/xml/yfiles-common/1.0/java\""
					+ " xmlns:sys=\"http://www.yworks.com/xml/yfiles-common/markup/primitives/2.0\" xmlns:x=\"http://www.yworks.com/xml/yfiles-common/markup/2.0\""
					+ " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:y=\"http://www.yworks.com/xml/graphml\" xmlns:yed=\"http://www.yworks.com/xml/yed/3\""
					+ " xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd\">\r\n";
			String Standdef = "\t<key for=\"graphml\" id=\"d0\" yfiles.type=\"resources\"/>\r\n"
					+ "\t<key for=\"node\" id=\"d6\" yfiles.type=\"nodegraphics\"/>\r\n"
					+ "\t<key for=\"edge\" id=\"d10\" yfiles.type=\"edgegraphics\"/>\r\n"
					+ "\t<graph edgedefault=\"directed\" id=\"G\">\r\n";
			outfile.write(StandHead + Standdef);
			for(Node node : nodes) {
				String nodeStr = "\t\t<node id=\"n"+ node.getId() +"\">\r\n"
						+ "\t\t\t<data key=\"d6\">\r\n"
						+ "\t\t\t\t<y:GenericNode>\r\n\t\t\t\t\t<y:Geometry/>\r\n\t\t\t\t\t<y:Fill/>\r\n\t\t\t\t\t<y:BorderStyle/>\r\n"
						+ "\t\t\t\t\t<y:NodeLabel>" + node.getName() +"</y:NodeLabel>\r\n"
						+ "\t\t\t\t</y:GenericNode>\r\n\t\t\t</data>\r\n\t\t</node>\r\n";
				outfile.write(nodeStr);
			}
			for (int i = 0; i < edges.size(); i++) {
				String edgeStr = "\t\t<edge id=\""+ edges.get(i).getName() +"\" source=\"n" + edges.get(i).getFrom() + "\" target=\"n" + edges.get(i).getTo() + "\">\r\n"
						+ "\t\t\t<data key=\"d10\">\r\n"
						+ "\t\t\t\t<y:PolyLineEdge>\r\n\t\t\t\t\t<y:Path/>\r\n\t\t\t\t\t<y:LineStyle/>\r\n\t\t\t\t\t<y:Arrows/>\r\n"
						+ "\t\t\t\t\t<y:EdgeLabel>" + edges.get(i).getName() +"</y:EdgeLabel>\r\n"
						+ "\t\t\t\t\t<y:BendStyle/>\r\n"
						+ "\t\t\t\t</y:PolyLineEdge>\r\n\t\t\t</data>\r\n\t\t</edge>\r\n";
				outfile.write(edgeStr);
			}
			String endStr = "\t</graph>\r\n"
					+ "\t<data key=\"d0\">\r\n"
					+ "\t\t<y:Resources/>\r\n"
					+ "\t</data>\r\n"
					+ "</graphml>";
			outfile.write(endStr);
			outfile.flush();
			outfile.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
