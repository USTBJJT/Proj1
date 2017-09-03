package cn.edu.ustb.cbwstc.analysis;

import java.util.Random;

import cn.edu.ustb.cbwstc.tcg.MathTcg;
import cn.edu.ustb.cbwstc.tcg.XegerTCG;

public class CalculateReimbursementAmountTCG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = Integer.MAX_VALUE;
		Random random = new Random();
		MathTcg m = new MathTcg(random);
		XegerTCG x = new XegerTCG();
		System.out.print(m.intIITCG(0, 4000));
		System.out.print(",");
		System.out.print(x.gerTcg("seniormanager"));
		System.out.println();
		
		System.out.print(m.intIITCG(4000, max));
		System.out.print(",");
		System.out.print(x.gerTcg("seniormanager"));
		System.out.println();
		
		System.out.print(m.intIITCG(0, 3000));
		System.out.print(",");
		System.out.print(x.gerTcg("manager"));
		System.out.println();
		
		System.out.print(m.intIITCG(3000, max));
		System.out.print(",");
		System.out.print(x.gerTcg("manager"));
		System.out.println();
		
		System.out.print(m.intIITCG(1, max));
		System.out.print(",");
		System.out.print(x.gerTcg("supervisor"));
		System.out.println();
		
		System.out.print(4000);
		System.out.print(",");
		System.out.print(x.gerTcg("seniormanager"));
		System.out.println();
		
		System.out.print(3000);
		System.out.print(",");
		System.out.print(x.gerTcg("manager"));
		System.out.println();
		System.out.print("**********************");
		for(int i =0;i<20;i++) {
			System.out.print(m.intIITCG(1, 20000));
			System.out.print(",");
			System.out.print(x.gerTcg("seniormanager|manager"));
			System.out.println();
		}
		;;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

	}

}
