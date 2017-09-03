package cn.edu.ustb.cbwstc.analysis;

import java.util.HashSet;

import cn.edu.ustb.cbwstc.model.Node;

public class ListNotCF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Node> set = new HashSet<Node>();
		Node a1 = new Node();
		a1.setName("haha");
		Node a2 = new Node();
		a2.setName("haha");
		set.add(a1);
		set.add(a2);
		System.out.println(set.size());
		
		HashSet<String> setS = new HashSet<String>();
		String s1 = "JJT";
		String s2 = "JJT";
		setS.add(s1);
		setS.add(s2);
		System.out.println(setS.size());
		

	}

}
