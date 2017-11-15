package cn.edu.ustb.cbwstc.tcg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;

import cn.edu.ustb.cbwstc.model.Condition;
import cn.edu.ustb.cbwstc.model.Graph;
import cn.edu.ustb.cbwstc.model.Node;

//��Լ��������ɵĲ������ݰ��ն���õĸ�ʽת��Ϊ��������
public class DataToCase {
	
	private String name = "";
	private Graph g = new Graph();
	private Map<String,Integer> mapOpCount = new HashMap<String,Integer>();
	
	public DataToCase(String name,Graph g) {
		this.name = name;
		this.g = g;
	}
	
	public void valueCount() { //д���������ű�ǰ,�������в�����ִ�д���Ϊ0��֮��ͳ��ִ�д��������нű���ǩ��������
		LinkedHashSet<Node> nodes = g.getNodes();
		for(Node node: nodes) {
			if(node.getType() == "input") {
				mapOpCount.put(node.getName(), 0);
			}
		}
	}
	
	public void generTestCase(String ts, int tsId) {
//		System.out.println("������");

		ArrayList<String> dfilePathN = getTestData(tsId);//��ȡ�������ڸò������еĲ��������ļ�
		//���ÿһ���������У�����������������֮��Ӧ��ÿ���������ݾ�����һ�����Խű�
		for(int j=0; j<dfilePathN.size(); j++) {
//		    System.out.println("��ʼ����");
			valueCount();//������ʼ��
//			System.out.println(dfilePathN.get(j));
			String path = "CBWSTC_WorkSpace/Projects/" + name + "/TestData/" + dfilePathN.get(j);
			HashMap<String,String> paramValue = new HashMap<String,String>();
			paramValue = getValue(path);
			//��д���Խű�
			String scripts = "<Sequence>\r\n";
			String[] tsequence = ts.split("#");
			for(int i=4; i<tsequence.length; i=i+2) {
				if(g.getNode(tsequence[i]).getType() == "input") {
					String soapStr = readSoap("CBWSTC_WorkSpace/Projects/" + name  + "/XML/" + tsequence[i] + ".xml");
					int id = mapOpCount.get(tsequence[i]) + 1;
					mapOpCount.put(tsequence[i], id);
					scripts = scripts + "<Operation name=\"" + tsequence[i] + "\" id=\"" + id + "\">\r\n";
					ArrayList<Condition> ac = g.getNode(tsequence[i]).getCondition();
					for(int k=0; k<ac.size(); k++) {
						String para = ac.get(k).getContent().split("#")[0].split("_")[2];
						String strM = para + ">?</";
						if(soapStr.contains(strM)) {
							String value = paramValue.get(tsequence[i] + "_" + id + "_" + para);
							String replacement = para + ">" + value + "</";
							soapStr = soapStr.replace(strM, replacement);
						}
					}
					scripts = scripts + soapStr + "</Operation>\r\n";
				}
			}
			scripts = scripts + "</Sequence>";
//			System.out.println(scripts);
			String tcpath = "CBWSTC_WorkSpace/Projects/" + name + "/TC/tc#" + dfilePathN.get(j).substring(3);
			writeFile(tcpath,scripts);
		}
		
		
	}
	
	public void generPreOpTestCase(String ts, int tsId) {
		
		valueCount();//������ʼ��
		//��д���Խű�
		String scripts = "<Sequence>\r\n";
		String[] tsequence = ts.split("#");
		for(int i=4; i<tsequence.length; i=i+2) {
			if(g.getNode(tsequence[i]).getType() == "input") {
				String soapStr = readSoap("CBWSTC_WorkSpace/Projects/" + name  + "/XML/" + tsequence[i] + ".xml");
				int id = mapOpCount.get(tsequence[i]) + 1;
				mapOpCount.put(tsequence[i], id);
				scripts = scripts + "<Operation name=\"" + tsequence[i] + "\" id=\"" + id + "\">\r\n";
				ArrayList<Condition> ac = g.getNode(tsequence[i]).getCondition();
				for(int k=0; k<ac.size(); k++) {
					String para = ac.get(k).getContent().split("#")[0].split("_")[2];
					String type = ac.get(k).getContent().split("#")[1];
					String value = "";
					Random random = new Random();
					MathTcg mt = new MathTcg(random);
					if(! ac.get(k).getPattern().equals("")) {
						XegerTCG xtcg = new XegerTCG();
						value = xtcg.gerTcg(ac.get(k).getPattern());
					}else {
						if(type.equals("String")) {
							value = "String";
						}else if(type.equals("boolean")) {
							value = mt.boolTCG() + "";
						}else if(type.equals("int")) {
							if(ac.get(k).isNumLimite()) {
								int r = mt.intIITCG(Integer.parseInt(ac.get(k).getLowLimite()), Integer.parseInt(ac.get(k).getHighLimite()));
								value = String.valueOf(r);
							}else {
								value = "3";
							}
						}else if(type.equals("float")) {
							if(ac.get(k).isNumLimite()) {
								float r = mt.floatTCG(Float.parseFloat(ac.get(k).getLowLimite()),Float.parseFloat(ac.get(k).getHighLimite()));
								value = String.valueOf(r);
							}else {
								value = "3.0";
							}
						}else if(type.equals("double")) {
							if(ac.get(k).isNumLimite()) {
								double r = mt.doubleTCG(Double.parseDouble(ac.get(k).getLowLimite()),Double.parseDouble(ac.get(k).getHighLimite()));
								value = String.valueOf(r);
							}else {
								value = "3.0";
							}
						}else {
							//TODO δ����������������
						}
					}
					String strM = para + ">?</";
					if(soapStr.contains(strM)) {
						String replacement = para + ">" + value + "</";
						soapStr = soapStr.replace(strM, replacement);
					}
				}
				scripts = scripts + soapStr + "</Operation>\r\n";
			}
		}
		scripts = scripts + "</Sequence>";
		String tcpath = "CBWSTC_WorkSpace/Projects/" + name + "/TC/tc#" + tsId + "#0.txt";
		writeFile(tcpath,scripts);
	}
	
	public void generIterationTestCase(String newTs, String oldTs,int tsId) {
		ArrayList<String> dfilePathN = getTestData(tsId);
		for(int j=0; j<dfilePathN.size(); j++) {
			valueCount();//������ʼ��
			String pathS = "CBWSTC_WorkSpace/Projects/" + name + "/TestData/" + dfilePathN.get(j);
//			File path = new File(pathS);
//			String destS = "CBWSTC_WorkSpace/Projects/" + name + "/TestData/td#" + tsId + "#" + dfilePathN.get(j).split("#")[2];
//			File dest = new File(destS);
//			try {
//				FileUtils.copyFile(path, dest);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			HashMap<String,String> paramValue = new HashMap<String,String>();
			paramValue = getValue(pathS);
			//��д���Խű�
			//#efǰ�������ĵ��õĲ�������������
			String scripts = "<Sequence>\r\n";
			String[] tsequence = oldTs.split("#");
			for(int i=4; i<tsequence.length; i=i+2) {
				if(g.getNode(tsequence[i]).getType() == "input") {
					String soapStr = readSoap("CBWSTC_WorkSpace/Projects/" + name  + "/XML/" + tsequence[i] + ".xml");
					int id = mapOpCount.get(tsequence[i]) + 1;
					mapOpCount.put(tsequence[i], id);
					scripts = scripts + "<Operation name=\"" + tsequence[i] + "\" id=\"" + id + "\">\r\n";
					ArrayList<Condition> ac = g.getNode(tsequence[i]).getCondition();
					for(int k=0; k<ac.size(); k++) {
						String para = ac.get(k).getContent().split("#")[0].split("_")[2];
						String strM = para + ">?</";
						if(soapStr.contains(strM)) {
							String value = paramValue.get(tsequence[i] + "_" + id + "_" + para);
							String replacement = para + ">" + value + "</";
							soapStr = soapStr.replace(strM, replacement);
						}
					}
					scripts = scripts + soapStr + "</Operation>\r\n";
				}
			}
			//#ef����Υ�����õĲ�������������
			String[] tsequenceN = newTs.split("#");
			for(int i=0;i<tsequenceN.length;i++) {
				int finalId = 0;
				if(g.getNode(tsequenceN[i]).getType() == "input") {
					String soapStr = readSoap("CBWSTC_WorkSpace/Projects/" + name  + "/XML/" + tsequenceN[i] + ".xml");
					finalId = mapOpCount.get(tsequenceN[i]);
					scripts = scripts + "<Operation name=\"" + tsequenceN[i] + "\">\r\n";
					ArrayList<Condition> ac = g.getNode(tsequenceN[i]).getCondition();
					for(int k=0; k<ac.size(); k++) {
						String para = ac.get(k).getContent().split("#")[0].split("_")[2];
						String strM = para + ">?</";
						if(soapStr.contains(strM)) {
							String value = paramValue.get(tsequenceN[i] + "_" + finalId + "_" + para);
							String replacement = para + ">" + value + "</";
							soapStr = soapStr.replace(strM, replacement);
						}
					}
					scripts = scripts + soapStr + "</Operation>\r\n";
				}
			}
			scripts = scripts + "</Sequence>";
//			System.out.println(scripts);
			String tcpath = "CBWSTC_WorkSpace/Projects/" + name + "/TC/tc#" + tsId + "#" + dfilePathN.get(j).split("#")[2];
			writeFile(tcpath,scripts);
		}
	}
	
	public void writeFile(String path,String content) {
		FileOutputStream out;
		try {
			out = new FileOutputStream(path);
			BufferedWriter outfile = new BufferedWriter(new OutputStreamWriter(out));
			try {
				outfile.write(content);
				outfile.flush();
				outfile.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ��������ļ��л�ȡȫ��������ֵ�����洢��map��
	 * @param path Լ���������ļ���·��
	 */
	public HashMap<String,String> getValue(String path) {
		HashMap<String,String> paramValue = new HashMap<String,String>();
		File f = new File(path);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			String str = null;
			try {
				boolean flag = false;
				while((str = br.readLine()) != null) {
					if(str.equals("sat")) {
						flag = true;
					}
					if(! str.equals("sat") && flag) {
						//��Ҫ���д���Ľ���У� (())
						str = str.substring(2,str.length()-2);
						//�ָ�ʱʹ�õ�һ�γ��ֿո������ʽ���зָ�� ǰ��Ϊ���� ����Ϊ��ֵ
						int splitNum = str.indexOf(" ");
						String varParam = str.substring(0, splitNum).trim();
						String varValue = str.substring(splitNum + 1).trim();
						//������������ź��""�Լ�()�Լ��м��ȫ���ո�
						if(varValue.contains("\"")) {
							if(varValue.substring(1, varValue.length() -1)==null||varValue.substring(1, varValue.length() -1).equals("")) {
								varValue = " ";
							}else {
								varValue = varValue.substring(1, varValue.length() -1);
							}
						}
						if(varValue.contains("(")) {
							varValue = varValue.substring(1, varValue.length() -1).replace(" ", "");
						}
						paramValue.put(varParam, varValue);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paramValue;
	}
	/**
	 * ��Ը����Ĳ������У�����������Ҫ�����Ĳ��������ļ��б�
	 * @param tsId
	 */
	public ArrayList<String> getTestData(int tsId) {
		String[] filePathN = null;
		ArrayList<String> dfilePathN = new ArrayList<String>();
		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/TestData");
		filePathN = f.list();
//		System.out.println("���������");
		for(int i=0; i<filePathN.length; i++) {
//			System.out.println(filePathN[i]);
			if(filePathN[i].split("#")[1].equals(tsId + "")) {
//				System.out.println(filePathN[i]);
				dfilePathN.add(filePathN[i]);
			}
		}
		return dfilePathN;
	}
	
	public String readSoap(String path) {
		String soapStr = "";
		File f = new File(path);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			String str = null;
			try {
				while((str = br.readLine()) != null) {
					soapStr = soapStr + str + "\r\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soapStr;
	}
}
