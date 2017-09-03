package cn.edu.ustb.cbwstc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexpMatching {
	
	public boolean check(String str,String regEx) {
		Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        boolean rs = m.matches();
		return rs;
	}

}
