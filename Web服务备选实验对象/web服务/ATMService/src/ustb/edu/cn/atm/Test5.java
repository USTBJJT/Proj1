package ustb.edu.cn.atm;

import java.io.File;
import java.io.IOException;

public class Test5 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		 File file = new File(System.getProperty("user.dir")+"\\src\\ustb\\edu\\cn\\atm");
		  File[] lf = file.listFiles();
		  for(int i=0; i<lf.length; i++){
		   System.out.println(lf[i].getName());
		  }
	}

}
