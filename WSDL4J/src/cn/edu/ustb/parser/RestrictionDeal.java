package cn.edu.ustb.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RestrictionDeal {
	
	public void normalWsdl(String fileName) {
		File file = new File(fileName);
		String name = fileName .substring(0,fileName.lastIndexOf("."));
		
		BufferedReader reader = null;
//		System.out.println("以行为单位读取文件内容，一次读一整行：");  
        try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        String tempString = null;  
        int line = 1;  
        // 一次读入一行，直到读入null为文件结束  
        try {
        	FileWriter writer = new FileWriter(name + "_temp.wsdl");
        	BufferedWriter bw = new BufferedWriter(writer);
			while ((tempString = reader.readLine()) != null) {  
			    // 显示行号 
				if(tempString.trim().startsWith("<wsdl:restriction") && tempString.trim().endsWith("/>")) {
					System.out.println("===========");
				}else {
					bw.write(tempString);
					bw.newLine();
				}
			    System.out.println("line " + line + ": " + tempString);  
			    line++;  
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
	public void SaveWSDL() {
		
	}
	public void Saveconstraint() {
		
	}

}
