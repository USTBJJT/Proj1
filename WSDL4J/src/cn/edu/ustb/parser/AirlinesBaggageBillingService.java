package cn.edu.ustb.parser;

import cn.edu.ustb.parser.MACException;

public class AirlinesBaggageBillingService {
	
	private static int airClass = 0; //飞机客位

	private static int area = 0;//地区

	private double luggage = 0;//行李重量

	private static double benchmark = 0;//免费重量

	private static double luggagefee = 0;//所需费用

	private boolean isStudent = false; //学生

	private double economicfee = 0; // 飞机票价
	
	
	public static double feeCalculation(double luggage, double economicfee ){
		
		if (benchmark>luggage){ 

        	luggage=benchmark;
        }
        return luggagefee = (luggage - benchmark) * economicfee * 0.015;
	}
	
	public static void setBenchmark( int chooseAirClass, int chooseArea, boolean isStudent) throws MACException
    {
		if(chooseAirClass>=0 && chooseAirClass<=3) {
			airClass = chooseAirClass;
			area = chooseArea;
			switch (airClass) {
	        case 0 :
	            benchmark = 40;
	            break;

	        case 1 :
	            benchmark = 30;
	            break;

	        case 2 :
	            benchmark = 20;
	            break;

	        case 3 :
	            benchmark = 0;
	            break;

	        }
			if (chooseArea == 1) {
			
				if (isStudent) {
					benchmark = 30;
				}
			}
		}else {
			throw new MACException("chooseAirClass " + chooseAirClass + " is a invalid parameter");
		}
    }
	
//	public static void  main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			setBenchmark(1,0,false);
//			System.out.println(feeCalculation(1,300));
//		} catch (MACException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		}
//
//	}

}
