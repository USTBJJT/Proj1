package cn.edu.ustb.cbwstc.wsdl.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class ParseSequence {
	private Map<String,String> mapC = new HashMap<String,String>();
	private Map<String,String> mapIO = new HashMap<String,String>();
	public void sequenceParse(String name) {
		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/Parser/result.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			String str = null;
			int count = 0;
			try {
				while((str = br.readLine()) != null) {
					if(count != 0) {
						String Opr = str.split("#")[0];
						String OprI = str.split("#")[1];
						String OprO = str.split("#")[2];
						mapIO.put(Opr,OprI + "#" + OprO);
						String Constraint = str.split("#")[3];
						if(!Constraint.equals("NullDocumentation")) {
							mapC.put(Opr,preConstraint(Constraint));
						}
						
					}
					count++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String preConstraint(String Constraint) {
		JSONObject obj = JSONObject.fromObject(Constraint);
		String preOp = obj.getString("preOp");
		String preCT = obj.getString("preCT");
		if(!preOp.equals("")) {
			return preOp;
		}else{
			return "null";
		}
		
	}
	
	public Map<String, String> getmapIO() {
		return mapIO;
	}
	
	public Map<String, String> getmapC() {
		return mapC;
	}

}
