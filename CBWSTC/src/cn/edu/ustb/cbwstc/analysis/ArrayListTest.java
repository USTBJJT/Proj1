package cn.edu.ustb.cbwstc.analysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ArrayListTest {
	
	private static HashSet<String> s = new HashSet<String>(); //变异体集合

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s.add("AOS1");
		s.add("AOS2");
		s.add("AOS3");
		s.add("AOS4");
		s.add("AOS5");
		s.add("AOS6");
		s.add("AOS7");
		System.out.println(s.size());
		Iterator<String> i = s.iterator();
        while(i.hasNext()){
               String temp = (String)i.next();
               if(temp.equals("AOS1")) {
            	   s.remove("AOS1");
               }
               System.out.println(temp);
        }
//		ArrayList<Integer> kill = new ArrayList<Integer>();
//		kill.add(0);
//		kill.add(2);
//		kill.add(4);
//		for(int k=0;k<kill.size();k++) {
//			s.remove(kill.get(k));
//		}
		
//		s.remove("AOS1");
//		s.remove("AOS5");
		System.out.println("***********");
		System.out.println(s.size());
		Iterator<String> j = s.iterator();
        while(j.hasNext()){
               String temp = (String)j.next();
               System.out.println(temp);
        }
	}

}
