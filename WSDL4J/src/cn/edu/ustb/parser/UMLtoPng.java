package cn.edu.ustb.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.sourceforge.plantuml.SourceStringReader;

public class UMLtoPng {
	
	public void pngGen() {
		File file=new File("E://Sta.png");//可以是任何图片格式.jpg,.png等
        FileOutputStream png = null;
		try {
			png = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		OutputStream png = new OutputStream("");
		String source = "@startuml\n";
		source += "Bob -> Alice : zhangzaixing()\n";
		source += "@enduml\n";

		SourceStringReader reader = new SourceStringReader(source);
		// Write the first image to "png"
		try {
			String desc = reader.generateImage(png);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Return a null string if no generation
	}

}
