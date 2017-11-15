package cn.edu.ustb.cbwstc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

import net.sf.json.JSONArray;

public class Node {
	
	private int id; //�ڵ��ţ�Ϊ�˺���edge��ʼ�ڵ�������ڵ���б��ʹ��

	private String name; //�ڵ����ƣ��Ƿ��ǵ��õĲ��� �������ò��������֣�����ֻ��һ���ṹ�ڵ㣩

	private String type; //�ڵ����ͣ���Ǹýڵ�����ʲô���ͣ������ʼ�ڵ㡢�����ڵ㡢���ýڵ㡢��Ӧ�ڵ�

//	private int responseId;
//
//	private int childNumber;
//	
//	private HashMap<String, String> vaHashMap=new HashMap<String, String>();

//	private ArrayList<Node> beforeNodes = new ArrayList<Node>(); //�ýڵ��ǰ�̽ڵ�
	
	private LinkedHashSet<Node> beforeNodes = new LinkedHashSet<Node>(); //�ýڵ��ǰ�̽ڵ�

//	private ArrayList<Node> afterNodes = new ArrayList<Node>(); //�ýڵ�ĺ�̽ڵ�
	
	private LinkedHashSet<Node> afterNodes = new LinkedHashSet<Node>(); //�ýڵ�ĺ�̽ڵ�
	
	private ArrayList<Condition> condition = new ArrayList<Condition>(); //����Լ���ļ���
	
	private JSONArray paraRelationC = null; //������ϵԼ��
	
	private String ipRegionC = ""; //����Լ��
	
	private JSONArray invokeOpC = null; //����Լ��
	
	private String preOpC = ""; //����Լ��
	
	private boolean IterationC; //�ظ�ִ��Լ��
	
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
	 * ��дNode���equals������Ϊ���ܹ����ظ���ͼ�ࡢBeforeNodes��AfterNodes���������ͬ�ڵ�
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Node))
	           return false;
		Node node = (Node) obj;
		return node.name == name;
	}
	
	/**
	 * ��дNode���hashCode����
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
