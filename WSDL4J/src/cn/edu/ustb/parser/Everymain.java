package cn.edu.ustb.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import cn.edu.ustb.xsdparam.InvokeCmd;

public class Everymain {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//  	String fileName = "E://AddService1.wsdl";
//		RestrictionDeal resdeal = new RestrictionDeal();
//  	resdeal.normalWsdl(fileName);
//		ReadDef.DefInterface("E://ExFile//ATM.wsdl");
//		SchemaParser.XSDparser();
//		UMLtoPng up = new UMLtoPng();
//		up.pngGen();
//		Constraintsolving cs = new Constraintsolving();
//		cs.shunxu();
		
		FindIP fi = new FindIP();
		fi.findmyIP();
		
//		SoapSend sd = new SoapSend();
//		try {
//			sd.sendmessage(1,1,true,35,300);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//µ÷ÓÃcmd
//		InvokeCmd ic = new InvokeCmd();
//		ic.xjcCmd();
		
	}

}
