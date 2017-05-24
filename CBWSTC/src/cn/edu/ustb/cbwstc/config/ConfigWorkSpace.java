package cn.edu.ustb.cbwstc.config;

import java.io.File;

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
		String directoryModel = "CBWSTC_WorkSpace/Projects/" + name + "/Model";
		String directoryGraph = "CBWSTC_WorkSpace/Projects/" + name + "/Graph";
		String directoryTC = "CBWSTC_WorkSpace/Projects/" + name + "/TC";
		String directoryResult = "CBWSTC_WorkSpace/Projects/" + name + "/Result";
		String directoryLog = "CBWSTC_WorkSpace/Projects/" + name + "/Log";
		CreatMkdir.creatMkdir(directoryXSD);
		CreatMkdir.creatMkdir(directoryXML);
		CreatMkdir.creatMkdir(directoryModel);
		CreatMkdir.creatMkdir(directoryGraph);
		CreatMkdir.creatMkdir(directoryTC);
		CreatMkdir.creatMkdir(directoryResult);
		CreatMkdir.creatMkdir(directoryLog);
	}

}
