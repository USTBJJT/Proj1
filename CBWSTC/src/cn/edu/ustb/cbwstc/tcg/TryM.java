package cn.edu.ustb.cbwstc.tcg;

import java.math.BigDecimal;

public class TryM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int totalDigits = 5;
		StringBuffer sb = new StringBuffer(totalDigits); //为这个Buffer开辟totalDigits个字符的空间
		for (int i = 0; i < totalDigits; i++)
			sb.append('9'); //填充字符
		BigDecimal digitsLimit = new BigDecimal(sb.toString());
		System.out.println(digitsLimit);
		digitsLimit = digitsLimit.negate();
		System.out.println(digitsLimit);

	}

}
