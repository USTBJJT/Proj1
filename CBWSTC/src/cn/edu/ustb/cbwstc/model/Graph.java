package cn.edu.ustb.cbwstc.model;

import java.util.ArrayList;

public class Graph {
	
	private String name;
	
	private String endTime;
	
	private ArrayList<Node> nodes = new ArrayList<Node>(); //�ڵ㼯��

	private ArrayList<Edge> edges = new ArrayList<Edge>(); //�߼���
	
	private ArrayList<Edge> edgesList = new ArrayList<Edge>();

	public ArrayList<Edge> getEdgesList() {
		return edgesList;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
