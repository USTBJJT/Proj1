package cn.edu.ustb.cbwstc.analysis;

public class _89Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "((hehe haha hchc))";
		String dstr = str.substring(2, str.length()-2);
		System.out.println(dstr.indexOf(" "));
		System.out.println(dstr.substring(0, 4));
		System.out.println(dstr.substring(5));
		System.out.println(dstr);
		
		String strdM = "haha>908</";
		String strM = "haha>.*</";
		if(strdM.matches(strM)) {
			System.out.println("ok");
			String ai = strdM.replace(strM, "haha");
			System.out.println(ai);
		}
		

	}

}
