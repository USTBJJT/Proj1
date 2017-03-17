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
//		System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
        try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        String tempString = null;  
        int line = 1;  
        // һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
        try {
        	FileWriter writer = new FileWriter(name + "_temp.wsdl");
        	BufferedWriter bw = new BufferedWriter(writer);
			while ((tempString = reader.readLine()) != null) {  
			    // ��ʾ�к� 
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
