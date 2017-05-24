package cn.edu.ustb.cbwstc.config;

import java.io.File;

public class ConfigWsdlResture {
	
	public void wsdlFile() {
		String sep = File.separator;
		String directory = "CBWSTC_WorkSpace" + sep + "Sources" + sep;
		CreatMkdir.creatMkdir(directory);
	}
}
