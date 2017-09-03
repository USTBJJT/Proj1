package cn.edu.ustb.cbwstc.analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InvokeZ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvokeZ3 z3 = new InvokeZ3();
		String cmd = "z3 E:\\CBWSTC\\z3.txt";
		System.out.println(z3.getResult(cmd));
	}
	
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
