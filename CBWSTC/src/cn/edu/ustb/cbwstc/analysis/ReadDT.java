package cn.edu.ustb.cbwstc.analysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadDT rdt = new ReadDT();
		String [] fileName = rdt.findExcel("E:/CBWSTC/Excel/");
		for(int i=0;i<fileName.length;i++) {
			rdt.readDTFromExcel(fileName[i]);
		}
	}
	
	/**
	 *获取一个excel表格 
	 */
	public String[] findExcel(String path) {
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
        String [] fileName = file.list();
        return fileName;
	}
	
	/**
	 * 从选定的表格中获取决策表规则文件
	 * @param name
	 */
	public void readDTFromExcel(String name) {
		try {
			File f = new File("E:/CBWSTC/Excel/" + name);
			FileInputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet catSheet = wb.getSheetAt(0); //the first sheet
			XSSFRow fRow = catSheet.getRow(0); // THE first row
			int cNum = Integer.parseInt(fRow.getCell(0).toString().split("\\.")[0]);
			int aNum = Integer.parseInt(fRow.getCell(1).toString().split("\\.")[0]);
			int rNum = Integer.parseInt(fRow.getCell(2).toString().split("\\.")[0]);
			writeDTFromExcel(cNum,aNum,rNum,catSheet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param cNum 条件项
	 * @param aNum 动作项
	 * @param rNum 规则项
	 * @param sheet 表格
	 */
	public void writeDTFromExcel(int cNum,int aNum,int rNum, XSSFSheet sheet) {
		int arl = cNum + 2;
		int aru = cNum + 1 + aNum;
		int rcu = rNum + 1;
		int cru = cNum + 1;
		for(int a=arl; a<=aru; a++) { //获取一个动作
			if(sheet.getRow(a).getCell(1).toString() != null && sheet.getRow(a).getCell(1).toString().length() != 0) {
				String catalog = sheet.getRow(a).getCell(1).toString();
				makeCatalog(catalog);
				for(int r=2; r<=rcu; r++) { //针对每条规则
					if(sheet.getRow(a).getCell(r).toString() != null && sheet.getRow(a).getCell(r).toString().length() != 0) {
						if(sheet.getRow(a).getCell(r).toString().equals("Y")) { //看该规则对应哪条动作
							String strRule = "";
							String file = "E:/CBWSTC/DT/" + catalog + "/rule" + sheet.getRow(1).getCell(r).toString().split("\\.")[0] + ".txt";
							for(int c=2; c<=cru; c++) { //查找该规则对应的约束
								if(sheet.getRow(c).getCell(r).toString() != null || sheet.getRow(c).getCell(r).toString().length() != 0) {
									if(sheet.getRow(c).getCell(r).toString().equals("Y")) {
										strRule = strRule + sheet.getRow(c).getCell(1).toString().replaceAll("[\\t\\n\\r]", " ") + "\r\n";
									}
								}
							}
							writeRuleFile(file,strRule);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 针对一个动作创建一个目录，用来存储规则约束文件
	 * @param catalog
	 */
	public void makeCatalog(String catalog) {
		File dir = new File("E:/CBWSTC/DT/" + catalog);
		if(dir.exists()) {
			
		}else {
			dir.mkdirs();
		}
	}
	
	public void writeRuleFile(String file,String strRule) {
		File fw = new File(file);
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(fw));
			bw.write(strRule);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
