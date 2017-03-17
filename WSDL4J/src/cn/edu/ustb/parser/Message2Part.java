package cn.edu.ustb.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Part;

public class Message2Part {
	
	
	public static void M2PInterface(Map map) {
		
		getMessagePartElementName(map);
		
	}
	
	
	/**
	 * This interface represents a WSDL message (input/output/fault) about a operation.
	 * ��Ϣ��
	 * @param ĳ���ض�������Ӧ��(input/output/fault)�ض���Ϣ������part��ǩ
	 * @return part��Ӧ��Element��Name�б�
	 * the element of the Message (input/output/fault) associated with usage of the operation.
	 * @author JiaJingting
	 *
	 */
	private static void getMessagePartElementName(Map map) {
		
		
		Iterator partIter = map.values().iterator();
		while(partIter.hasNext())
	    {
			Part part= (Part) partIter.next();
			
			System.out.println("				#<MS> part name: " + part.getName());
			System.out.println("				#<MS> part element: " + part.getElementName().getLocalPart());
			System.out.println("				#<MS> part typename: " + part.getTypeName());
//			Def2Types dt = new Def2Types();
//			dt.getType(part.getTypeName());
			
	    }
		
	}

}
