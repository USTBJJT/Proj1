package cn.edu.ustb.cbwstc.analysis;

public class StringReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Sstr = "loginRequest_?_time > loginRequest_?_timee";
		String mark = "loginRequest_?";
		if(Sstr.contains(mark)) {
			System.out.println("haha");
			Sstr = Sstr.replace(mark, "loginRequest_1");
		}
		System.out.println(Sstr);
	}
}
