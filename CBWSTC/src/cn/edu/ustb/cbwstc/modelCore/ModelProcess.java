package cn.edu.ustb.cbwstc.modelCore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ModelProcess {
	
	public void sequenceGeneration(String name) {
		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/Model/model.txt");
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

}
