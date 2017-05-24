package cn.edu.ustb.cbwstc.tcg;


public class XmlMessage {

	/**
	 * structure of input vector
	 */
	public String sampleSoapMessage;

	/**
	 * name,type and restriction of each element in Input vector
	 */
	public XmlMessageFormat format;

	public String toString() {
		return format.toString();
	}
	

}
