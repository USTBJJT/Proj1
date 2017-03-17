package wsdl.parser;
import java.util.List;
import java.util.Map;

import cn.edu.ustb.mt4ws.tcg.WsdlOperationFormat;
import cn.edu.ustb.mt4ws.wsdl.parser.WsdlReader11;
public class InputParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("jajajaj");
		WsdlReader11 reader11 = new WsdlReader11();
		String wsdlUrl = "E:\\ExFile\\AirlinesBaggageBillingService.wsdl";
		Object doc = reader11.getWsdlDoc(wsdlUrl);
		Map services = reader11.getServices(doc);
		List bindingOps = reader11.getBindingOperations(services);
		for(int i = 0; i < bindingOps.size(); i++) {
			Object bop = bindingOps.get(i);			
			WsdlOperationFormat opFormat = reader11.getTestCase(wsdlUrl, bop);
			System.out.println(opFormat);
		}
		

	}

}
