package cn.edu.ustb.cbwstc.wsdl.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import javax.wsdl.Fault;
import javax.wsdl.Input;
import javax.wsdl.Output;
import javax.wsdl.Part;
import javax.wsdl.Port;
import javax.wsdl.Service;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

import org.apache.xmlbeans.SchemaType;

import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;

import cn.edu.ustb.cbwstc.tcg.SampleSoapBuilder;
import cn.edu.ustb.cbwstc.tcg.TestFrame;
import cn.edu.ustb.cbwstc.tcg.XmlInputFormat;


public class ReadWsdl {
	
	private String strb = "";
	private ArrayList<String> arr = new ArrayList<String>();
	private List<BindingOperation> bindingOps = new ArrayList<BindingOperation>();
	private Map<String,XmlInputFormat> mapXI = new HashMap<String, XmlInputFormat>();
	private String WsdlURI = "";
	private String panelResult = "";
	
	public ReadWsdl(String name) {
		this.WsdlURI = name;
	}
	
	public void DefInterface(String name) {
		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/Parser/result.txt");
		Definition mydef = readWsdl10();
//		Map<?,?> ns = mydef.getNamespaces();
//		for(Map.Entry<?, ?> entry : ns.entrySet()) {
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//			
//		}
		//System.out.println(mydef.getTypes().getExtensibilityElements());
		Map<?, ?> services = mydef.getServices();
		B2OInterface(services);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(strb);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0;i<arr.size();i++) {
			//TODO ����xml��������ģʽ������
			TestFrame.generTestF(WsdlURI, arr.get(i).split("#")[0], arr.get(i).split("#")[1], name);
		}
	}
	
	/**
	 * A real WSDL Reader for WSDL1.1
	 * @author JiaJingting
	 *
	 */
	public Definition readWsdl10() {
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
			Definition def=reader.readWSDL(WsdlURI);
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
		private  List<BindingOperation> getBindingOperations(Map<?, ?> services) {
			List<BindingOperation> bopL = new ArrayList<BindingOperation>();
			if(services != null) {
				Iterator<?> servicesIter = services.values().iterator();//iterator����
				//���ÿ��WSDL�ἰ�ķ���
				while (servicesIter.hasNext()) {
					Service service = (Service) servicesIter.next();
					String Documentation = "NullDocumentation";
					if(service.getDocumentationElement() != null){
						Documentation = service.getDocumentationElement().getTextContent();
					}
					strb = strb + service.getQName().getLocalPart() + "#" + Documentation + System.getProperty("line.separator");
					panelResult = panelResult + "#<S> Service name: " + service.getQName() + "\n";
	//				System.out.println("#<S> Service name: " + service.getQName());
	//				System.out.println("#<S> Service documentation: " + service.getDocumentationElement().getTextContent());
					//getPorts()��Get all the ports defined here.
					Iterator<?> portsIter = service.getPorts().values().iterator();
					//���һ�������ṩ��port���ʶ˿�
					while (portsIter.hasNext()) {
						Port port = (Port) portsIter.next();
						panelResult = panelResult + "  #<P> Port name: " + port.getName() + "\n";
						//System.out.println("	#<P> Port name: " + port.getName());
						//String Location = port.getExtensibilityElements().get(0).toString();
						//System.out.println("	#<P> Port Location: " + Location.substring(Location.indexOf("locationURI")));
						//Get the binding this port refers to ��ȡ�˶˿���ָ�İ�
						Binding binding = port.getBinding();
						
						//Get all the operation bindings defined here.��ȡ���ﶨ������в�����
						List<?> bindingOperations = binding.getBindingOperations();
						Iterator<?> bOperIter = bindingOperations.iterator();
						
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

	public void B2OInterface(Map<?, ?> services) {
		
		// ��ȡ�󶨱�ǩ�е����в�������ȡ��Ӧ�����ṩ�Ĳ�����
		bindingOps = getBindingOperations(services);
		// ���ÿ������
		for(int i = 0; i < bindingOps.size(); i++) {
			Object bop = bindingOps.get(i);
			// �������������
//			System.out.println("		#<Op> Operation Name: "+ ((javax.wsdl.BindingOperation) bop).getName());
//			String soapAction = ((javax.wsdl.BindingOperation) bop).getExtensibilityElements().get(0).toString();
			//���HttpEndpoint,�޷���ȡsoapAction����Ϊ�ò���ͨ��post����û��soapAction��ֻ��Location
//			System.out.println("		#<Op> Operation soapAction: " + soapAction.substring(soapAction.indexOf("soapAction")));
			// ��ȡ���������롰���֡� ����Ϣ�� ����Ϣ�ġ�
			O2MInterface((javax.wsdl.BindingOperation) bop);
			getXmlInputFormat((javax.wsdl.BindingOperation) bop);
		}
		
	}
	
	public void O2MInterface(BindingOperation bindingOper) {
		//arr.add(bindingOper.getOperation().getName());
		strb = strb + bindingOper.getOperation().getName() + "#";
		panelResult = panelResult + "    #<Op> Operation name: " + bindingOper.getOperation().getName() + "\n";
		//System.out.println(bindingOper.getOperation().getName());
		//System.out.println(bindingOper.getOperation().getDocumentationElement().getTextContent());
		getOperationInput(bindingOper);
		getOperationOutput(bindingOper);
		String Documentation = "NullDocumentation";
		if(bindingOper.getOperation().getDocumentationElement() != null) {
			Documentation = bindingOper.getOperation().getDocumentationElement().getTextContent().trim();
		}
		strb = strb + Documentation + System.getProperty("line.separator");
		//getOperationFault(bindingOper);
	}
	
	/**
	 * This interface represents a WSDL operation. 
	 * It includes information on input (the name/Message of the input) associated with usage of the operation.
	 * @author JiaJingting
	 *
	 */
	private void getOperationInput(BindingOperation bindingOper) {
		// bindingOper.getOperation() ����һ�� ��Ӧ��operation���ɶԸò������в����������Ƽ���Ϣ�Ļ�ȡ
		String OperationName = bindingOper.getOperation().getName();
		Input input = (Input) bindingOper.getOperation().getInput();
		panelResult = panelResult + "      #<IN> Input Name: " + input.getName() + "\n";
		panelResult = panelResult + "      #<IN> Input Message: " + input.getMessage().getQName().getLocalPart() + "\n";
		// ��� ��������������ơ�
		//System.out.println("			#<IN> Input Name: " + input.getName());
		// ��� �������������Ϣ�ľֲ����ơ�
		//String message = input.getMessage().getQName().getLocalPart();
		//System.out.println("			#<IN> Input Message: " + message);
		//����message��ǩ�е�part��ǩ���н���
		//System.out.println("				#<MS> Message name: " + input.getMessage().getQName().getLocalPart());
		getMessagePartElementName(OperationName,input.getMessage().getParts(),true);
		
	}
	
	
	
	/**
	 * This interface represents a WSDL operation. 
	 * It includes information on output (the name/Message of the input) associated with usage of the operation.
	 * @author JiaJingting
	 *
	 */
	private void getOperationOutput(BindingOperation bindingOper) {
		
		// bindingOper.getOperation() ����һ�� ��Ӧ��operation���ɶԸò������в����������Ƽ���Ϣ�Ļ�ȡ
		String OperationName = bindingOper.getOperation().getName();
		Output output = (Output) bindingOper.getOperation().getOutput();
		panelResult = panelResult + "      #<OUT> Output Name: " + output.getName() + "\n";
		panelResult = panelResult + "      #<OUT> Output Message: " + output.getMessage().getQName().getLocalPart() + "\n";
		// ��� ��������������ơ�
		//System.out.println("			#<OUT> Output Name: " + output.getName());
		// ��� �������������Ϣ�ľֲ����ơ�
		//String message = output.getMessage().getQName().getLocalPart();
		//System.out.println("			#<OUT> Output Message: " + message);
		//����message��ǩ�е�part��ǩ���н���
		//System.out.println("				#<MS> Message name: " + output.getMessage().getQName());
		getMessagePartElementName(OperationName,output.getMessage().getParts(),false);
		
	}
	
	@SuppressWarnings("unused")
	private  void getOperationFault(BindingOperation bindingOper) {
		Map<?, ?> mapf = bindingOper.getOperation().getFaults();
		Iterator<?> fIter = mapf.values().iterator();
		while (fIter.hasNext()) {
			Fault fault = (Fault) fIter.next();
			System.out.println("			#<F> Fault Name: " + fault.getName());
			System.out.println("			#<F> Fault Message: " + fault.getMessage().getQName().getLocalPart());
			System.out.println("				#<MS> Message name: " + fault.getMessage().getQName());
			//Message2Part.M2PInterface(fault.getMessage().getParts());
		}
	}
	
	
	/**
	 * This interface represents a WSDL message (input/output/fault) about a operation.
	 * ��Ϣ��
	 * @param ĳ���ض�������Ӧ��(input/output/fault)�ض���Ϣ������part��ǩ
	 * @return part��Ӧ��Element��Name�б�
	 * the element of the Message (input/output/fault) associated with usage of the operation.
	 * @author JiaJingting
	 *
	 */
	public void getMessagePartElementName(String OperationName,Map<?, ?> map, boolean flag) {
		
		Iterator<?> partIter = map.values().iterator();
		while(partIter.hasNext())
	    {
			Part part= (Part) partIter.next();
			panelResult = panelResult + "	#<MS> part name: " + part.getName() + "\n";
			panelResult = panelResult + "	#<MS> part element: " + part.getElementName().getLocalPart() + "\n";
			//System.out.println("				#<MS> part name: " + part.getName());
			//System.out.println("				#<MS> part element: " + part.getElementName().getLocalPart());
			if(flag) {
//				GetXML.myJtry(part);
				arr.add(OperationName + "#" + part.getElementName().getLocalPart());
			}
			
			strb = strb + part.getElementName().getLocalPart() + "#";
//			System.out.println("************ " + part.getElementName().getPrefix());
//			System.out.println("************ " + part.getElementName().getNamespaceURI());
//			System.out.println("************ " + part.getElementName().getLocalPart());
			
	    }
		
	}
	
	/**
	 * ����ʹ�ò�ͬ��WsdlURI�ˣ�������Ӧ��ͬ��XSD�����������ɲ�ͬ��������
	 * @param WsdlURI
	 * @param bop
	 * @return
	 */
	public XmlInputFormat getInputFormat(String WsdlURI, BindingOperation bop) {
		SampleSoapBuilder builder = new SampleSoapBuilder(new WsdlContext(
				WsdlURI));
		String soapRequest = null;
		try {
			soapRequest = builder.buildSoapMessageFromInput(bop, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XmlInputFormat xmlInputFormat = new XmlInputFormat(soapRequest,builder.getFormat());
		return xmlInputFormat;
	}
	
	public List<BindingOperation> getBindingOps(){
		List<BindingOperation> Ops = bindingOps;
		return Ops;
	}
	
	public void getXmlInputFormat(BindingOperation bop) {
			XmlInputFormat InP = getInputFormat(WsdlURI, bop);
			@SuppressWarnings("unused")
			Map<String, SchemaType> map = InP.format.simpleTypes;
			mapXI.put(bop.getOperation().getName(), InP);
	}
	
	public Map<String,XmlInputFormat> getXmlInputFormatMap() {
		return mapXI;
	}
	
	public String getpanelResult() {
		return panelResult;
	}
	
	public List<BindingOperation> getBindingOperation() {
		return bindingOps;
	}
	
	public ArrayList<String> getOpNameInputName(){
		return arr;
	}

}
