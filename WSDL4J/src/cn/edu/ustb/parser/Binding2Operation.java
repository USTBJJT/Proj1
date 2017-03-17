package cn.edu.ustb.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.Port;
import javax.wsdl.Service;

import tcg.WsdlOperationFormat;
import wsdl.parser.WsdlReader11;

public class Binding2Operation {
	
	public static void B2OInterface(Map services) {
		
		// 获取绑定标签中的所有操作（获取对应服务提供的操作）
		List bindingOps = getBindingOperations(services);
				
		// 针对每个操作
		for(int i = 0; i < bindingOps.size(); i++) {
			Object bop = bindingOps.get(i);
			WsdlReader11 wr = new WsdlReader11();
			
			//参数解析
			WsdlOperationFormat opFormat = wr.getTestCase("E://ExFile//ATM.wsdl", bop);
			Object[] opPremAry = opFormat.getInput().format.getSimpleTypes().keySet().toArray();
			String[] opPremClassAry = new String[opPremAry.length];
			for (int j = 0; j < opPremAry.length; ++j) {
				System.out.println(opPremClassAry[j]);
			}
			
//			// 输出操作的名字
//			System.out.println("		#<Op> Operation Name: "+ ((javax.wsdl.BindingOperation) bop).getName());
//			String soapAction = ((javax.wsdl.BindingOperation) bop).getExtensibilityElements().get(0).toString();
//			System.out.println("		#<Op> Operation soapAction: " + soapAction.substring(soapAction.indexOf("soapAction")));
//			// 获取操作的输入“名字” “消息” “消息的”
//			Operation2Message.O2MInterface((javax.wsdl.BindingOperation) bop);
		}
		
	}
	
	/**
	 * A function get all Operation about a port (from a service)
	 * 顺序：获取服务——获取服务的端口——再获取端口对应的绑定——再获取绑定中的操作
	 * @author JiaJingting
	 *
	 */
	private static List getBindingOperations(Map services) {
		List bopL = new ArrayList();
		if(services != null) {
			Iterator servicesIter = services.values().iterator();//iterator迭代
			
			//针对每个WSDL提及的服务
			while (servicesIter.hasNext()) {
				Service service = (Service) servicesIter.next();
				System.out.println("#<S> Service name: " + service.getQName());
				//getPorts()，Get all the ports defined here.
				
				Iterator portsIter = service.getPorts().values().iterator();
				
				//针对一个服务提供的port访问端口
				while (portsIter.hasNext()) {
					Port port = (Port) portsIter.next();
					
					System.out.println("	#<P> Port name: " + port.getName());
					
					String Location = port.getExtensibilityElements().get(0).toString();
					System.out.println("	#<P> Port Location: " + Location.substring(Location.indexOf("locationURI")));
					//Get the binding this port refers to 获取此端口所指的绑定
					Binding binding = port.getBinding();
					
					//Get all the operation bindings defined here.获取这里定义的所有操作绑定
					List bindingOperations = binding.getBindingOperations();
					Iterator bOperIter = bindingOperations.iterator();
					
					//针对每个操作
					while (bOperIter.hasNext()) {
						BindingOperation bindingOper = (BindingOperation) bOperIter.next();
						bopL.add(bindingOper);
					}
				}
			}
			return bopL;
		}
		else {
			return null;
		}

	}
	
	

}
