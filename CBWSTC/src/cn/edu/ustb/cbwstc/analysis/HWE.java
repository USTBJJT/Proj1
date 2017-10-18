package cn.edu.ustb.cbwstc.analysis;

import java.util.Scanner;

public class HWE {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();
			int[][] a = new int[n][n];
			int[][] dp = new int[n][n];
			for(int i=0;i<=n-1;i++)
			       for(int j=0;j<=i;j++)
			    	   a[i][j] = s.nextInt();
			for(int j=0;j<n;j++) {
				dp[n-1][j]=a[n-1][j];
			}
			for(int i=n-2;i>=0;i--)
			       for(int j=0;j<=i;j++)
			       dp[i][j]=a[i][j]+ findMax(dp[i+1][j],dp[i+1][j+1]);
			System.out.println(dp[0][0]);
		}
	}
	
	public static int findMax(int a,int b) {
		return a>b?a:b;
	}

}
