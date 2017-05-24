package cn.edu.ustb.cbwstc.config;

import java.io.File;

public class CreatMkdir {
	
	public static void creatMkdir(String destDirName) {
		
		File dir = new File(destDirName);
		if(dir.exists()) {
			
		}else {
			dir.mkdirs();
		}
		
		
	}

}
