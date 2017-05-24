package cn.edu.ustb.cbwstc.tcg;

import nl.flotsam.xeger.Xeger;

import org.apache.xmlbeans.SchemaType;

public class InvalidTcgUtils {
	
	public String invalidGenerate(SchemaType sType) {
		SchemaType primitiveType = sType.getPrimitiveType();
		switch (primitiveType.getBuiltinTypeCode()) {
			case SchemaType.BTC_FLOAT:
				return "1.5E2";
			case SchemaType.BTC_DOUBLE:
				return "1.051732E7";
			case SchemaType.BTC_DECIMAL:
				switch (closestBuiltin(sType).getBuiltinTypeCode()) {
				case SchemaType.BTC_SHORT:
					return "";
				case SchemaType.BTC_UNSIGNED_SHORT:
					return "";
				case SchemaType.BTC_BYTE:
					return "";
				case SchemaType.BTC_UNSIGNED_BYTE:
					return "";
				case SchemaType.BTC_INT:
					return "";
				case SchemaType.BTC_UNSIGNED_INT:
					return "";
				case SchemaType.BTC_LONG:
					return "";
				case SchemaType.BTC_UNSIGNED_LONG:
					return "";
				case SchemaType.BTC_INTEGER:
					return "";
				case SchemaType.BTC_NON_POSITIVE_INTEGER:
					return "";
				case SchemaType.BTC_NEGATIVE_INTEGER:
					return "";
				case SchemaType.BTC_NON_NEGATIVE_INTEGER:
					return "";
				case SchemaType.BTC_POSITIVE_INTEGER:
					return "";
				default:
				case SchemaType.BTC_DECIMAL:
					return "";
				}

			case SchemaType.BTC_STRING: {
				String result;
				if (sType.hasPatternFacet() == false) {
					switch (closestBuiltin(sType).getBuiltinTypeCode()) {
					case SchemaType.BTC_STRING:
					case SchemaType.BTC_NORMALIZED_STRING:
						//result = pick(WORDS, _picker.nextInt(3));
						break;

					case SchemaType.BTC_TOKEN:
						//result = pick(WORDS, _picker.nextInt(3));
						break;

					default:
						//result = pick(WORDS, _picker.nextInt(3));
						break;
					}
				} else {
					String regex = sType.getPatterns()[0];
					Xeger generator = new Xeger(regex);
					result = generator.generate();
					return result;
				}
				return "";
			}
			default:
				return "";
		}
	
	}
	
	public SchemaType closestBuiltin(SchemaType sType) {
		while (!sType.isBuiltinType())
			sType = sType.getBaseType();
		return sType;
	}
	
	//TODO
	//如果该类型有pattern或者enumeration，则使用该数据的invalidpattern属性中显示的正则表达式生成对应的值

}
