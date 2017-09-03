package cn.edu.ustb.cbwstc.tsg;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import net.sf.json.JSONObject;
import cn.edu.ustb.cbwstc.model.Condition;
import cn.edu.ustb.cbwstc.model.Constants;
import cn.edu.ustb.cbwstc.model.Edge;
import cn.edu.ustb.cbwstc.model.Graph;
import cn.edu.ustb.cbwstc.model.Node;
import cn.edu.ustb.cbwstc.tcg.DataToCase;
import cn.edu.ustb.cbwstc.tcg.TestDateG;

/**
 * 由Graph生成满足覆盖准则的一系列测试序列
 * @author JJT
 *
 */
public class GetInitialTestSequence {
	
	private String separator = File.separator;
	private String jarPath =  System.getProperty("user.dir") + separator 
			+ "CBWSTC_WorkSpace" + separator
			+ "CmdJar" + separator + "graphwalker-cli-3.4.2.jar";
	private String graphFile = ""; //符合graphwalker的graph类型文件，用来进行模型遍历
	private Graph g = new Graph();
	private String name= "";
	private ArrayList<String> initTs = new ArrayList<String>(); 
	private HashMap<String,Integer> initTsmap = new HashMap<String,Integer>();
	
	public GetInitialTestSequence(Graph g,String name) {
		this.name = name;
		graphFile = "CBWSTC_WorkSpace/Projects/" + name + "/Model/Model.graphml";
		this.g = g;
		IDGenerator.getInstance().clear();
	}
	
//	public static void main(String[] args) {
//		GetInitialTestSequence g = new GetInitialTestSequence();
//		IDGenerator.getInstance().clear();
//		/**
//		 * 测试使用的graph
//		 */
//		Graph tg = new Graph();
//		LinkedHashSet<Node> tnode = tg.getNodes();
//		ArrayList<Edge> tedge = tg.getEdges();
//		
//		Node n0 = new Node();
//		n0.setName("Start");
//		n0.setType(Constants.INITIAL);
//		n0.setId(0);
//		tnode.add(n0);
//
//		Node n1 = new Node();
//		n1.setName("Init");
//		n1.setType(Constants.INITIAL);
//		n1.setId(1);
//		tnode.add(n1);
//		
//		Node n2 = new Node();
//		n2.setName("login");
//		n2.setType(Constants.Input);
//		n2.setId(2);
//		
//		ArrayList<Condition> ec = new ArrayList<Condition>();
//		Condition p0 = new Condition();
//		p0.setId(0);
//		p0.setContent("login_?_License#String");
//		ec.add(p0);
//		Condition p1 = new Condition();
//		p1.setId(1);
//		p1.setContent("login_?_loginTime#int");
//		ec.add(p1);
//		n2.setCondition(ec);
//		n2.setIterationC(false);
//		n2.setInvokeOpC("nullCondition");
//		n2.setIpRegionC("nullCondition");
//		n2.setParaRelationC("nullCondition");
//		n2.setPreOpC("nullCondition");
//		
//		tnode.add(n2);
//		
//		Node n3 = new Node();
//		n3.setName("loginResponse_succ");
//		n3.setType(Constants.Output);
//		n3.setId(3);
//		tnode.add(n3);
//		
//		Node n4 = new Node();
//		n4.setName("loginResponse_fail");
//		n4.setType(Constants.Output);
//		n4.setId(4);
//		tnode.add(n4);
//		
//		Node n5 = new Node();
//		
//		ArrayList<Condition> ec0 = new ArrayList<Condition>();
//		Condition p2 = new Condition();
//		p2.setId(0);
//		p2.setContent("feeCalculate_?_License#String");
//		ec0.add(p2);
//		Condition p3 = new Condition();
//		p3.setId(1);
//		p3.setContent("feeCalculate_?_type#int");
//		ec0.add(p3);
//		Condition p4 = new Condition();
//		p4.setId(2);
//		p4.setContent("feeCalculate_?_timeout#int");
//		ec0.add(p4);
//		Condition p5 = new Condition();
//		p5.setId(3);
//		p5.setContent("feeCalculate_?_dayOfWeek#boolean");
//		ec0.add(p5);
//		Condition p6 = new Condition();
//		p6.setId(4);
//		p6.setContent("feeCalculate_?_discountCoupon#boolean");
//		ec0.add(p6);
//		
//		n5.setCondition(ec0);
//		n5.setName("feeCalculate");
//		n5.setType(Constants.Input);
//		n5.setId(5);
//		n5.setIterationC(false);
//		n5.setInvokeOpC("nullCondition");
//		n5.setIpRegionC("nullCondition");
//		n5.setParaRelationC("feeCalculateRequest.License == loginRequest.License AND feeCalculateRequest.timeout >= loginRequest.loginTime");
//		n5.setPreOpC("((login)(loginResponse_Success)(feeCalculate)(feeCalculateResponse_Success))*(login)(loginResponse_Success)");
//		tnode.add(n5);
//		
//		Node n6 = new Node();
//		n6.setName("feeCalculateResponse_succ");
//		n6.setType(Constants.Output);
//		n6.setId(6);
//		tnode.add(n6);
//		
//		Node n7 = new Node();
//		n7.setName("feeCalculateResponse_fail");
//		n7.setType(Constants.Output);
//		n7.setId(7);
//		tnode.add(n7);
//		
//		Node n8 = new Node();
//		n8.setName("End");
//		n8.setType(Constants.END);
//		n8.setId(8);
//		tnode.add(n8);
//		
//		Edge e0 = new Edge();
//		e0.setFrom(0);
//		e0.setTo(1);
//		e0.setName("e0");
//		tedge.add(e0);
//		
//		Edge e1 = new Edge();
//		e1.setFrom(1);
//		e1.setTo(2);
//		e1.setName("InitFunction");
//		tedge.add(e1);
//		
//		Edge e2 = new Edge();
//		e2.setFrom(2);
//		e2.setTo(3);
//		e2.setName("login_succ_edge");
//		tedge.add(e2);
//		
//		Edge e3 = new Edge();
//		e3.setFrom(2);
//		e3.setTo(4);
//		e3.setName("login_fail_edge");
//		tedge.add(e3);
//		
//		Edge e4 = new Edge();
//		e4.setFrom(3);
//		e4.setTo(5);
//		e4.setName("e4");
//		tedge.add(e4);
//		
//		Edge e5 = new Edge();
//		e5.setFrom(5);
//		e5.setTo(6);
//		e5.setName("feeCalculate_succ_edge");
//		tedge.add(e5);
//		
//		Edge e6 = new Edge();
//		e6.setFrom(5);
//		e6.setTo(7);
//		e6.setName("feeCalculate_fail_edge");
//		tedge.add(e6);
//		
//		Edge e7 = new Edge();
//		e7.setFrom(6);
//		e7.setTo(2);
//		e7.setName("e7");
//		tedge.add(e7);
//		
//		Edge e8 = new Edge();
//		e8.setFrom(4);
//		e8.setTo(8);
//		e8.setName("e8");
//		tedge.add(e8);
//		
//		Edge e9 = new Edge();
//		e9.setFrom(3);
//		e9.setTo(8);
//		e9.setName("e9");
//		tedge.add(e9);
//		
//		Edge e10 = new Edge();
//		e10.setFrom(6);
//		e10.setTo(8);
//		e10.setName("e10");
//		tedge.add(e10);
//		
//		Edge e11 = new Edge();
//		e11.setFrom(7);
//		e11.setTo(8);
//		e11.setName("e11");
//		tedge.add(e11);
//		
////		g.chooseCovCri(CoverageCriteria.OP_Cover, true, tg);
////		System.out.println("=============================");
////		g.chooseCovCri(CoverageCriteria.RM_Cover, true, tg);
////		System.out.println("=============================");
//		g.chooseCovCri(CoverageCriteria.Edge_Cover, false, tg);
//		
////		String cmd = "java -jar " + jarPath + " offline --model " + graphFile +  " \"a_star(reached_vertex(loginRequest))\"";
////		System.out.println(g.getInitGraphWalkerResult(cmd));
//	}
	
	public ArrayList<TeatSequence> chooseCovCri(int Cover,boolean ifAddState) { //根据选择的覆盖准则，生成测试用例
		LinkedHashSet<Node> nodes = g.getNodes();
		ArrayList<Edge> edges = g.getEdges();
		ArrayList<String> ele = new ArrayList<String>();
		if(Cover == 0) { //Operation coverage
			for (Node node: nodes) {
				if(node.getType() == "input") {
					ele.add(node.getName());
					String cmd = "java -jar " + jarPath + " offline --model " + graphFile +  " \"a_star(reached_vertex("+ node.getName() + "))\"";
					int from = node.getId();
					String resSuccNodeName = node.getName() + "Response_succ";
					int to  = g.getNode(resSuccNodeName).getId();
					String testS = getInitGraphWalkerResult(cmd,Cover) + "#" + g.getEdge(from, to).getName() + "#" + resSuccNodeName;
					int count = testS.split("#").length;
					initTsmap.put(testS,count);
//					System.out.println(testS);
				}
			}
//			TestSequenceModel tsm = reRedundancy(initTsmap,ele);
		}else if(Cover == 1) {//Response-Message covering
//			ArrayList<String> ele = new ArrayList<String>();
			for (Node node: nodes) {
				if(node.getType() == "output") {
					ele.add(node.getName());
					String cmd = "java -jar " + jarPath + " offline --model " + graphFile +  " \"a_star(reached_vertex("+ node.getName() + "))\"";
					String testS = getInitGraphWalkerResult(cmd,Cover);
					int count = testS.split("#").length;
					initTsmap.put(testS,count);
//					System.out.println(testS);
				}
			}
//			TestSequenceModel tsm = reRedundancy(initTsmap,ele);
		}else { //Edge covering
//			ArrayList<String> ele = new ArrayList<String>();
			for(int i = 0;i<edges.size();i++) {
				if(edges.get(i).getTo() != nodes.size()-1) {
					ele.add(edges.get(i).getName());
					String cmd = "java -jar " + jarPath + " offline --model " + graphFile +  " \"a_star(reached_edge("+ edges.get(i).getName() + "))\"";
					String testS = getInitGraphWalkerResult(cmd,Cover);
					if(g.getNode(edges.get(i).getTo()).getType() == "output"){ //边的到达节点为响应节点
						testS = testS + "#" + g.getNode(edges.get(i).getTo()).getName();
					}else if(g.getNode(edges.get(i).getTo()).getType() == "input"){ //边的到达节点为请求节点
						
						String inovkeNodeName = g.getNode(edges.get(i).getTo()).getName();//请求节点名称
						String resSuccNodeName = inovkeNodeName + "Response_succ";//响应节点名称
						int from = edges.get(i).getTo();
						int to  = g.getNode(resSuccNodeName).getId();
						testS = testS + "#" + inovkeNodeName + "#" + g.getEdge(from, to).getName() + "#" + resSuccNodeName;
					}else {//边的到达节点为其他类型节点
						
					}
					int count = testS.split("#").length;
					initTsmap.put(testS,count);
//					System.out.println(testS);
				}
			}
		}
		TestSequenceModel tsm = reRedundancy(initTsmap,ele); //去除冗余
		ArrayList<TeatSequence> tss = tsm.getTeatSequenceList();
		//TODO
		//违反服务序列约束和重复调用约束的测试路序列生成
		for (Node node: nodes) {
			if(node.getType() == "input") {
				if(!node.getIterationC()) { //考虑违反重复调用序列的问题
					String cmd = "java -jar " + jarPath + " offline --model " + graphFile +  " \"a_star(reached_vertex("+ node.getName() + "Response_succ))\"";
					String testS = getInitGraphWalkerResult(cmd,1) + "#ef#" + node.getName(); // + "#ef#" + "" + node.getName() + "Response_succ"
					TeatSequence ts = new TeatSequence();
					ts.setTcId(IDGenerator.getInstance().getNextId());
					ts.setTs(testS);
					ts.setTsLength(testS.split("#").length);
					ArrayList<String> eleCover = new ArrayList<String>();
					eleCover.add(node.getName());
					ts.setCoverElement(eleCover);
					ts.setType("negative(Iteration)");
					tss.add(ts);
				}
				
				if(! node.getPreOpC().equals("NullConstraint")) { //违反服务序列约束
					//找出到覆盖到init节点的路径，后续添加错误序列
					String testS = "Start#e0#Init#ef#" + node.getName();
					TeatSequence ts = new TeatSequence();
					ts.setTcId(IDGenerator.getInstance().getNextId());
					ts.setTs(testS);
					ts.setTsLength(testS.split("#").length);
					ArrayList<String> eleCover = new ArrayList<String>();
					eleCover.add(node.getName());
					ts.setCoverElement(eleCover);
					ts.setType("negative(PreOp)");
					tss.add(ts);
				}
			}
		}
		return tss;
//		TestDateG tdg = new TestDateG(g,name);
//		for(int i=0;i<tss.size();i++) { 
////			System.out.println(tss.get(i).getTs());
//			//针对每个测试序列，约束求解生成测试数据
//			tdg.testSequenceProcess(tss.get(i).getTs(),tss.get(i).getTcId()); //测试序列字符串传过去
//			//将测试数据按照框架转换为soap测试脚本
//			DataToCase dtc = new DataToCase(name,g);
//			dtc.generTestCase(tss.get(i).getTs(),tss.get(i).getTcId());
//		}

	}
	
	/**
	 * 生成初始测试序列，未去除冗余
	 * @param cmd
	 * @param Cover
	 * @return
	 */
	public String getInitGraphWalkerResult(String cmd,int Cover) {
		String result = "";
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;  
            StringBuilder sb = new StringBuilder();
            sb.append("Start");
            while ((line = br.readLine()) != null) {
            	//TODO 处理一下使得只留下节点和边即可
            	JSONObject obj = JSONObject.fromObject(line);
            	String sequence = obj.getString("currentElementName");
                sb.append("#" + sequence);
            }
            result = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 去掉冗余序列
	 * @param initTsmap
	 * @param ele
	 * @return
	 */
	public TestSequenceModel reRedundancy(HashMap<String,Integer> initTsmap,ArrayList<String> ele) {
		TestSequenceModel tsm = new TestSequenceModel();
		ArrayList<TeatSequence> tsl = new ArrayList<TeatSequence>();
		int cover = ele.size();
		while(cover !=0) { //没有覆盖完全
			boolean flag = false; //是否覆盖了还未覆盖的新的对象
			int max = 0; //最长序列长度
			String targetTs = ""; //最长序列
			ArrayList<String> eleCover = new ArrayList<String>(); //选中的序列覆盖的对象的集合
			
			//取一个最长的序列
			for (String key : initTsmap.keySet()) {
				int temp = initTsmap.get(key);
				if(temp > max) {
					max = temp;
					targetTs = key;
				}
			}
			TeatSequence ts = new TeatSequence();
			ts.setTs(targetTs);
			ts.setTsLength(max);
			
			//判断序列中覆盖了哪些还未覆盖的目标对象
			for(int i=0;i<ele.size();i++) {
				if(targetTs.contains(ele.get(i))) {
					flag = true;
					eleCover.add(ele.get(i));
					cover = cover -1;
				}
			}
			
			//删除已经覆盖的目标对象及选取的最长序列
			if(flag) {
				for(int i = 0;i<eleCover.size();i++) {
					ele.remove(eleCover.get(i));
				}
				ts.setTcId(IDGenerator.getInstance().getNextId());
				ts.setCoverElement(eleCover);
				ts.setType("positive");
				tsl.add(ts);
			}
			initTsmap.remove(targetTs);
		}
		tsm.setTeatSequenceList(tsl);
//		for(int i=0;i<tsm.getTeatSequenceList().size();i++) {
//			System.out.println(tsm.getTeatSequenceList().get(i).getTs());
//			for(int j = 0;j<tsm.getTeatSequenceList().get(i).getCoverElement().size();j++) {
//				System.out.println(tsm.getTeatSequenceList().get(i).getCoverElement().get(j));
//			}
//		}
		return tsm;
	}
	
	/**
	 * 针对测试序列生成可执行的测试用例
	 * @param tss
	 */
	public void getTestCase(ArrayList<TeatSequence> tss) {
		TestDateG tdg = new TestDateG(g,name);
		for(int i=0;i<tss.size();i++) {
//		System.out.println(tss.get(i).getTs());
			//针对每个非违反序列约束的测试序列，约束求解生成测试数据
			if(tss.get(i).getType().equals("positive")) {
				tdg.testSequenceProcess(tss.get(i).getTs(),tss.get(i).getTcId()); //测试序列字符串传过去
				//将测试数据按照框架转换为soap测试脚本
				DataToCase dtc = new DataToCase(name,g);
				dtc.generTestCase(tss.get(i).getTs(),tss.get(i).getTcId());
			}else if(tss.get(i).getType().equals("negative(PreOp)")) {
				DataToCase dtc = new DataToCase(name,g);
				dtc.generPreOpTestCase(tss.get(i).getTs(),tss.get(i).getTcId());
			}else {
				//处理字符串，找到#ef前的正确调用
				String str = tss.get(i).getTs();
				int index = str.indexOf("#ef");
				String oldStr = str.substring(0, index);
				String newStr = str.substring(index + 4);
				for (int j=0;j<tss.size();j++) {
					if(tss.get(j).getTs().contains(oldStr)) {
						int Id = tss.get(j).getTcId();
						//已经有的testData数据进行重命名复制
						DataToCase dtc = new DataToCase(name,g);
						dtc.generIterationTestCase(newStr, oldStr, tss.get(i).getTcId(), Id);
						break;
					}
				}
			}
		}
	}
}
