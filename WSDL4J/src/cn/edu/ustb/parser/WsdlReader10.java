package cn.edu.ustb.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import javax.wsdl.Binding;
import javax.wsdl.Input;
import javax.wsdl.Part;
import javax.wsdl.Port;
import javax.wsdl.Service;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

public class WsdlReader10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Definition mydef = readWsdl10("E://DebugForSS.wsdl");
		
		// 获取WSDL中的服务
		Map services = mydef.getServices();
			
		// 获取绑定标签中的所有操作（获取对应服务提供的操作）
		List bindingOps = getBindingOperations(services);
		
		// 针对每个操作
		for(int i = 0; i < bindingOps.size(); i++) {
			Object bop = bindingOps.get(i);
			
			// 输出操作的名字
			System.out.println("operationName: "+ ((javax.wsdl.BindingOperation) bop).getName());
			
			// 获取操作的输入“名字” “消息” “消息的”
			getOperationInput((javax.wsdl.BindingOperation) bop);
		}
		
		System.out.println(mydef.getTypes());
		
	}
	
	/**
	 * A real WSDL Reader for WSDL1.1
	 * @author JiaJingting
	 *
	 */
	public static Definition readWsdl10(String WsdlURL) {
		WSDLFactory factory;
		try {
			
			factory = WSDLFactory.newInstance();
			WSDLReader reader=factory.newWSDLReader();
			
			/*public void setFeature(java.lang.String name,boolean value) throws java.lang.IllegalArgumentException
			if "javax.wsdl.verbose" is true, status messages will be displayed.
			状态消息将被显示
			if "javax.wsdl.importDocuments" is true, imported WSDL documents will be retrieved and processed
			导入的WSDL文件将被检索和处理*/
			reader.setFeature("javax.wsdl.verbose",true);  
			reader.setFeature("javax.wsdl.importDocuments",true);
			
			//获取服务的definitions根节点
			Definition def=reader.readWSDL(WsdlURL);
			return def;
			
		} catch (WSDLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return null;
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
				
				//getPorts()，Get all the ports defined here.
				Iterator portsIter = service.getPorts().values().iterator();
				
				//针对一个服务提供的port访问端口
				while (portsIter.hasNext()) {
					Port port = (Port) portsIter.next();
					
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
	
	/**
	 * This interface represents a WSDL operation. 
	 * It includes information on input (the name/Message of the input) associated with usage of the operation.
	 * @author JiaJingting
	 *
	 */
	private static void getOperationInput(BindingOperation bindingOper) {
		
		// bindingOper.getOperation() 返回一个 对应的operation，可对该操作进行操作输入名称及消息的获取
		Input input = (Input) bindingOper.getOperation().getInput();
		System.out.println("===========================================================");
		
		// 输出 “输入操作的名称”
		System.out.println("	inputName: " + input.getName());
		
		// 输出 “输入操作的消息的局部名称”
		String message = input.getMessage().getQName().getLocalPart();
		System.out.println("	inputMessage: " + message);
		
		//对于message标签中的part标签进行解析
		getMessagePart(input.getMessage().getParts());
		
		System.out.println("===========================================================");
	}
	
	
	/**
	 * This interface represents a WSDL operation. 
	 * It includes information on input (the name/element of the Message) associated with usage of the operation.
	 * @author JiaJingting
	 *
	 */
	private static void getMessagePart(Map map) {
		Iterator partIter = map.values().iterator();
		while(partIter.hasNext())
	    {
			Part part= (Part) partIter.next();
			System.out.println("		part name:"+ part.getName());
			System.out.println("		part element:"+ part.getElementName().getLocalPart());
	    }
	}
	
	
	private static void getTypes(Map map) {
		Iterator typeIter = map.values().iterator();
		
	}
	
	

}
