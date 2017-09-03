package cn.edu.ustb.cbwstc.analysis;

public class ArrayChose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]a = {{1,2,3,4},{5,6},{7,8,9,10}};
		ArrayChose ac = new ArrayChose();
		ac.printArray(a);
	}
	
	public void printArray(int[][] a) {
		int count = 1;
		for(int i=0; i<a.length; i++) {
			count = count * a[i].length;
		}
		count = count-1;
		System.out.println(count);
		while(count >=0) {
			int temp = count;
			String s = "";
			for(int i=0; i<a.length; i++) {
				if(temp/a[i].length >= 0) {
					s += a[i][temp % a[i].length];
					temp /= a[i].length;
				}
			}
			System.out.println(s);
			count--;
		}
	}
	

}
