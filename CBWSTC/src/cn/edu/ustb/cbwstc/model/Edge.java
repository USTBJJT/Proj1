package cn.edu.ustb.cbwstc.model;

import java.util.ArrayList;

public class Edge {
	
	private int from; //�����ڵ�

	private int to; //�����ڵ�

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

}
