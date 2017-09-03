package cn.edu.ustb.cbwstc.util;

import java.io.IOException;

public class InvokeCmd {
	
	public void execCmd(String cmd) {
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
