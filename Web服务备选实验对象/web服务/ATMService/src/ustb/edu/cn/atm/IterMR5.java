package ustb.edu.cn.atm;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class IterMR5 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IterMR5 test = new IterMR5();
		List<String> listFileNames=test.getFileNames();
		
		test.invokeATM(listFileNames,20);
		
	}

	/**
	 * 得到某个文件夹下所有子文件
	 * @return
	 */
	public List<String> getFileNames(){
		List<String> listFileNames=new ArrayList<String>();
		File file = new File(System.getProperty("user.dir")
				+ "\\src\\ustb\\edu\\cn\\atm");
		File[] lf = file.listFiles();
		System.out.println("文件夹数量："+lf.length);
		for (int i = 0; i < lf.length; i++) {
			//判断是否为文件夹
			if (lf[i].isDirectory()) {
				System.out.println("ustb.edu.cn.atm." + lf[i].getName()
						+ ".ConnectBank");
				listFileNames.add("ustb.edu.cn.atm." + lf[i].getName()
						+ ".ConnectBank");
			}
		}
		return listFileNames;
	}

	/**
	 * 自动调用ATM服务
	 * @param listFileNames
	 */
	public void invokeATM(List<String> listFileNames,int num){
		Map<String,List> mapCount=new HashMap<String,List>();
		Iterator<String> iterFile=listFileNames.iterator();
		while(iterFile.hasNext()){
			String fileName=iterFile.next();
			try {
				Class c=Class.forName(fileName);
				Constructor constructor = c.getDeclaredConstructor(new Class[] {  });
				constructor.setAccessible(true);
				Object o = constructor.newInstance(new Object[] { });

				Method transferMethod = c.getMethod("transferMoney",
						new Class[] { Class.forName("java.lang.String"),
								Class.forName("java.lang.String"), int.class,
								int.class });
				
				List<List<String>> listS = genTCS_MR5(5);
				Map map=genTCF_MR5(listS,num);				
				writeTCFile(map,fileName);
				
				Map<String, List> mapResult=getResult(map,transferMethod,o);
				//countList
				
				List countList=mapResult.get("countList");
				mapCount.put(fileName, countList);
				mapResult.remove("countList");
				
				writeResultFile(mapResult,fileName);
				
				
				
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();			
			}
		}
		
		
		writeCountFile(mapCount);
		
	}
	

	/**
	 * 写实验结果
	 * 
	 * @param map
	 */
	public void writeResultFile(Map<String, List> map,String fileName) {
		
		try {
			File f = new File("D:\\Iter\\MR5\\result_total\\" + fileName + ".txt");
			if (f.exists()) {
				System.out.println("文件存在");
			} else {
				System.out.println("文件不存在");
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			fw
					.write("tcId   SbalanceDeltaFrom  BalanceDeltaTo  FbalanceDeltaFrom BalanceDeltaTo  mrId  result");
			fw.write("\r\n");
			
			Set<String> keySet = map.keySet();
			Iterator<String> iterKey = keySet.iterator();
			while (iterKey.hasNext()) {
				String tcId = iterKey.next();
				List list = map.get(tcId);
				System.out.println(tcId + "   " + resultListToString(list));
				fw.write(tcId + "   " + resultListToString(list));
			}
			fw.flush();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 实验总数据写到文件中
	 */
	public void writeCountFile(Map<String,List> mapCount){
		
		try {
			File f = new File("D:\\Iter\\MR5\\result_total\\totalCount.txt");
			if (f.exists()) {
				System.out.println("文件存在");
			} else {
				System.out.println("文件不存在");
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			fw
					.write("fileName   count  totalNum  count/totalNum");
			fw.write("\r\n");
			
			Set<String> keySet = mapCount.keySet();
			Iterator<String> iterKey = keySet.iterator();
			while (iterKey.hasNext()) {
				String fileName = iterKey.next();
				List list = mapCount.get(fileName);
				System.out.println(fileName + "   " + countListToString(list));
				fw.write(fileName + "   " + countListToString(list));
			}
			fw.flush();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 将原始测试用例和衍生测试用例写到文件中
	 * 
	 * @param map
	 */
	public void writeTCFile(Map<List<String>, List<String>> map,String fileName) {

		try {
			File f = new File("D:\\Iter\\MR5\\testcase_total\\" + fileName + ".txt");
			if (f.exists()) {
				System.out.println("文件存在");
			} else {
				System.out.println("文件不存在");
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			fw
					.write("Sid   mrId   accountFrom   accountTo   mode   amount  Fid   mrId   accountFrom   accountTo   mode   amount");
			fw.write("\r\n");
			Set<List<String>> keySet = map.keySet();
			Iterator<List<String>> iterS = keySet.iterator();
			while (iterS.hasNext()) {
				StringBuilder strBuilder = new StringBuilder();
				List<String> listS = iterS.next();
				strBuilder.append(listToString(listS));
				List<String> listF = map.get(listS);
				strBuilder.append(listToString(listF));
				System.out.print(strBuilder.toString() + '\n');
				fw.write(strBuilder.toString());
				fw.write("\r\n");
			}

			fw.flush();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String listToString(List<String> list) {
		StringBuilder str = new StringBuilder();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			String str_temp = (String) iter.next();
			str.append(str_temp + "    ");
		}
		return str.toString();
	}
	
	/**
	 * 将countList转换为String
	 * @param list
	 * @return
	 */
	public String countListToString(List list){
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(list.get(0)+"  ").append(list.get(1)+"   ").append(list.get(2)+"  ").append("\r\n");
		return strBuf.toString();
		
	}
	
	/**
	 * 结果转化为String类型
	 * @param list
	 * @return
	 */
	public String resultListToString(List list) {
		StringBuffer strBuf = new StringBuffer();
		double[] balanceS = (double[]) list.get(0);
		double[] balanceF = (double[]) list.get(1);
		String mrID = (String) list.get(2);
		String result = String.valueOf(list.get(3));

		strBuf.append(balanceS[0] + "   ").append(balanceS[1] + "   ").append(
				balanceF[0] + "   ").append(balanceF[1] + "   ").append(mrID+"   ").append(result+" \r\n");
		return strBuf.toString();
	}

	
	/**
	 * 得到结果 key为Stestcase编号 List中存储原始测试用例结果和衍生测试用例结果
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, List> getResult(Map<List<String>, List<String>> map,Method transferMethod,Object o) {
		Map<String, List> newMap = new HashMap<String, List>();
		Set<List<String>> keySet = map.keySet();
		Iterator<List<String>> iterS = keySet.iterator();
		int totalNum=map.size();//测试用例数
		int count=0;//查出错误测试用例数
		List countList=new ArrayList();
		while (iterS.hasNext()) {
			
			List<String> listS = iterS.next();
			List<String> listF = map.get(listS);
			try {
				List listBalance = new ArrayList();
				double[] balanceS = (double[]) transferMethod.invoke(o, listS.get(2),
						listS.get(3), Integer.parseInt(listS.get(4)), Integer
						.parseInt(listS.get(5)));
				double[] balanceF = (double[]) transferMethod.invoke(o, listF
						.get(2), listF.get(3), Integer.parseInt(listF.get(4)),
						Integer.parseInt(listF.get(5)));
				listBalance.add(balanceS);// Source Balance
				listBalance.add(balanceF);// FollowUp Balance
				listBalance.add(listS.get(1));// mrId
				listBalance.add(checkResultByMR(listBalance));// 比较结果
				count=count+checkResultByMR(listBalance);//得到杀死的测试用例数
				newMap.put(listS.get(0), listBalance);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		countList.add(count);
		countList.add(totalNum);
		countList.add((float)count/totalNum);
		//
		newMap.put("countList", countList);
		return newMap;
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	public int checkResultByMR(List list) {
		String mrID = (String) list.get(2);
		double[] balanceS = (double[]) list.get(0);
		double[] balanceF = (double[]) list.get(1);
		if(balanceS==null||balanceF==null){
			return 1;
		}
		if (mrID.equals("1")) {
			// ∆A’<=2∆A 且 ∆B’=2∆B
		System.out.println(balanceS[0]+","+balanceS[1]+","+balanceF[0]+","+balanceF[1]);
			if (2 * balanceS[0] >= balanceF[0]
					&& balanceF[1] == 2 * balanceS[1]) {
				return 0;
			} else {
				return 1;
			}

		} else if (mrID.equals("2")) {
			//∆A’- ∆B’ = ∆A - ∆B
			if((balanceF[0]-balanceF[1])==(balanceS[0]-balanceS[1])){
				return 0;
			}else{
				return 1;
			}

		} else if (mrID.equals("3")) {
			//∆A’- ∆B’ > ∆A -∆B
			if((balanceF[0]-balanceF[1])>(balanceS[0]-balanceS[1])){
				return 0;
			}else{
				return 1;
			}
			
		} else if (mrID.equals("4")) {
			//∆A’- ∆B’ ≤ ∆A -∆B
			if((balanceF[0]-balanceF[1])<=(balanceS[0]-balanceS[1])){
				return 0;
			}else{
				return 1;
			}
		} else if (mrID.equals("5")) {
			//∆A’ > ∆A 且 ∆B’ > ∆B
			if((balanceF[0]>balanceS[0])&&(balanceF[1]>balanceS[1])){
				return 0;
			}else{
				return 1;
			}
			
		} else {
			return 2;
		}


	}
	
	/**
	 * 生成原始测试用例MR1
	 * 
	 * @return
	 */
	public List<List<String>> genTCS_MR5(int num) {

		List<List<String>> listSourceAll = new ArrayList<List<String>>();

		for (int i = 0; i < num; i++) {
			// 原始测试用例
			List<String> list_S = genSByRandom_MR5(i);
			listSourceAll.add(list_S);

		}
		return listSourceAll;
	}
	
	/**
	 * 得到原始测试用例MR1
	 */
	public List<String> genSByRandom_MR5(int i) {
		List<String> listS = new ArrayList<String>();

		// Source
		String id = String.valueOf(i);
		String accountFrom = genTenInt();
		String accountTo = genTenInt();
		String mode = genMode();
		String amount = genAmount();
		listS.add(id);
		listS.add(accountFrom);
		listS.add(accountTo);
		listS.add(mode);
		listS.add(amount);

		return listS;
	}
	
	/**
	 * 得到原始测试用例和衍生用例相对应的map
	 * MR1
	 * 
	 * @return
	 */
	public Map<List<String>, List<String>> genTCF_MR5(
			List<List<String>> listSourceAll,int num) {
		Map<List<String>, List<String>> map = new HashMap<List<String>, List<String>>();
		
		for (int i = 0; i < listSourceAll.size() && i < num; i++) {
			List<String> listS=listSourceAll.get(i);
			listS.add(1, "5");// mrID
			List<String> listF = getFollowUp_MR5(listS);
			map.put(listS, listF);
			List<String> newListS=new ArrayList();
			newListS.addAll(listF);
			newListS.remove(1);
			newListS.set(0,String.valueOf(listSourceAll.size()));
			listSourceAll.add(newListS);
		}

		return map;
	}
	
	/**
	 * 得到衍生测试用例 MR1 M’=2M ∆A’<=2∆A 且 ∆B’=2∆B
	 * 
	 * @param list
	 * @return
	 */
	public List<String> getFollowUp_MR5(List<String> list) {
		List<String> listF = new ArrayList<String>();

		String id = (String) list.get(0);
		String mrID = (String) list.get(1);
		String accountFrom = (String) list.get(2);
		String accountTo = (String) list.get(3);
		String mode = (String) list.get(4);
		String amount = (String) list.get(5);

		String amount_F = genGTAmount(amount);

		listF.add(id);
		listF.add(mrID);
		listF.add(accountFrom);
		listF.add(accountTo);
		listF.add(mode);
		listF.add(amount_F);

		return listF;
	}


	/**
	 * 随机获得10位数
	 * 
	 * @return
	 */
	public String genTenInt() {
		int a[] = new int[10];
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (10 * (Math.random()));
			str.append(a[i]);
		}

		return String.valueOf(str.toString());

	}

	/**
	 * 随机获得模式
	 * 
	 * @return
	 */
	public String genMode() {
		Random ran = new Random();
		int temp = ran.nextInt(4);
		return String.valueOf(temp);
	}
	
	public String genMode_MR3(){
		Random ran = new Random();
		int temp = ran.nextInt(3);
		return String.valueOf(temp+1);
	}
	
	public String genMode_MR4(){
		Random ran = new Random();
		int temp = ran.nextInt(3);
		return String.valueOf(temp);
	}

	/**
	 * 获得amount
	 * 
	 * @return
	 */
	public String genAmount() {
		int a = (int) (25 * (Math.random()));
		return String.valueOf(a*100);

	}
	
	public String genGTAmount(String amount){
		Random ran=new Random();
		int temp=ran.nextInt(100);
		return String.valueOf(temp+Integer.parseInt(amount));
		
	}


}
