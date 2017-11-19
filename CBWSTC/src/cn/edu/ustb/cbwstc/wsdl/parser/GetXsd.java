package cn.edu.ustb.cbwstc.wsdl.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

public class GetXsd {
	
	private static String head = "<schema xmlns=\"http://www.w3.org/2001/XMLSchema\" elementFormDefault=\"qualified\" ";
	
	public static void getXsd(String WsdlURI,String name) {
		XMLHelper.getWsdlDoc(WsdlURI,name);
		File f = new File("CBWSTC_WorkSpace/Sources/" + name + ".wsdl");
		if(f.exists()) {
			String str = getLine(f);
			head = head + str;
			readXsd("CBWSTC_WorkSpace/Sources/" + name + ".wsdl",name);
			
		}
	}
	
	public static void readXsd(String f,String name) {
		Document document = XMLHelper.openXMLFile(f);
		Element definitions = document.getRootElement();
		Element types = definitions.element("types");
		Element schema = types.element("schema");
		File fw = new File("CBWSTC_WorkSpace/Projects/" + name + "/XSD/" + name + "_temp.xsd");
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fw), "UTF-8"));
			bw.write(schema.asXML());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Ð´Èë×îÖÕXSD
		String con = "";
		File tf = new File("CBWSTC_WorkSpace/Projects/" + name + "/XSD/" + name + "_temp.xsd");
		BufferedReader br;
		File ffw = new File("CBWSTC_WorkSpace/Projects/" + name + "/XSD/" + name + ".xsd");
		BufferedWriter fbw;
		try {
			br = new BufferedReader(new FileReader(tf));
			String str = null;
			int count = 0;
			while((str = br.readLine()) != null) {
				if(count != 0) {
					con = con + str + "\r\n";
				}else {
					con = con + head + "\r\n";
				}
				count++;
			}
			fbw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ffw), "UTF-8"));
			fbw.write(con);
			fbw.flush();
			fbw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getLine(File inf) {
		String line = "";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(inf));
			String str = null;
			try {
				while((str = br.readLine()) != null) {
					if(str.contains("wsdl:definitions")) {
						line = str.substring(18);
						break;
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
