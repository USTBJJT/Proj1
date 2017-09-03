package cn.edu.ustb.cbwstc.analysis;

public class StringCut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Start#e0#Init#e1#login#e2#loginRequest_succ#ef#login";
		int index = str.indexOf("#ef");
		System.out.println(index);
		System.out.println(str.substring(0, index));
		String dest = str.substring(index + 4);
		String[] d= dest.split("#");
		for(int i=0;i<d.length;i++) {
			System.out.println("=======");
			System.out.println(d[i]);
		}
		

	}

}
