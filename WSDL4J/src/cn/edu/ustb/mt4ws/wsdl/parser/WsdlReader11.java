package cn.edu.ustb.mt4ws.wsdl.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import javax.wsdl.Port;
import javax.wsdl.Service;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

import cn.edu.ustb.mt4ws.tcg.WsdlOperationFormat;
import cn.edu.ustb.mt4ws.tcg.XmlInputFormat;
import cn.edu.ustb.mt4ws.tcg.XmlOutputFormat;

import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;

/**
 * A real WSDL Reader for WSDL1.1
 * @author WangGuan
 *
 */
public class WsdlReader11 extends AbstractWsdlReader {

	private String WsdlURI;
	
	@Override
	public List getBindingOperations(Map services) {
		List bopL = new ArrayList();
		Iterator servicesIter = services.values().iterator();
		while (servicesIter.hasNext()) {
			Service service = (Service) servicesIter.next();
			Iterator portsIter = service.getPorts().values().iterator();
			while (portsIter.hasNext()) {
				Port port = (Port) portsIter.next();
				Binding binding = port.getBinding();
				List bindingOperations = binding.getBindingOperations();
				Iterator bOperIter = bindingOperations.iterator();
				while (bOperIter.hasNext()) {
					BindingOperation bindingOper = (BindingOperation) bOperIter
							.next();
					bopL.add(bindingOper);
				}
			}
		}
		return bopL;
	}

	@Override
	public Map getServices(Object DefOrDesc) {
		Definition def = (Definition) DefOrDesc;
		Map services = def.getServices();
		return services;
	}

	@Override
	public Definition getWsdlDoc(String WsdlURI) {
		WSDLFactory factory;
		this.WsdlURI = WsdlURI;
		try {
			factory = WSDLFactory.newInstance();
			WSDLReader reader = factory.newWSDLReader();
			reader.setFeature("javax.wsdl.verbose", true);
			reader.setFeature("javax.wsdl.importDocuments", true);
			Definition def = reader.readWSDL(WsdlURI);
			return def;
		} catch (WSDLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param WsdlURI
	 * @param bop
	 * @param direct
	 *            true:input; false:output
	 * @return
	 */
	private XmlInputFormat getInputFormat(String WsdlURI, BindingOperation bop) {
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

	private XmlOutputFormat getOutputFormat(String WsdlURI, BindingOperation bop) {
		SampleSoapBuilder builder = new SampleSoapBuilder(new WsdlContext(
				WsdlURI));
		String soapResponse = null;
		try {
			soapResponse = builder.buildSoapMessageFromOutput(bop, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XmlOutputFormat xmlOutputFormat = new XmlOutputFormat(soapResponse,builder.getFormat());
		return xmlOutputFormat;
	}

	@Override
	public WsdlOperationFormat getTestCase(String WsdlURI, Object bop) {
		// TODO
		BindingOperation bindingop = (BindingOperation) bop;

		WsdlOperationFormat opFormat = new WsdlOperationFormat();
		opFormat.build(bindingop.getName());
		opFormat.build(getInputFormat(WsdlURI, bindingop), getOutputFormat(WsdlURI,
				bindingop));
		return opFormat;
	}
}
