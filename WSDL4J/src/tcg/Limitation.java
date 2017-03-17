package tcg;

public class Limitation {

	/**
	 * 涓嬬晫锛岄粯璁や负null
	 */
	public String lower = null;

	/**
	 * 涓婄晫锛岄粯璁や负null
	 */
	public String upper = null;

	/**
	 * 姹備袱涓狶imitation鐨勪氦闆�
	 * 
	 * @param limitNew
	 */
	public void merge(Limitation limitNew) {// TODO 鍏朵粬绫诲瀷鐨凩imitation
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
