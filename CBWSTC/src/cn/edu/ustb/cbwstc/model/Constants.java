package cn.edu.ustb.cbwstc.model;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static String INITIAL = "initial";

	public static String END = "end";
	
	public static String Input = "input";
	
	public static String Output = "output";

	// condition
	public static Map conditionMap() {
		Map<String, String> conditions = new HashMap<String, String>();
		conditions.put("&gt;", ">");
		conditions.put("&lt;", "<");
		conditions.put("&lt;=", "<=");
		conditions.put("&gt;=", ">=");
		conditions.put("=", "==");
		conditions.put("��", "!=");
		return conditions;
	}

	public static Map converseMap() {
		Map<String, String> conditions = new HashMap<String, String>();
		conditions.put(">", "<=");
		conditions.put("<", ">=");
		conditions.put("<=", ">");
		conditions.put(">=", "<");
		conditions.put("==", "!=");
		conditions.put("!=", "==");
		conditions.put("=", "!=");
		return conditions;
	}

}
