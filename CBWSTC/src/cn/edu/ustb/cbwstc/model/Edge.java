package cn.edu.ustb.cbwstc.model;

public class Edge {
	
	private String name;
	
	private int from; //出发节点

	private int to; //结束节点

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public String toString() {
		return this.getFrom() + " " + this.getTo();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
