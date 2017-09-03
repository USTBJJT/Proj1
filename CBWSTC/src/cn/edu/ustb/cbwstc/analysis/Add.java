package cn.edu.ustb.cbwstc.analysis;

import java.util.Random;

import cn.edu.ustb.cbwstc.tcg.MathTcg;

public class Add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		Random random = new Random();
		MathTcg m = new MathTcg(random);
		System.out.println(m.intIITCG(Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(m.doubleTCG(Double.MIN_VALUE, Double.MAX_VALUE));
	}
}
