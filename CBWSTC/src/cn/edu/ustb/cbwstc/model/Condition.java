package cn.edu.ustb.cbwstc.model;

import java.util.Map;

import org.apache.xmlbeans.SchemaType;

public class Condition {
	
	private int id;//约束序号，同一个边可以有很多约束
	private String name;
	private String type;
	private String lowLimite;
	private String highLimite;
	private boolean numLimite;
	private String minI;
	private String minE;
	private String maxI;
	private String maxE;
	private String pattern;
	private String invalidpattern;
	private String enumeration;
	private Map<String, SchemaType> simpleTypes;//存储相应输入参数
	private String content;//约束内容
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setContent(String content){ //字符串  由变量名#类型组成
		this.content = content;
	}
	
	public String getContent(){
//		String temp_contnet = getName() + " id=" + getId() + " type=" + getType();
//		if(!(getMinI()==null)) {
//			temp_contnet += " minI=" + getMinI();
//		}
//		if(!(getMinE()==null)) {
//			temp_contnet += " minE=" + getMinE();
//		}
//		if(!(getMaxI()==null)) {
//			temp_contnet += " maxI=" + getMaxI();
//		}
//		if(!(getMaxE()==null)) {
//			temp_contnet += " maxE=" + getMaxE();
//		}
//		if(!(getPattern()==null)) {
//			temp_contnet += " pattern=" + getPattern();
//		}
//		if(!(getEnumeration()==null)) {
//			temp_contnet += " enumeration=" + getEnumeration();
//		}
//		return temp_contnet;
		return content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMinI() {
		return minI;
	}

	public void setMinI(String minI) {
		this.minI = minI;
	}

	public String getMinE() {
		return minE;
	}

	public void setMinE(String minE) {
		this.minE = minE;
	}

	public String getMaxI() {
		return maxI;
	}

	public void setMaxI(String maxI) {
		this.maxI = maxI;
	}

	public String getMaxE() {
		return maxE;
	}

	public void setMaxE(String maxE) {
		this.maxE = maxE;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}

	public String getInvalidpattern() {
		return invalidpattern;
	}

	public void setInvalidpattern(String invalidpattern) {
		this.invalidpattern = invalidpattern;
	}

	public String getLowLimite() {
		return lowLimite;
	}

	public void setLowLimite(String lowLimite) {
		this.lowLimite = lowLimite;
	}

	public String getHighLimite() {
		return highLimite;
	}

	public void setHighLimite(String highLimite) {
		this.highLimite = highLimite;
	}

	public boolean isNumLimite() {
		return numLimite;
	}

	public void setNumLimite(boolean numLimite) {
		this.numLimite = numLimite;
	}

}
