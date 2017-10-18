package cn.edu.ustb.cbwstc.util;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(matcherRegularExpression("((login)(loginResponse_succ)(feeCalculate)(feeCalculateResponse_succ))*(login)(loginResponse_succ)","loginResponse_succfeeCalculate"));

	}
	public static boolean matcherRegularExpression(String regEx, String str) {
		HashMap<String,String> map = new HashMap<String,String>();
		
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);  
        boolean found = false;  
        while (matcher.find()) {  
            System.out.println("发现 \"" + matcher.group() + "\" 开始于 "  
            + matcher.start() + " 结束于 " + matcher.end());  
            found = true;  
        }  
        return found;  
    }

}
