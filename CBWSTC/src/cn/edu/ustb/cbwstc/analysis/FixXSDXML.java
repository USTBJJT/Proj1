package cn.edu.ustb.cbwstc.analysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.edu.ustb.cbwstc.wsdl.parser.XMLHelper;

public class FixXSDXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLine("E://ExpenseReimbursementSystem.wsdl"));
		readXsd("E://ExpenseReimbursementSystem.wsdl");
	}
	
	public static void readXsd(String f) {
		Document document = XMLHelper.openXMLFile(f);
		Element definitions = document.getRootElement();
		System.out.println(definitions.getNamespaceForPrefix("wsdl").getStringValue());
		Element types = definitions.element("types");
		Element schema = types.element("schema");
		File fw = new File("E://ExpenseReimbursementSystem.xsd");
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fw), "UTF-8"));
			bw.write(schema.asXML());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getLine(String f) {
		String line = "";
		File inf = new File(f);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(inf));
			String str = null;
			try {
				if(f.contains(".wsdl")) {
					while((str = br.readLine()) != null) {
						if(str.contains("wsdl:definitions")) {
							
							line = str.substring(18);
							break;
						}
					}
				}else {
					while((str = br.readLine()) != null) {
						if(str.contains("schema")) {
							
							line = str;
							break;
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}

}
