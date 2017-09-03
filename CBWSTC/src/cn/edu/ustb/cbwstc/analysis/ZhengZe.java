package cn.edu.ustb.cbwstc.analysis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nl.flotsam.xeger.Xeger;

public class ZhengZe {
	
	private static String regEx = "((login)(loginResponse_Success)(feeCalculate)(feeCalculateResponse_Success))*(login)(loginResponse_Success)";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(gerTcg("((login)(loginResponse_Success)(feeCalculate)(feeCalculateResponse_Success))*(login)(loginResponse_Success)"));
		System.out.println(check(""));
		System.out.println(gerTcg("5678|ghfr|888"));
	}
	public static String gerTcg(String regex) {
		Xeger generator = new Xeger(regex);
		String result = generator.generate(); 
		return result;
	}
	
	public static boolean check(String str) {
		Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        boolean rs = m.matches();
		return rs;
	}

}
