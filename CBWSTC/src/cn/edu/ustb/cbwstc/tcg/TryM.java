package cn.edu.ustb.cbwstc.tcg;

import java.math.BigDecimal;

public class TryM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int totalDigits = 5;
		StringBuffer sb = new StringBuffer(totalDigits); //Ϊ���Buffer����totalDigits���ַ��Ŀռ�
		for (int i = 0; i < totalDigits; i++)
			sb.append('9'); //����ַ�
		BigDecimal digitsLimit = new BigDecimal(sb.toString());
		System.out.println(digitsLimit);
		digitsLimit = digitsLimit.negate();
		System.out.println(digitsLimit);

	}

}
