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

public class IterMR12345 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IterMR12345 test = new IterMR12345();
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
				
				List<List<String>> listS = genTCS_MR1(5);
				Map map=genTCF_MR12345(listS,num);				
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
			File f = new File("D:\\Iter\\MR12345\\result_total\\" + fileName + ".txt");
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
			File f = new File("D:\\Iter\\MR12345\\result_total\\totalCount.txt");
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
			File f = new File("D:\\Iter\\MR12345\\testcase_total\\" + fileName + ".txt");
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
	public List<List<String>> genTCS_MR1(int num) {

		List<List<String>> listSourceAll = new ArrayList<List<String>>();

		for (int i = 0; i < num; i++) {
			// 原始测试用例
			List<String> list_S = genSByRandom_MR1(i);
			listSourceAll.add(list_S);

		}
		return listSourceAll;
	}
	
	/**
	 * 得到原始测试用例MR1
	 */
	public List<String> genSByRandom_MR1(int i) {
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
	public Map<List<String>, List<String>> genTCF_MR12345(
			List<List<String>> listSourceAll,int num) {
		Map<List<String>, List<String>> map = new HashMap<List<String>, List<String>>();
		
		for (int i = 0; i < listSourceAll.size() && i < num; i++) {
			List<String> listS=listSourceAll.get(i);
			//检查TC是否符合MR1标准
			if (checkTCMR1(listS)) {
				List<String> listS_1 = new ArrayList();
				listS_1.addAll(listS);
				listS_1.add(1, "1");// mrID
				List<String> listF_1 = getFollowUp_MR1(listS_1);
				map.put(listS_1, listF_1);
				List<String> newListS_1 = new ArrayList();
				newListS_1.addAll(listF_1);
				newListS_1.remove(1);
				newListS_1.set(0, String.valueOf(listSourceAll.size()));
				listSourceAll.add(newListS_1);
				i++;
				if (i >= num) {
					return map;
				}
			}
			
			//检查TC是否符合MR2标准
			if (checkTCMR2(listS)) {
				List<String> listS_2 = new ArrayList();
				listS_2.addAll(listS);
				listS_2.add(1, "2");// mrID
				List<String> listF_2 = getFollowUp_MR2(listS_2);
				map.put(listS_2, listF_2);
				List<String> newListS_2 = new ArrayList();
				newListS_2.addAll(listF_2);
				newListS_2.remove(1);
				newListS_2.set(0, String.valueOf(listSourceAll.size()));
				listSourceAll.add(newListS_2);
				i++;
				if (i >= num) {
					return map;
				}
			}
			
			//检查TC是否符合MR2标准
			if (checkTCMR3(listS)) {
				List<String> listS_3 = new ArrayList();
				listS_3.addAll(listS);
				listS_3.add(1, "3");// mrID
				List<String> listF_3 = getFollowUp_MR3(listS_3);
				map.put(listS_3, listF_3);
				List<String> newListS_3 = new ArrayList();
				newListS_3.addAll(listF_3);
				newListS_3.remove(1);
				newListS_3.set(0, String.valueOf(listSourceAll.size()));
				listSourceAll.add(newListS_3);
				i++;
				if (i >= num) {
					return map;
				}
			}
			
			//检查TC是否符合MR4标准
			if (checkTCMR4(listS)) {
				List<String> listS_4 = new ArrayList();
				listS_4.addAll(listS);
				listS_4.add(1, "4");// mrID
				List<String> listF_4 = getFollowUp_MR4(listS_4);
				map.put(listS_4, listF_4);
				List<String> newListS_4 = new ArrayList();
				newListS_4.addAll(listF_4);
				newListS_4.remove(1);
				newListS_4.set(0, String.valueOf(listSourceAll.size()));
				listSourceAll.add(newListS_4);
				i++;
				if (i >= num) {
					return map;
				}
			}
			
			List<String> listS_5=new ArrayList();
			listS_5.addAll(listS);
			listS_5.add(1, "5");
			List<String> listF_5=getFollowUp_MR5(listS_5);
			map.put(listS_5, listF_5);
			List<String> newListS_5=new ArrayList();
			newListS_5.addAll(listF_5);
			newListS_5.remove(1);
			newListS_5.set(0,String.valueOf(listSourceAll.size()));
			listSourceAll.add(newListS_5);
				
		}

		return map;
	}
	
	/**
	 * 判断TC是否可当做MR1使用
	 * MR1：amount<=25000
	 * 
	 * @param list
	 * @return
	 */
	public boolean checkTCMR1(List list){
		if(Integer.parseInt(((String)list.get(4)))<=25000)
			return true;
		else 
			return false;
		
	}
	
	/**
	 * 判断TC是否可当做MR2使用
	 * MR2：P=1
	 * 
	 * @param list
	 * @return
	 */
	public boolean checkTCMR2(List list){
		if(((String)list.get(3)).equals("1"))
			return true;
		else 
			return false;
		
	}
	
	/**
	 * 判断TC是否可当做MR3使用
	 * MR3：P=0
	 * 
	 * @param list
	 * @return
	 */
	public boolean checkTCMR3(List list){
		if(((String)list.get(3)).equals("0"))
			return true;
		else 
			return false;
		
	}
	/**
	 * 判断TC是否可当做MR4使用
	 * MR4：P=3
	 * 
	 * @param list
	 * @return
	 */
	public boolean checkTCMR4(List list){
		if(((String)list.get(3)).equals("3"))
			return true;
		else 
			return false;
		
	}
	
	/**
	 * 得到衍生测试用例 MR1 M’=2M ∆A’<=2∆A 且 ∆B’=2∆B
	 * 
	 * @param list
	 * @return
	 */
	public List<String> getFollowUp_MR1(List<String> list) {
		List<String> listF = new ArrayList<String>();

		String id = (String) list.get(0);
		String mrID = (String) list.get(1);
		String accountFrom = (String) list.get(2);
		String accountTo = (String) list.get(3);
		String mode = (String) list.get(4);
		String amount = (String) list.get(5);

		String amount_F = String.valueOf((Integer.parseInt(amount) * 2));

		listF.add(id);
		listF.add(mrID);
		listF.add(accountFrom);
		listF.add(accountTo);
		listF.add(mode);
		listF.add(amount_F);

		return listF;
	}
	
	/**
	 * 得到衍生测试用例 MR2 M’=2
	 * 
	 * @param list
	 * @return
	 */
	public List<String> getFollowUp_MR2(List<String> list) {
		List<String> listF = new ArrayList<String>();

		String id = (String) list.get(0);
		String mrID = (String) list.get(1);
		String accountFrom = (String) list.get(2);
		String accountTo = (String) list.get(3);
		String mode = (String) list.get(4);
		String amount = (String) list.get(5);

		String modeF = "2";

		listF.add(id);
		listF.add(mrID);
		listF.add(accountFrom);
		listF.add(accountTo);
		listF.add(modeF);
		listF.add(amount);

		return listF;
	}
	
	/**
	 * 得到衍生测试用例 MR3 M’!=0
	 * 
	 * @param list
	 * @return
	 */
	public List<String> getFollowUp_MR3(List<String> list) {
		List<String> listF = new ArrayList<String>();

		String id = (String) list.get(0);
		String mrID = (String) list.get(1);
		String accountFrom = (String) list.get(2);
		String accountTo = (String) list.get(3);
		String mode = (String) list.get(4);
		String amount = (String) list.get(5);

		String modeF = genMode_MR3();

		listF.add(id);
		listF.add(mrID);
		listF.add(accountFrom);
		listF.add(accountTo);
		listF.add(modeF);
		listF.add(amount);

		return listF;
	}
	
	/**
	 * 得到衍生测试用例 MR4 M’!=3
	 * 
	 * @param list
	 * @return
	 */
	public List<String> getFollowUp_MR4(List<String> list) {
		List<String> listF = new ArrayList<String>();

		String id = (String) list.get(0);
		String mrID = (String) list.get(1);
		String accountFrom = (String) list.get(2);
		String accountTo = (String) list.get(3);
		String mode = (String) list.get(4);
		String amount = (String) list.get(5);

		String modeF = genMode_MR4();

		listF.add(id);
		listF.add(mrID);
		listF.add(accountFrom);
		listF.add(accountTo);
		listF.add(modeF);
		listF.add(amount);

		return listF;
	}
	
	/**
	 * 得到衍生测试用例 MR5 M’>M 
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
		return String.valueOf(a);

	}
	
	public String genGTAmount(String amount){
		Random ran=new Random();
		int temp=ran.nextInt(100);
		return String.valueOf(temp+Integer.parseInt(amount));
		
	}


}
