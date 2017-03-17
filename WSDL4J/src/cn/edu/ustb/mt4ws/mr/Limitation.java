package cn.edu.ustb.mt4ws.mr;


public class Limitation {

	/**
	 * 下界，默认为null
	 */
	public String lower = null;

	/**
	 * 上界，默认为null
	 */
	public String upper = null;

	/**
	 * 求两个Limitation的交�?
	 * 
	 * @param limitNew
	 */
	public void merge(Limitation limitNew) {// TODO 其他类型的Limitation
		if (limitNew.lower != null && this.lower != null)
			this.lower = Math.max(Double.parseDouble(limitNew.lower), Double
					.parseDouble(this.lower))
					+ "";
		else if (limitNew.lower != null && this.lower == null)
			this.lower = limitNew.lower;
		else
			;
		if (limitNew.upper != null && this.upper != null)
			this.upper = Math.min(Double.parseDouble(this.upper), Double
					.parseDouble(limitNew.upper))
					+ "";
		else if (limitNew.upper != null && this.upper == null)
			this.upper = limitNew.upper;
		else
			;
	}

	/**
	 * 
	 * @param value
	 *            The value to be checked
	 * @param type
	 *            Now support only double type//TODO
	 * @return
	 */
	public boolean check(String value, Object type) {
		double valueDouble = Double.parseDouble(value);
		double upperDouble = Double.parseDouble(this.upper);
		double lowerDouble = Double.parseDouble(this.lower);
		return (valueDouble <= upperDouble && valueDouble >= lowerDouble);
	}

}
