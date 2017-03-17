package cn.edu.ustb.xsdparam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InvokeCmd {
	
	public void xjcCmd() {
		Runtime r = Runtime.getRuntime();
		Process p = null;
		try {
			
			String[] cmd = {"cmd","/c", "xjc -d E:\\xjc -p org.test.atm2 E:\\ExFile\\ATM.xsd"};// 
			p = r.exec(cmd);
		
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));  
            String line = null;  
  
            while ((line = input.readLine()) != null) {  
                System.out.println(line);  
            }  
 
            int exitVal = p.waitFor();
            System.out.println("Exited with error code " + exitVal);
			
		}catch(Exception e){
			System.out.println(e.toString());  
            e.printStackTrace();
		}
	}
}
