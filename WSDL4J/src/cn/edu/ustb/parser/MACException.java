package cn.edu.ustb.parser;

public class MACException extends Exception{
	
	MACException(String str) {
		super(str);
		System.out.println(str);
	}

}
