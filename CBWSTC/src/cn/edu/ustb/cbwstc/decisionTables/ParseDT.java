package cn.edu.ustb.cbwstc.decisionTables;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParseDT {
	
	private String proName;
	
	public ParseDT(String name){  
	      this.proName = name;
	}
	
	/**
	 *��project name excel ·���»�ȡ����excel��� 
	 */
	public void findExcel(String path) {
		File file = new File(path);
        String [] fileName = file.list();
        for(int i=0;i<fileName.length; i++) {
        	readDTFromExcel(fileName[i]);
        }
	}
	
	/**
	 * ��ѡ���ı���л�ȡ���߱�����ļ�
	 * @param name
	 */
	public void readDTFromExcel(String name) {
		try {
			File f = new File("CBWSTC_WorkSpace/Projects/" + proName + "/Excel/" + name);
			FileInputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet catSheet = wb.getSheetAt(0); //the first sheet
			XSSFRow fRow = catSheet.getRow(0); // THE first row
			int cNum = Integer.parseInt(fRow.getCell(0).toString().split("\\.")[0]);
			int aNum = Integer.parseInt(fRow.getCell(1).toString().split("\\.")[0]);
			int rNum = Integer.parseInt(fRow.getCell(2).toString().split("\\.")[0]);
			System.out.println(cNum + "," +aNum + "," + rNum);
			writeDTFromExcel(cNum,aNum,rNum,catSheet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param cNum ������
	 * @param aNum ������
	 * @param rNum ������
	 * @param sheet ���
	 */
	public void writeDTFromExcel(int cNum,int aNum,int rNum, XSSFSheet sheet) {
		int arl = cNum + 2;
		int aru = cNum + 1 + aNum;
		int rcu = rNum + 1;
		int cru = cNum + 1;
		for(int a=arl; a<=aru; a++) { //��ȡһ������
			if(sheet.getRow(a).getCell(1).toString() != null && sheet.getRow(a).getCell(1).toString().length() != 0) {
				String catalog = sheet.getRow(a).getCell(1).toString();
				makeCatalog(catalog);
				for(int r=2; r<=rcu; r++) { //���ÿ������
					if(sheet.getRow(a).getCell(r).toString() != null && sheet.getRow(a).getCell(r).toString().length() != 0) {
						if(sheet.getRow(a).getCell(r).toString().equals("Y")) { //���ù����Ӧ��������
							String strRule = "";
							String file = "CBWSTC_WorkSpace/Projects/" + proName + "/DT/" + catalog + "/rule" + sheet.getRow(1).getCell(r).toString().split("\\.")[0] + ".txt";
							for(int c=2; c<=cru; c++) { //���Ҹù����Ӧ��Լ��
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
	 * ���һ����������һ��Ŀ¼�������洢����Լ���ļ�
	 * @param catalog
	 */
	public void makeCatalog(String catalog) {
		File dir = new File("CBWSTC_WorkSpace/Projects/" + proName + "/DT/" + catalog);
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
