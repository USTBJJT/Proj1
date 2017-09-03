package cn.edu.ustb.cbwstc.analysis;

import java.util.ArrayList;

public class ArrayListTry {
	
	private static ArrayList<String> a = new ArrayList<String>();
	private static ArrayList<String> b = new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a.add("4");
		a.add("5");
		a.add("1");
		a.add("7");
		
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		
		for(int i=0;i<b.size();i++) {
			System.out.println(b.get(i));
		}
		
		System.out.println(a.size());
		System.out.println(b.size());
	}

}
