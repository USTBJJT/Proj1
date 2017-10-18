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

import cn.edu.ustb.cbwstc.model.Condition;
import cn.edu.ustb.cbwstc.model.Graph;
import cn.edu.ustb.cbwstc.model.Node;

public class TestDateG {
	
	private Graph g = new Graph();
	private String name = "";
	private Map<String,Integer> mapOpCount = new HashMap<String,Integer>();
	private ArrayList<String> conFileComb = new ArrayList<String>(); //Լ���ļ�����ַ���
	private boolean flag;
	
	
	public TestDateG(Graph g,String name,boolean flag) {
		this.g = g;
		this.name= name;
		this.flag = flag;
	}
	
	public void valueCount() { //дԼ�����ű�ǰ,�������в�����ִ�д���Ϊ0��֮��ͳ��ִ�д��������б��������滻
		LinkedHashSet<Node> nodes = g.getNodes();
		for(Node node: nodes) {
			if(node.getType() == "input") {
				mapOpCount.put(node.getName(), 0);
			}
		}
	}
	
	public void testSequenceProcess(String TestSequence,int Id) {
		valueCount();//�ڵ㸲�Ǵ�����ʼ��
		String init = "";//Լ������������
		String finalvalue = "(check-sat)\r\n";//��ӡ���ֵ
		String Response = "";//������������Ӧ���еĳ�ȡ
		String myAssert = "";//����Լ��
		String[] ts = TestSequence.split("#"); //��������е�ÿ����
		for(int i = 4; i<ts.length; i=i+2) { //ǰ�涼��׼��(start�ڵ㼰init�ڵ������ת�Ʊߣ�û��ʵ������) ��4ȡ��ÿ�μ�2���������бߣ�ֻ���ڵ㼴��
			if(g.getNode(ts[i]).getType() == "input") { //�ڵ�Ϊ����ڵ�
				//����map�ҵ��ò����ǵڼ���ִ�е�
				int count = mapOpCount.get(g.getNode(ts[i]).getName()) + 1;
				mapOpCount.put(g.getNode(ts[i]).getName(), count);
				String replacedStr = g.getNode(ts[i]).getName() + "_?";//�滻֮ǰ���ַ���
				String replaceStr = g.getNode(ts[i]).getName() + "_" + count;//�滻֮����ַ���
				
				//�����ڵ�Լ�������б�����ʼ��
				Node n = g.getNode(ts[i]);
				ArrayList<Condition> c = n.getCondition(); //�ýڵ��������������Ͳ���
				for(int j=0;j<c.size();j++) {//���ÿ���������
					Condition sc = c.get(j);
					String conStr = sc.getContent();//��ȡԼ������ (varName#varType)�������͵��ַ���
					if(conStr.split("#")[1].contains("boolean")) {//Bool���ͱ���
						String replaceOk = conStr.split("#")[0];
						if(conStr.split("#")[0].contains(replacedStr)) {
							replaceOk = conStr.split("#")[0].replace(replacedStr,replaceStr);
						}
						init = init + "(declare-const " + replaceOk +  " Bool)\r\n";
						finalvalue = finalvalue + "(get-value ("+  replaceOk + "))\r\n";
					}else if (conStr.split("#")[1].contains("String")) { //String����
						String replaceOk = conStr.split("#")[0];
						if(conStr.split("#")[0].contains(replacedStr)) {
							replaceOk = conStr.split("#")[0].replace(replacedStr,replaceStr);
						}
						init = init + "(declare-const " + replaceOk +  " String)\r\n";
						finalvalue = finalvalue + "(get-value ("+  replaceOk + "))\r\n";
					}else if(conStr.split("#")[1].contains("double") || conStr.split("#")[1].contains("float")) { //Real���ͱ���
						String replaceOk = conStr.split("#")[0];
						if(conStr.split("#")[0].contains(replacedStr)) {
							replaceOk = conStr.split("#")[0].replace(replacedStr,replaceStr);
						}
						init = init + "(declare-const " + replaceOk +  " Real)\r\n";
						finalvalue = finalvalue + "(get-value ("+  replaceOk + "))\r\n";
					}else if(conStr.split("#")[1].contains("int")){
						String replaceOk = conStr.split("#")[0];
						if(conStr.split("#")[0].contains(replacedStr)) {
							replaceOk = conStr.split("#")[0].replace(replacedStr,replaceStr);
						}
						init = init + "(declare-const " + replaceOk +  " Int)\r\n";
						finalvalue = finalvalue + "(get-value ("+  replaceOk + "))\r\n";
					}else {
						//����������ͱ��� Լ��������
					}
				}
			}else if(g.getNode(ts[i]).getType() == "output"){ //�����Ӧ����ת��Ϊ���߱�����
				Response = Response + g.getNode(ts[i]).getName() + "#"; //��ȡ������Ӧ�ڵ�˳������
			}
		}
		int arrayRow = Response.split("#").length;
		String[][] resA = new String[arrayRow][];//Լ���������  �����˼�����Ӧ�ڵ㣬��ά�����м���
		for(int i=0;i<arrayRow;i++) {
			String path = "CBWSTC_WorkSpace/Projects/" + name + "/DT/" + Response.split("#")[i];
			String[] filePathN = filePathN(path);
			resA[i] = new String[filePathN.length];
			for(int j=0;j<filePathN.length;j++) {
				resA[i][j] = path + "/" + filePathN[j];
			}
		}
//		System.out.println(init);
//		System.out.println("=======================");
//		System.out.println(finalvalue);
//		for(int i=0;i<resA.length;i++) {
//			for(int j=0;j<resA[i].length;j++) {
//				System.out.println(resA[i][j]);
//			}
//		}
		getFileComb(resA); //�������п��ܵĶ�ά������� 
		//����conFileComb ����Լ������ļ�
		for(int i=0;i<conFileComb.size();i++) {
			valueCount();//�ڵ㸲�Ǵ�����ʼ��
			myAssert = "";
			String[] ruleFileName = conFileComb.get(i).split("#");
			for(int j=0;j<ruleFileName.length;j++) {
				//���øýڵ�ִ�д���
				String opRes = ruleFileName[j].split("/")[4];
				int endIndex = opRes.lastIndexOf("Response");
				opRes = opRes.substring(0, endIndex);
				int count = mapOpCount.get(opRes) + 1;
				mapOpCount.put(opRes, count);
				
//				System.out.println(opRes);
				//��ȡ�ĵ�����
				File f = new File(ruleFileName[j]);
				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader(f));
					String str = null;
					try {
						while((str = br.readLine()) != null) {
							//����ÿ��Լ��assert,������&&�Ļ�Ϊ����
							if(str.contains("&&")) {
								String[] strAssert = str.split("&&");
								for(int k=0; k<strAssert.length;k++) {
									myAssert = myAssert + "(assert " + consReplac(strAssert[k].trim()) + ")\r\n";
								}
							}else {
								myAssert = myAssert + "(assert " + consReplac(str) + ")\r\n";
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
			}
			
			writeFile("CBWSTC_WorkSpace/Projects/" + name + "/Constraint.txt",init + myAssert + finalvalue);
//			System.out.println("==================================");
//			System.out.println(init + myAssert + finalvalue);
			InvokeZ3 z3 = new InvokeZ3();
			String cmd = "z3 CBWSTC_WorkSpace/Projects/" + name + "/Constraint.txt";
			String Result =z3.getResult(cmd);
			if(Result.contains("sat") && (! Result.contains("unsat"))) {
				String tcdPath = "CBWSTC_WorkSpace/Projects/" + name +"/TestData/td" + "#" + Id + "#" + i + ".txt";
				writeFile(tcdPath,Result);
				if(!flag) {
					break;
				}
			}
		}
	}
	
	public String[] filePathN(String path) {
		String[] filePathN = null;
		File f = new File(path);
		filePathN = f.list();
		return filePathN;
	}
	
	public void getFileComb(String[][] a) {//��ȡȫ�����ܵ�Լ���ļ���ϣ�Ϊ�������ɲ���������׼��
		conFileComb.clear();//���������ǰд�������(��Ϊ���µĲ���������)
		int count = 1;
		for(int i=0; i<a.length; i++) {
			count = count * a[i].length;
		}
		count = count-1;
//		System.out.println(count);
		while(count >=0) {
			int temp = count;
			String s = "";
			for(int i=0; i<a.length; i++) {
				if(temp/a[i].length >= 0) {
					s = s + a[i][temp % a[i].length] + "#";
					temp /= a[i].length;
				}
			}
			conFileComb.add(s);
			count--;
		}
	}
	
	public String consReplac(String str) {
		String reStr = str;
		for(String key : mapOpCount.keySet()) {
			if(reStr.contains(key)) {
				reStr = reStr.replace(key + "_?", key + "_" + mapOpCount.get(key));
			}
		}
		return reStr;
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
	
}
