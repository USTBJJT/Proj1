package cn.edu.ustb.cbwstc.analysis;

import java.util.Scanner;

public class AddFish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int min = s.nextInt();
		int max = s.nextInt();
		int number = s.nextInt();
		int[] a = new int[number];
		for(int i=0;i<number;i++) {
			a[i] = s.nextInt();
		}
		System.out.println(countFish(min,max,a));
	}
	
	public static int countFish(int min,int max,int[] a) {
		int count = 0;
		for(int i=min;i<=max;i++) {
			boolean flag = true;
			for(int j=0;j<a.length;j++) {
				if(a[j]/i>=2 && a[j]/i<=10) {
					if(a[j]/i==10 && a[j]%i !=0) {
						continue;
					}
					flag = false;
					break;
				}
				if(i/a[j] >=2 && i/a[j] <=10) {
					if(i/a[j] ==10 && i%a[j] !=0) {
						continue;
					}
					flag = false;
					break;
				}
			}
			if(flag) {
				count++;
			}
		}
		return count;
	}

}
