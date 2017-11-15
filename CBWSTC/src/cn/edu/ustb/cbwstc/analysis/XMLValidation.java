package cn.edu.ustb.cbwstc.analysis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File xsd = new File("CBWSTC_WorkSpace/Projects/ExpenseReimbursementSystem/XSD/ExpenseReimbursementSystem.xsd");
		File xml = new File("E:/airfareReimbursement.xml");
		System.out.println("calculateReimbursementAmount.xml validates against exp.xsd? "+validateXMLSchema(xsd, xml));

	}
	
	public static boolean validateXMLSchema(File xsdPath, File xmlPath){

        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdPath);
            Validator validator = schema.newValidator();
            InputStream ifile = new FileInputStream(xmlPath);
			InputStreamReader ir = new InputStreamReader(ifile, "UTF-8");
            validator.validate(new StreamSource(ir));
        } catch (IOException | SAXException |NullPointerException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }

}
