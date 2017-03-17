package cn.edu.ustb.parser;

import javax.wsdl.Definition;
import javax.wsdl.Types;
import javax.xml.namespace.QName;

public class Def2Types {
	
	public void getType(QName q) {
		Definition mydef = ReadDef.readWsdl10("E://ATM.wsdl");
		Types typ = mydef.getTypes();
		System.out.println("type: " + typ.getExtensionAttribute(q));
	}

}
