package cn.edu.ustb.cbwstc.analysis;

import java.text.DecimalFormat;

public class BFB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=90;  
        int b=50; 
        int c = 40;
        DecimalFormat df = new DecimalFormat("0.00");//��ʽ��С��    
        String num = df.format(((float)b/a)*100);//���ص���String����    
        String num2 = df.format((float)c/a);//���ص���String����    
        System.out.println("ddd==="+num);
        System.out.println("ddd2==="+num2);

	}

}
