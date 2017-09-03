package cn.edu.ustb.cbwstc.tcg;

import nl.flotsam.xeger.Xeger;

public class XegerTCG {
	
	/**
	 * 
	 * @param regex
	 * @return
	 */
	public String gerTcg(String regex) {
		Xeger generator = new Xeger(regex);
		String result = generator.generate(); 
		return result;
	}
}
