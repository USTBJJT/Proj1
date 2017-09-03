package cn.edu.ustb.cbwstc.analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StringLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int line = s.nextInt();
		String[] sarray = new String[line];
		for(int i=0;i<line;i++) {
			sarray[i] = s.next();
		}
		System.out.println(countNumber(sarray));

	}
	
	public static int countNumber(String[] a) {
		ArrayList<String> list = new ArrayList<String>();
		int count = 0;
		boolean temp = false;
		for(int i=0;i<a.length;i++) {
			Iterator<String> it=list.iterator();
			while(it.hasNext()) {
				if(isEqual(a[i],(String)it.next())) {
					temp = true;
					break;
				}
			}
			if(!temp) {
				count++;
				list.add(a[i]);
			}else {
				temp = false;
			}
		}
		return count;
	}
	
	public static boolean isEqual(String str1,String str2) {
		if(str1 == null|| str1.length() == 0 ||str2 == null|| str2.length() == 0 ) {
			return false;
		}
		if(str1.length() != str2.length()) {
			return false;
		}
		 String str=str1.concat(str1);
		if(str.contains(str2)) {
			return true;
		}else{
			return false;
		}
	}

}
