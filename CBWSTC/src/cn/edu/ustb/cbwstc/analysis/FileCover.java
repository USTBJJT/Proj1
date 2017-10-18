package cn.edu.ustb.cbwstc.analysis;

import java.io.File;

public class FileCover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File[] filePathN = null;
		File f = new File("CBWSTC_WorkSpace/Projects/ParkingFeeCalculator/DT");
		filePathN = f.listFiles();
		for(int i=0; i<filePathN.length; i++) {
			if(filePathN[i].isDirectory()) {
				File[] child = filePathN[i].listFiles();
				for(int j=0; j<child.length; j++) {
					System.out.println(child[j]);
				}
			}
		}

	}

}
