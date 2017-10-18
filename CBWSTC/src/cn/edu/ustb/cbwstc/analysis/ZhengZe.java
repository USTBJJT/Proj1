package cn.edu.ustb.cbwstc.analysis;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import nl.flotsam.xeger.Xeger;

public class ZhengZe {
	
	private static String regEx = "((login)(loginResponse_succ)(feeCalculate)(feeCalculateResponse_succ))*(login)(loginResponse_succ)";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(check(str,regEx));
		
	}
//	public static String gerTcg(String regex) {
//		Xeger generator = new Xeger(regex);
//		String result = generator.generate(); 
//		return result;
//	}
	
	public static boolean check(String str,String regEx) {
		Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        boolean rs = m.matches();
		return rs;
	}

}
