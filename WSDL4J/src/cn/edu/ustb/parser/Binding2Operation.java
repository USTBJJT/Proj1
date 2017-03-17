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
		
		// ��ȡ�󶨱�ǩ�е����в�������ȡ��Ӧ�����ṩ�Ĳ�����
		List bindingOps = getBindingOperations(services);
				
		// ���ÿ������
		for(int i = 0; i < bindingOps.size(); i++) {
			Object bop = bindingOps.get(i);
			WsdlReader11 wr = new WsdlReader11();
			
			//��������
			WsdlOperationFormat opFormat = wr.getTestCase("E://ExFile//ATM.wsdl", bop);
			Object[] opPremAry = opFormat.getInput().format.getSimpleTypes().keySet().toArray();
			String[] opPremClassAry = new String[opPremAry.length];
			for (int j = 0; j < opPremAry.length; ++j) {
				System.out.println(opPremClassAry[j]);
			}
			
//			// �������������
//			System.out.println("		#<Op> Operation Name: "+ ((javax.wsdl.BindingOperation) bop).getName());
//			String soapAction = ((javax.wsdl.BindingOperation) bop).getExtensibilityElements().get(0).toString();
//			System.out.println("		#<Op> Operation soapAction: " + soapAction.substring(soapAction.indexOf("soapAction")));
//			// ��ȡ���������롰���֡� ����Ϣ�� ����Ϣ�ġ�
//			Operation2Message.O2MInterface((javax.wsdl.BindingOperation) bop);
		}
		
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
				System.out.println("#<S> Service name: " + service.getQName());
				//getPorts()��Get all the ports defined here.
				
				Iterator portsIter = service.getPorts().values().iterator();
				
				//���һ�������ṩ��port���ʶ˿�
				while (portsIter.hasNext()) {
					Port port = (Port) portsIter.next();
					
					System.out.println("	#<P> Port name: " + port.getName());
					
					String Location = port.getExtensibilityElements().get(0).toString();
					System.out.println("	#<P> Port Location: " + Location.substring(Location.indexOf("locationURI")));
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
	
	

}
