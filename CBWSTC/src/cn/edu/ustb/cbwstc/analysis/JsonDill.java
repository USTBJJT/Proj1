package cn.edu.ustb.cbwstc.analysis;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonDill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = "{\"Attribute\":[],\"haha\":\"hehe\"}";
		JSONObject obj = JSONObject.fromObject(json);
		JSONArray a = obj.getJSONArray("Attribute");
		System.out.println(a.size());
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		System.out.println(obj.getString("haha"));

	}

}
