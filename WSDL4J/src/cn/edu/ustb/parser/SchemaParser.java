package cn.edu.ustb.parser;

import java.io.File;
import java.io.IOException;



import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

public class SchemaParser {
	
	public static void XSDparser() {
		File f =new File("E://AS.xsd");
		XmlObject xobj = null;
		try {
			xobj = XmlObject.Factory.parse(f);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		XmlCursor xobjcursor=xobj.newCursor();
//		while(xobjcursor.hasNextToken()) {
//			xobjcursor.toNextToken();
//		    if(xobjcursor.isText()) {
//		      System.out.println(xobjcursor.currentTokenType() 
//		        + " " + xobjcursor.getChars());
//		    } else {
//		      System.out.println(xobjcursor.currentTokenType() 
//		      + " " + xobjcursor.getName());
//		    }
//		}
		System.out.println(xobj.schemaType().getBaseType());
	}
	

}
