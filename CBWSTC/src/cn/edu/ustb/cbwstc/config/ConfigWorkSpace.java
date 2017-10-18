package cn.edu.ustb.cbwstc.config;

import java.io.File;
import java.util.ArrayList;

public class ConfigWorkSpace {
	
	public static void configFile() {
		String sep = File.separator;
		String directory = "CBWSTC_WorkSpace" +sep;
		String directoryS = "CBWSTC_WorkSpace" + sep + "Sources" + sep;
		String directoryP = "CBWSTC_WorkSpace" + sep + "Projects" + sep;
		CreatMkdir.creatMkdir(directory);
		CreatMkdir.creatMkdir(directoryS);
		CreatMkdir.creatMkdir(directoryP);
	}
	
	public static void choseFileDirectory(String WsdlURI){
		String name = WsdlURI.substring(WsdlURI.lastIndexOf("/")+1, WsdlURI.length()-5);
		String directoryXSD = "CBWSTC_WorkSpace/Projects/" + name + "/XSD";
		String directoryXML = "CBWSTC_WorkSpace/Projects/" + name + "/XML";
		String directoryModel = "CBWSTC_WorkSpace/Projects/" + name + "/Parser";
		String directoryGraph = "CBWSTC_WorkSpace/Projects/" + name + "/Model";
		String directoryExcel = "CBWSTC_WorkSpace/Projects/" + name + "/Excel";
		String directoryDT = "CBWSTC_WorkSpace/Projects/" + name + "/DT";
		String directoryTD = "CBWSTC_WorkSpace/Projects/" + name + "/TestData";
		String directoryTC = "CBWSTC_WorkSpace/Projects/" + name + "/TC";
		String directoryResult = "CBWSTC_WorkSpace/Projects/" + name + "/Result";
		String directoryLog = "CBWSTC_WorkSpace/Projects/" + name + "/Log";
		CreatMkdir.creatMkdir(directoryXSD);
		CreatMkdir.creatMkdir(directoryXML);
		CreatMkdir.creatMkdir(directoryModel);
		CreatMkdir.creatMkdir(directoryGraph);
		CreatMkdir.creatMkdir(directoryExcel);
		CreatMkdir.creatMkdir(directoryDT);
		CreatMkdir.creatMkdir(directoryTD);
		CreatMkdir.creatMkdir(directoryTC);
		CreatMkdir.creatMkdir(directoryResult);
		CreatMkdir.creatMkdir(directoryLog);
	}
	
	public static void wipeCache(String WsdlURI) {
		String name = WsdlURI.substring(WsdlURI.lastIndexOf("/")+1, WsdlURI.length()-5);
		String directoryDT = "CBWSTC_WorkSpace/Projects/" + name + "/DT";
		String directoryTD = "CBWSTC_WorkSpace/Projects/" + name + "/TestData";
		String directoryTC = "CBWSTC_WorkSpace/Projects/" + name + "/TC";
		String directoryResult = "CBWSTC_WorkSpace/Projects/" + name + "/Result";
		String directoryLog = "CBWSTC_WorkSpace/Projects/" + name + "/Log";
		delectFile(directoryDT);
		delectFile(directoryTD);
		delectFile(directoryTC);
		delectFile(directoryResult);
		delectFile(directoryLog);
		delectFile(directoryTD);
		
	}
	
	public static void delectFile(String path)  {
		File[] filePathN = null;
		File f = new File(path);
		if(f.isDirectory()) {
			filePathN = f.listFiles();
			if(filePathN == null || filePathN.length == 0) {
				
			}else {
				for(int i=0; i<filePathN.length; i++) {
					File file = filePathN[i];
					if(file.isDirectory()) {
						File[] children = file.listFiles();
						if(children == null || children.length ==0) {
							
						}else {
							for (int j=0; j<children.length; j++) {
								delectFile(String.valueOf(children[j]));
							}
						}
					}else {
						file.delete();
					}
					
				}
			}
		}else {
			f.delete();
		}
	}

}
