package ustb.edu.cn.atm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class IterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			if(balanceF[0]-balanceF[1]==balanceS[0]-balanceS[1]){
				return 0;
			}else{
				return 1;
			}

		} else if (mrID.equals("3")) {
			//∆A’- ∆B’ > ∆A -∆B
			if(balanceF[0]-balanceF[1]>balanceS[0]-balanceS[1]){
				return 0;
			}else{
				return 1;
			}
			
		} else if (mrID.equals("4")) {
			//∆A’- ∆B’ ≤ ∆A -∆B
			if(balanceF[0]-balanceF[1]<balanceS[0]-balanceS[1]){
				return 0;
			}else{
				return 1;
			}
		} else if (mrID.equals("5")) {
			//∆A’ > ∆A 且 ∆B’ > ∆B
			if(balanceF[0]>balanceS[0]&&balanceF[1]>balanceS[1]){
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
	 * 生成原始测试用例MR2
	 * M=1
	 * @return
	 */
	public List<List<String>> genTCS_MR2(int num) {

		List<List<String>> listSourceAll = new ArrayList<List<String>>();

		for (int i = 0; i < num; i++) {
			// 原始测试用例
			List<String> list_S = genSByRandom_MR1(i);
			listSourceAll.add(list_S);

		}
		return listSourceAll;
	}
	
	/**
	 * 生成原始测试用例MR3
	 * M=0
	 * @return
	 */
	public List<List<String>> genTCS_MR3(int num) {

		List<List<String>> listSourceAll = new ArrayList<List<String>>();

		for (int i = 0; i < num; i++) {
			// 原始测试用例
			List<String> list_S = genSByRandom_MR3(i);
			listSourceAll.add(list_S);

		}
		return listSourceAll;
	}
	
	/**
	 * 生成原始测试用例MR4
	 * M=3
	 * @return
	 */
	public List<List<String>> genTCS_MR4(int num) {

		List<List<String>> listSourceAll = new ArrayList<List<String>>();

		for (int i = 0; i < num; i++) {
			// 原始测试用例
			List<String> list_S = genSByRandom_MR4(i);
			listSourceAll.add(list_S);

		}
		return listSourceAll;
	}
	
	/**
	 * 生成原始测试用例MR5
	 * amount’ > amount
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
	 * 得到原始测试用例MR2
	 * M=1
	 */
	public List<String> genSByRandom_MR2(int i) {
		List<String> listS = new ArrayList<String>();

		// Source
		String id = String.valueOf(i);
		String accountFrom = genTenInt();
		String accountTo = genTenInt();
		String mode = "1";
		String amount = genAmount();
		listS.add(id);
		listS.add(accountFrom);
		listS.add(accountTo);
		listS.add(mode);
		listS.add(amount);

		return listS;
	}
	
	/**
	 * 得到原始测试用例MR3
	 * M=0
	 */
	public List<String> genSByRandom_MR3(int i) {
		List<String> listS = new ArrayList<String>();

		// Source
		String id = String.valueOf(i);
		String accountFrom = genTenInt();
		String accountTo = genTenInt();
		String mode = "0";
		String amount = genAmount();
		listS.add(id);
		listS.add(accountFrom);
		listS.add(accountTo);
		listS.add(mode);
		listS.add(amount);

		return listS;
	}
	

	/**
	 * 得到原始测试用例MR4
	 * M=3
	 */
	public List<String> genSByRandom_MR4(int i) {
		List<String> listS = new ArrayList<String>();

		// Source
		String id = String.valueOf(i);
		String accountFrom = genTenInt();
		String accountTo = genTenInt();
		String mode = "3";
		String amount = genAmount();
		listS.add(id);
		listS.add(accountFrom);
		listS.add(accountTo);
		listS.add(mode);
		listS.add(amount);

		return listS;
	}
	
	/**
	 * 得到原始测试用例MR5
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
	public Map<List<String>, List<String>> genTCF_MR1(
			List<List<String>> listSourceAll) {
		Map<List<String>, List<String>> map = new HashMap<List<String>, List<String>>();
		Iterator<List<String>> iterSource = listSourceAll.iterator();
		while (iterSource.hasNext()) {
			List<String> listS = iterSource.next();
			listS.add(1, "1");// mrID
			List<String> listF = getFollowUp_MR1(listS);
			map.put(listS, listF);
		}

		return map;
	}
	
	/**
	 * 得到原始测试用例和衍生用例相对应的map
	 * MR2
	 * 
	 * @return
	 */
	public Map<List<String>, List<String>> genTCF_MR2(
			List<List<String>> listSourceAll) {
		Map<List<String>, List<String>> map = new HashMap<List<String>, List<String>>();
		Iterator<List<String>> iterSource = listSourceAll.iterator();
		while (iterSource.hasNext()) {
			List<String> listS = iterSource.next();
			listS.add(1, "2");// mrID
			List<String> listF = getFollowUp_MR2(listS);
			map.put(listS, listF);
		}

		return map;
	}
	
	/**
	 * 得到原始测试用例和衍生用例相对应的map
	 * MR3
	 * 
	 * @return
	 */
	public Map<List<String>, List<String>> genTCF_MR3(
			List<List<String>> listSourceAll) {
		Map<List<String>, List<String>> map = new HashMap<List<String>, List<String>>();
		Iterator<List<String>> iterSource = listSourceAll.iterator();
		while (iterSource.hasNext()) {
			List<String> listS = iterSource.next();
			listS.add(1, "3");// mrID
			List<String> listF = getFollowUp_MR3(listS);
			map.put(listS, listF);
		}

		return map;
	}
	
	/**
	 * 得到原始测试用例和衍生用例相对应的map
	 * MR4
	 * 
	 * @return
	 */
	public Map<List<String>, List<String>> genTCF_MR4(
			List<List<String>> listSourceAll) {
		Map<List<String>, List<String>> map = new HashMap<List<String>, List<String>>();
		Iterator<List<String>> iterSource = listSourceAll.iterator();
		while (iterSource.hasNext()) {
			List<String> listS = iterSource.next();
			listS.add(1, "4");// mrID
			List<String> listF = getFollowUp_MR4(listS);
			map.put(listS, listF);
		}

		return map;
	}
	
	/**
	 * 得到原始测试用例和衍生用例相对应的map
	 * MR5
	 * 
	 * @return
	 */
	public Map<List<String>, List<String>> genTCF_MR5(
			List<List<String>> listSourceAll) {
		Map<List<String>, List<String>> map = new HashMap<List<String>, List<String>>();
		Iterator<List<String>> iterSource = listSourceAll.iterator();
		while (iterSource.hasNext()) {
			List<String> listS = iterSource.next();
			listS.add(1, "5");// mrID
			List<String> listF = getFollowUp_MR5(listS);
			map.put(listS, listF);
		}

		return map;
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
	 * 得到衍生测试用例 MR4 M’!=3
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

		String amountF = genGTAmount(amount);

		listF.add(id);
		listF.add(mrID);
		listF.add(accountFrom);
		listF.add(accountTo);
		listF.add(mode);
		listF.add(amountF);

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
