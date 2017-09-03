package cn.edu.ustb.cbwstc.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Graph {
	
	private String name;
	
	private Date endTime;
	
//	private ArrayList<Node> nodes = new ArrayList<Node>(); //节点集合
	
	private LinkedHashSet<Node> nodes = new LinkedHashSet<Node>(); //节点集合

	private ArrayList<Edge> edges = new ArrayList<Edge>(); //边集合
	
	private ArrayList<Edge> edgesList = new ArrayList<Edge>();

	public ArrayList<Edge> getEdgesList() {
		return edgesList;
	}

	public LinkedHashSet<Node> getNodes() {
		return nodes;
	}
	
	/**
	 * 依据Node的名字找到图中是否存在该Node
	 * @param str
	 * @return
	 */
	public boolean hasNode(String str) {
		for (Node node: nodes) {
			if(node.getName().equals(str)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 依据Node的名字找到该Node
	 * @param str
	 * @return
	 */
	public Node getNode(String str) {
		for (Node node: nodes) {
			if(node.getName().equals(str)) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * 依据Node的id找到该Node
	 * @param str
	 * @return
	 */
	public Node getNode(int id) {
		for (Node node: nodes) {
			if(node.getId() == id) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * 根据from to节点id找到该edge
	 * @param from
	 * @param to
	 * @return
	 */
	public Edge getEdge(int from,int to) {
		for(int i=0;i<edges.size();i++) {
			if(edges.get(i).getFrom() == from && edges.get(i).getTo() == to) {
				return edges.get(i);
			}
		}
		return null;
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
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = new Date();
		try {
			date = sdf.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.endTime = date;
	}
	
	public void setEndTime(Date d) {
		this.endTime = d;
	}

}
