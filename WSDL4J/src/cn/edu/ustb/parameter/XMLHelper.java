package cn.edu.ustb.parameter;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class XMLHelper {
	
	/**
	 * 
	 * @param filePath ����ľ���schema��ʽ��xsd�ļ�
	 * @return document ��������ʹ��
	 */
	public static Document openXSDFile(String filePath) {
		Document document = null;
		SAXReader reader = new SAXReader();
		try {
			File file = new File(filePath);
			document = reader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}
	
}
