package cn.edu.ustb.parser;



import java.util.Iterator;
import java.util.Map;

import javax.wsdl.BindingOperation;
import javax.wsdl.Fault;
import javax.wsdl.Input;
import javax.wsdl.Output;


public class Operation2Message {
	
	
	public static void O2MInterface(BindingOperation bindingOper) {
		
		getOperationInput(bindingOper);
		getOperationOutput(bindingOper);
		getOperationFault(bindingOper);
		
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
		
		// ��� ��������������ơ�
		System.out.println("			#<IN> Input Name: " + input.getName());
		
		// ��� �������������Ϣ�ľֲ����ơ�
		String message = input.getMessage().getQName().getLocalPart();
		System.out.println("			#<IN> Input Message: " + message);
		
		//����message��ǩ�е�part��ǩ���н���
		System.out.println("				#<MS> Message name: " + input.getMessage().getQName().getLocalPart());
		Message2Part.M2PInterface(input.getMessage().getParts());
		
	}
	
	
	
	/**
	 * This interface represents a WSDL operation. 
	 * It includes information on output (the name/Message of the input) associated with usage of the operation.
	 * @author JiaJingting
	 *
	 */
	private static void getOperationOutput(BindingOperation bindingOper) {
		
		// bindingOper.getOperation() ����һ�� ��Ӧ��operation���ɶԸò������в����������Ƽ���Ϣ�Ļ�ȡ
		Output output = (Output) bindingOper.getOperation().getOutput();
		
		// ��� ��������������ơ�
		System.out.println("			#<OUT> Output Name: " + output.getName());
		
		// ��� �������������Ϣ�ľֲ����ơ�
		String message = output.getMessage().getQName().getLocalPart();
		System.out.println("			#<OUT> Output Message: " + message);
		
		//����message��ǩ�е�part��ǩ���н���
		System.out.println("				#<MS> Message name: " + output.getMessage().getQName());
		Message2Part.M2PInterface(output.getMessage().getParts());
		
	}
	
	private static void getOperationFault(BindingOperation bindingOper) {
		Map mapf = bindingOper.getOperation().getFaults();
		Iterator fIter = mapf.values().iterator();
		while (fIter.hasNext()) {
			Fault fault = (Fault) fIter.next();
			
			System.out.println("			#<F> Fault Name: " + fault.getName());
			System.out.println("			#<F> Fault Message: " + fault.getMessage().getQName().getLocalPart());
			System.out.println("				#<MS> Message name: " + fault.getMessage().getQName());
			Message2Part.M2PInterface(fault.getMessage().getParts());
			
			
		}
	}
	
	
	

}
