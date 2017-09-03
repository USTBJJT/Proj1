package cn.edu.ustb.cbwstc.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aStr = "";
		File f = new File("CBWSTC_WorkSpace/Projects/ParkingFeeCalculator/DT/feeCalculateResponse_succ/rule10.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			String str = null;
			
			try {
				while((str = br.readLine()) != null) {
					aStr = aStr + str + "\r\n";
//					System.out.println(str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(aStr);
	}

}
