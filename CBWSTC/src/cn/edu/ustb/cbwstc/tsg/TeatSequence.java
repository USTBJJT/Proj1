package cn.edu.ustb.cbwstc.tsg;

import java.util.ArrayList;

public class TeatSequence {
	
	private int tcId; //�������б��
	private ArrayList<String> coverElement; //���Ƕ��󼯺�
	private String ts; //��������
	private int tsLength; //�������г���
	private String type = "";
	
	public int getTcId() {
		return tcId;
	}
	
	public void setTcId(int tcId) {
		this.tcId = tcId;
	}
	
	public ArrayList<String> getCoverElement() {
		return coverElement;
	}
	
	public void setCoverElement(ArrayList<String> coverElement) {
		this.coverElement = coverElement;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public int getTsLength() {
		return tsLength;
	}

	public void setTsLength(int tsLength) {
		this.tsLength = tsLength;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
