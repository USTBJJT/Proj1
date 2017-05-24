package cn.edu.ustb.cbwstc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Node {
	
	private int id; //�ڵ��ţ�Ϊ�˺���edge��ʼ�ڵ�������ڵ���б��ʹ��

	private String name; //�ڵ����ƣ��Ƿ��ǵ��õĲ��� �������ò��������֣�����ֻ��һ���ṹ�ڵ㣩

	private String type; //�ڵ����ͣ���Ǹýڵ�����ʲô���ͣ������ʼ�ڵ㡢�����ڵ㡢���������֧�ڵ�ȵ�

	private int responseId;

	private int childNumber;
	
	private HashMap<String, String> vaHashMap=new HashMap<String, String>();

	private ArrayList<Node> beforeNodes = new ArrayList<Node>(); //�ýڵ��ǰ�̽ڵ�

	private ArrayList<Node> afterNodes = new ArrayList<Node>(); //���ڵ�ĺ�̽ڵ�
	
	private ArrayList<Condition> condition = new ArrayList<Condition>(); //Լ���ļ���
	
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
