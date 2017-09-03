package cn.edu.ustb.cbwstc.analysis;

import java.util.Random;

import cn.edu.ustb.cbwstc.tcg.MathTcg;

public class MathTcgTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		MathTcg m = new MathTcg(random);
		int min = 0;
		int max = 50;
		for(int i = 0;i<5;i++) {
			System.out.println(m.intIITCG(min,max));
		}
			

	}

}
