package wsdl.parser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import tcg.WsdlOperationFormat;

/**
 * An abstract WSDL reader
 * @author WangGuan
 *
 */
public abstract class AbstractWsdlReader {

	public static final int WSDL11 = 1;
	public static final int WSDL20 = 2;

	/**
	 * 杩斿洖Map锛屾寚绀築indingOperation涓嶵estCase鐨勫搴斿叧绯�
	 * <p>
	 * 浣跨敤Template Pattern(Template妯″紡锛岀敤浜庡皝瑁呯畻娉�)
	 * 
	 * @param WsdlURI
	 * @return Map<BindingOperation(wsdl4j or woden),TestCase>
	 */
	public final Map<String, WsdlOperationFormat> parseWSDL(String WsdlURI) {
		Object doc = getWsdlDoc(WsdlURI);
		Map services = getServices(doc);
		List bindingOps = getBindingOperations(services);
		return putTestCases(WsdlURI, bindingOps);
	}

	/**
	 * @param WsdlURI
	 * @return WSDL1.1: Definition; WSDL2.0: Description
	 */
	public abstract Object getWsdlDoc(String WsdlURI);

	/**
	 * 
	 * @param DefOrDesc
	 *            WSDL1.1->Definition; WSDL2.0->Description
	 * @return
	 */
	public abstract Map getServices(Object DefOrDesc);

	/**
	 * 
	 * @param services
	 * @return bindingOperations
	 */
	public abstract List getBindingOperations(Map services);

	/**
	 * 
	 * @param bop
	 *            BindingOperation(wsdl4j or woden)
	 * @return
	 */
	public abstract WsdlOperationFormat getTestCase(String WsdlURI, Object bop);

	/**
	 * 灏嗘瘡涓狟indingOperation瑙ｆ瀽涓虹浉搴旂殑TestCase骞跺啓鍏ap涓繑鍥�
	 * <p>
	 * 鐢盬SDL鐗堟湰鑷姩鍒ゆ柇杩斿洖鍊糓ap閲岄潰鐨凮bject鏄摢涓増鏈殑BindingOperation
	 * 
	 * @param bindingOps
	 * @return (BindingOperation(wsdl4j or woden),TestCase)
	 */
	private Map<String, WsdlOperationFormat> putTestCases(String WsdlURI,
			List bindingOps) {
		int wsdlVersion = checkWsdlVersion(WsdlURI);
		Map<String, WsdlOperationFormat> map = new LinkedHashMap<String, WsdlOperationFormat>();
		
		if (wsdlVersion == this.WSDL11)
			for (int i = 0; i < bindingOps.size(); i++) {
				Object bop = bindingOps.get(i);			
				WsdlOperationFormat opFormat = getTestCase(WsdlURI, bop);
				
				map
						.put(((javax.wsdl.BindingOperation) bop).getName(),
								opFormat);
				System.out.println("operationName: "
						+ ((javax.wsdl.BindingOperation) bop).getName());
			}
		else
			// wsdl2.0
			for (int i = 0; i < bindingOps.size(); i++) {
				Object bop = bindingOps.get(i);
				WsdlOperationFormat opFormat = getTestCase(WsdlURI, bop);
				map.put(((org.apache.woden.wsdl20.InterfaceOperation) bop)
						.getName().getLocalPart(), opFormat);
			}
		return map;
	}

	private int checkWsdlVersion(String wsdlURI) {
		return this.WSDL11;// TODO
	}

}
