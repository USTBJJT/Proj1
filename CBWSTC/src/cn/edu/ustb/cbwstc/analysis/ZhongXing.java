package cn.edu.ustb.cbwstc.analysis;

import java.util.Arrays;

public class ZhongXing {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 4;
		int[] c = {2,2,2,2};
		Arrays.sort(c);
		System.out.println(max(num,c));
	}
	
	public static int max(int num,int[] c) {
		int result = 0;
		if(num==0 || c == null || c.length == 0) {
			return result;
		}
		int i = 0;
		int j = 1;
		while(c[0] != 0) {
			if(c[1] == 0) {
				result = result + 1;
				break;
			}else {
				result = result + 2*c[1];
				c[0] = c[0] - c[1];
				System.out.println(c[0]);
				c[1] = 0;
				Arrays.sort(c);
			}
			
		}
		return result;
	}

}
