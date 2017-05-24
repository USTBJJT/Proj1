package cn.edu.ustb.cbwstc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Node {
	
	private int id; //节点编号，为了后续edge起始节点与结束节点进行标记使用

	private String name; //节点名称（是否是调用的操作 ，被调用操作的名字；或者只是一个结构节点）

	private String type; //节点类型，标记该节点属于什么类型，比如初始节点、结束节点、基本活动、分支节点等等

	private int responseId;

	private int childNumber;
	
	private HashMap<String, String> vaHashMap=new HashMap<String, String>();

	private ArrayList<Node> beforeNodes = new ArrayList<Node>(); //该节点的前继节点

	private ArrayList<Node> afterNodes = new ArrayList<Node>(); //给节点的后继节点
	
	private ArrayList<Condition> condition = new ArrayList<Condition>(); //约束的集合
	
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
	
	public ArrayList getBeforeNodes() {
		return beforeNodes;
	}

	public void setBeforeNodes(ArrayList beforeNodes) {
		this.beforeNodes = beforeNodes;
	}

	public ArrayList getAfterNodes() {
		return afterNodes;
	}

	public void setAfterNodes(ArrayList afterNodes) {
		this.afterNodes = afterNodes;
	}
	
	public void setVaHashMap(HashMap<String, String> vaHashMap) {
		this.vaHashMap = vaHashMap;
	}
	
	public String getCondition() {
		String ConditionList = "";
		for(int i = 0;i < condition.size(); i ++){
			ConditionList = ConditionList + getName() + ":" + condition.get(i).getContent() + "\n";
        }
		return ConditionList;
	}

	public void setCondition(ArrayList<Condition> condition) {
		this.condition = condition;
	}

}
