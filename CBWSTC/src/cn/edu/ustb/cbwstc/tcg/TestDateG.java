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
	private ArrayList<String> conFileComb = new ArrayList<String>(); //约束文件组合字符串
	private boolean flag;
	
	
	public TestDateG(Graph g,String name,boolean flag) {
		this.g = g;
		this.name= name;
		this.flag = flag;
	}
	
	public void valueCount() { //写约束求解脚本前,假设所有操作的执行次数为0，之后统计执行次数，进行变量计数替换
		LinkedHashSet<Node> nodes = g.getNodes();
		for(Node node: nodes) {
			if(node.getType() == "input") {
				mapOpCount.put(node.getName(), 0);
			}
		}
	}
	
	public void testSequenceProcess(String TestSequence,int Id) {
		valueCount();//节点覆盖次数初始化
		String init = "";//约束求解变量设置
		String finalvalue = "(check-sat)\r\n";//打印求解值
		String Response = "";//测试序列中响应序列的抽取
		String myAssert = "";//定义约束
		String[] ts = TestSequence.split("#"); //针对序列中的每个点
		for(int i = 4; i<ts.length; i=i+2) { //前面都是准备(start节点及init节点和两个转移边，没有实际作用) 从4取，每次加2，跳过所有边，只看节点即可
			if(g.getNode(ts[i]).getType() == "input") { //节点为请求节点
				//遍历map找到该操作是第几次执行的
				int count = mapOpCount.get(g.getNode(ts[i]).getName()) + 1;
				mapOpCount.put(g.getNode(ts[i]).getName(), count);
				String replacedStr = g.getNode(ts[i]).getName() + "_?";//替换之前的字符串
				String replaceStr = g.getNode(ts[i]).getName() + "_" + count;//替换之后的字符串
				
				//遍历节点约束，进行变量初始化
				Node n = g.getNode(ts[i]);
				ArrayList<Condition> c = n.getCondition(); //该节点的输入参数及类型参数
				for(int j=0;j<c.size();j++) {//针对每个输入参数
					Condition sc = c.get(j);
					String conStr = sc.getContent();//获取约束内容 (varName#varType)这样类型的字符串
					if(conStr.split("#")[1].contains("boolean")) {//Bool类型变量
						String replaceOk = conStr.split("#")[0];
						if(conStr.split("#")[0].contains(replacedStr)) {
							replaceOk = conStr.split("#")[0].replace(replacedStr,replaceStr);
						}
						init = init + "(declare-const " + replaceOk +  " Bool)\r\n";
						finalvalue = finalvalue + "(get-value ("+  replaceOk + "))\r\n";
					}else if (conStr.split("#")[1].contains("String")) { //String类型
						String replaceOk = conStr.split("#")[0];
						if(conStr.split("#")[0].contains(replacedStr)) {
							replaceOk = conStr.split("#")[0].replace(replacedStr,replaceStr);
						}
						init = init + "(declare-const " + replaceOk +  " String)\r\n";
						finalvalue = finalvalue + "(get-value ("+  replaceOk + "))\r\n";
					}else if(conStr.split("#")[1].contains("double") || conStr.split("#")[1].contains("float")) { //Real类型变量
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
						//其待处理类型变量 约束求解局限
					}
				}
			}else if(g.getNode(ts[i]).getType() == "output"){ //针对响应序列转换为决策表问题
				Response = Response + g.getNode(ts[i]).getName() + "#"; //获取所有响应节点顺序序列
			}
		}
		int arrayRow = Response.split("#").length;
		String[][] resA = new String[arrayRow][];//约束排列组合  覆盖了几个响应节点，二维数组有几行
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
		getFileComb(resA); //生成所有可能的二维数组组合 
		//遍历conFileComb 生成约束求解文件
		for(int i=0;i<conFileComb.size();i++) {
			valueCount();//节点覆盖次数初始化
			myAssert = "";
			String[] ruleFileName = conFileComb.get(i).split("#");
			for(int j=0;j<ruleFileName.length;j++) {
				//设置该节点执行次数
				String opRes = ruleFileName[j].split("/")[4];
				int endIndex = opRes.lastIndexOf("Response");
				opRes = opRes.substring(0, endIndex);
				int count = mapOpCount.get(opRes) + 1;
				mapOpCount.put(opRes, count);
				
//				System.out.println(opRes);
				//读取文档内容
				File f = new File(ruleFileName[j]);
				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader(f));
					String str = null;
					try {
						while((str = br.readLine()) != null) {
							//处理每个约束assert,对于有&&的化为数组
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
	
	public void getFileComb(String[][] a) {//获取全部可能的约束文件组合，为后期生成测试数据做准备
		conFileComb.clear();//清空所有以前写进的组合(因为是新的测试序列了)
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
