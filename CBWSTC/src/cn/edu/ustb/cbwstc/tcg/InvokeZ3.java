package cn.edu.ustb.cbwstc.tcg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InvokeZ3 {
	
	public String getResult(String cmd) {
		String result = "";
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;  
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\r\n");
            }
            result = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
