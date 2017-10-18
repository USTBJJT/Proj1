package cn.edu.ustb.cbwstc.analysis;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class XiaoChu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String choose = sc.nextLine();
		char[] s = str.toCharArray();
		char[] c = choose.toCharArray();
		System.out.println(myFinal(s,c));
	}
	
	public static int myFinal(char[] s,char[] c) {
		int result = 0;
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		HashMap<String,Integer> map1 = new HashMap<String,Integer>();
		for(int i=0;i<s.length;i++) {
			map.put(String.valueOf(s[i]), map.getOrDefault(String.valueOf(s[i]), 0) + 1);
			map1.put(String.valueOf(s[i]), map1.getOrDefault(String.valueOf(s[i]), 0) + 1);
		}
		for(int i=0;i<c.length;i++) {
			if(map.get(String.valueOf(c[i])) != null) {
				int count = map.get(String.valueOf(c[i]));
				map.put(String.valueOf(c[i]), count+ 1);
			}
		}
		for(Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() < 3) {
				return -1;
			}
		}
		for(Entry<String, Integer> entry : map1.entrySet()) {
			result = result + 3 - entry.getValue();
		}
		return result;
	}
	
	

}
