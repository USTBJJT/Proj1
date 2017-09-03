package cn.edu.ustb.cbwstc.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * excelÎÄ¼þ¶ÁÈ¡util
 * @author JJT
 *
 */
public class SourceDataReader {
	
	public static void main(String[] args) {
		SourceDataReader s = new SourceDataReader();
		s.loadxlsx();
	}
	
	public void loadxlsx() {
		
		try {
			File f = new File("E:/ExFile/poiTry.xlsx");
			FileInputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet catSheet = wb.getSheetAt(0); //the first sheet
			ArrayList<String> allCatLines = read(catSheet);
			for(int i = 0; i < allCatLines.size(); i++) {
				String currLineStr = allCatLines.get(i);
				System.out.println(currLineStr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//reading stops at the first blank line
    private ArrayList<String> read(XSSFSheet sheet) throws Exception {

        ArrayList<String> allLines = new ArrayList<>();
        try {
            int rowID = 0; //start to read in rows
            XSSFRow currRow = sheet.getRow(rowID);
            while (currRow != null) {
                int cellID = 0;
                XSSFCell currRowCell = currRow.getCell(cellID); //Read in all cells in this row. Note the type of this cell is String
                String currRowStr = currRowCell.toString();
//                if(currRowStr.equals("[END]")){
//                    break;
//                }
                currRowCell = currRow.getCell(++cellID);
                while (currRowCell != null) {
                    currRowStr = currRowStr + "," + currRowCell.toString();
                    currRowCell = currRow.getCell(++cellID);
                }
                allLines.add(currRowStr);
                currRow = sheet.getRow(++rowID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allLines;
    }
	
	
	

}
