package cn.edu.ustb.cbwstc.util;

import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

public class XSD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File xsdFile = new File("E:/ExFile/Add.xsd");
		try {
			XmlObject object = XmlObject.Factory.parse(xsdFile);
			System.out.println(object.xmlText());
			XmlCursor cursor = object.newCursor();
			
		} catch (XmlException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
