package cn.edu.ustb.cbwstc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

import net.sf.json.JSONArray;

public class Node {
	
	private int id; //节点编号，为了后续edge起始节点与结束节点进行标记使用

	private String name; //节点名称（是否是调用的操作 ，被调用操作的名字；或者只是一个结构节点）

	private String type; //节点类型，标记该节点属于什么类型，比如初始节点、结束节点、调用节点、响应节点

//	private int responseId;
//
//	private int childNumber;
//	
//	private HashMap<String, String> vaHashMap=new HashMap<String, String>();

//	private ArrayList<Node> beforeNodes = new ArrayList<Node>(); //该节点的前继节点
	
	private LinkedHashSet<Node> beforeNodes = new LinkedHashSet<Node>(); //该节点的前继节点

//	private ArrayList<Node> afterNodes = new ArrayList<Node>(); //该节点的后继节点
	
	private LinkedHashSet<Node> afterNodes = new LinkedHashSet<Node>(); //该节点的后继节点
	
	private ArrayList<Condition> condition = new ArrayList<Condition>(); //参数约束的集合
	
	private JSONArray paraRelationC = null; //参数关系约束
	
	private String ipRegionC = ""; //区域约束
	
	private JSONArray invokeOpC = null; //调用约束
	
	private String preOpC = ""; //序列约束
	
	private boolean IterationC; //重复执行约束
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public LinkedHashSet<Node> getBeforeNodes() {
		return beforeNodes;
	}

	public void setBeforeNodes(LinkedHashSet<Node> beforeNodes) {
		this.beforeNodes = beforeNodes;
	}

	public LinkedHashSet<Node> getAfterNodes() {
		return afterNodes;
	}

	public void setAfterNodes(LinkedHashSet<Node> afterNodes) {
		this.afterNodes = afterNodes;
	}
	
//	public void setVaHashMap(HashMap<String, String> vaHashMap) {
//		this.vaHashMap = vaHashMap;
//	}
	
	public ArrayList<Condition> getCondition() {
//		String ConditionList = "";
//		for(int i = 0;i < condition.size(); i ++){
//			ConditionList = ConditionList + getName() + ":" + condition.get(i).getContent() + "\n";
//        }
		
		return condition;
	}

	public void setCondition(ArrayList<Condition> condition) {
		this.condition = condition;
	}
	
	/**
	 * 重写Node类的equals方法，为了能够不重复在图类、BeforeNodes、AfterNodes里面添加相同节点
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Node))
	           return false;
		Node node = (Node) obj;
		return node.name == name;
	}
	
	/**
	 * 重写Node类的hashCode方法
	 */
	public int hashCode() {
		return name.hashCode();
	}

	public JSONArray getParaRelationC() {
		return paraRelationC;
	}

	public void setParaRelationC(JSONArray paraRelationC) {
		this.paraRelationC = paraRelationC;
	}

	public String getIpRegionC() {
		return ipRegionC;
	}

	public void setIpRegionC(String ipRegionC) {
		this.ipRegionC = ipRegionC;
	}

	public JSONArray getInvokeOpC() {
		return invokeOpC;
	}

	public void setInvokeOpC(JSONArray invokeOpC) {
		this.invokeOpC = invokeOpC;
	}

	public String getPreOpC() {
		return preOpC;
	}

	public void setPreOpC(String preOpC) {
		this.preOpC = preOpC;
	}

	public boolean getIterationC() {
		return IterationC;
	}

	public void setIterationC(boolean iterationC) {
		IterationC = iterationC;
	}

}
