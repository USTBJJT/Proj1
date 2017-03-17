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
		
		// ��ȡWSDL�еķ���
		Map services = mydef.getServices();
			
		// ��ȡ�󶨱�ǩ�е����в�������ȡ��Ӧ�����ṩ�Ĳ�����
		List bindingOps = getBindingOperations(services);
		
		// ���ÿ������
		for(int i = 0; i < bindingOps.size(); i++) {
			Object bop = bindingOps.get(i);
			
			// �������������
			System.out.println("operationName: "+ ((javax.wsdl.BindingOperation) bop).getName());
			
			// ��ȡ���������롰���֡� ����Ϣ�� ����Ϣ�ġ�
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
			״̬��Ϣ������ʾ
			if "javax.wsdl.importDocuments" is true, imported WSDL documents will be retrieved and processed
			�����WSDL�ļ����������ʹ���*/
			reader.setFeature("javax.wsdl.verbose",true);  
			reader.setFeature("javax.wsdl.importDocuments",true);
			
			//��ȡ�����definitions���ڵ�
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
	 * ˳�򣺻�ȡ���񡪡���ȡ����Ķ˿ڡ����ٻ�ȡ�˿ڶ�Ӧ�İ󶨡����ٻ�ȡ���еĲ���
	 * @author JiaJingting
	 *
	 */
	private static List getBindingOperations(Map services) {
		List bopL = new ArrayList();
		if(services != null) {
			Iterator servicesIter = services.values().iterator();//iterator����
			
			//���ÿ��WSDL�ἰ�ķ���
			while (servicesIter.hasNext()) {
				Service service = (Service) servicesIter.next();
				
				//getPorts()��Get all the ports defined here.
				Iterator portsIter = service.getPorts().values().iterator();
				
				//���һ�������ṩ��port���ʶ˿�
				while (portsIter.hasNext()) {
					Port port = (Port) portsIter.next();
					
					//Get the binding this port refers to ��ȡ�˶˿���ָ�İ�
					Binding binding = port.getBinding();
					
					//Get all the operation bindings defined here.��ȡ���ﶨ������в�����
					List bindingOperations = binding.getBindingOperations();
					Iterator bOperIter = bindingOperations.iterator();
					
					//���ÿ������
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
		
		// bindingOper.getOperation() ����һ�� ��Ӧ��operation���ɶԸò������в����������Ƽ���Ϣ�Ļ�ȡ
		Input input = (Input) bindingOper.getOperation().getInput();
		System.out.println("===========================================================");
		
		// ��� ��������������ơ�
		System.out.println("	inputName: " + input.getName());
		
		// ��� �������������Ϣ�ľֲ����ơ�
		String message = input.getMessage().getQName().getLocalPart();
		System.out.println("	inputMessage: " + message);
		
		//����message��ǩ�е�part��ǩ���н���
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
