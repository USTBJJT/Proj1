package cn.edu.ustb.parser;

import java.util.Calendar;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class SoapSend {
	
	//向目标发送消息
		public synchronized static OMElement sendmessage(int airClass, int area, boolean isStudent, double luggage, double economicfee) throws Exception
		{
			/*send message process*/
			OMElement res=null;
			 try {  
	             ServiceClient sc = new ServiceClient();  
	             Options opts = new Options();  
	             //确定目标服务地址  
	             //soap:address location
	             opts.setTo(new EndpointReference(  
	                     "http://localhost:8080/ABBSDome0/services/AirlinesBaggageBillingService")); //http://localhost:8080/ode/processes/myairprocess 
	             //确定调用方法  
	             //soap:operation soapAction
	             opts.setAction("http://abbs.simple.ws/feeCalculation"); //http://www.ustb.edu.cn/bpel/process 
	             sc.setOptions(opts);  
	             //发送请求并并得到返回结果，注意参数生成方法的分析
	             long startTime = Calendar.getInstance().getTimeInMillis();
	              res = sc.sendReceive(createPayLoad(airClass,area,isStudent,luggage,economicfee));  
	             long endTime = Calendar.getInstance().getTimeInMillis();
	             System.out.println(airClass + "&&" + area + "&&" + isStudent + "&&" + luggage + "&&" + economicfee);
	            System.out.println("响应的信息："+ res);
	            // System.out.println("引擎的执行时间(ms):"+(endTime-startTime));
	             
	         } catch (AxisFault e) {  
	             e.printStackTrace();
	         }
			 
	        return res;
		}
		
		//创建SOAP消息
		//PayLoad 
		 public static OMElement createPayLoad(int parameter1,int parameter2,boolean parameter3,double parameter4,double parameter5){   
		        OMFactory fac = OMAbstractFactory.getOMFactory();  
		        //指定命名空间 
		        //String tns  = www.ustb.edu.cn/bpel/travelagency;
		        OMNamespace omNs = fac.createOMNamespace("http://abbs.simple.ws", "ustb"); //tns
		        OMNamespace omNs1 = fac.createOMNamespace("http://abbs.simple.ws", "ustb");  //http://www.ustb.edu.cn/bpel
		        //指定参数element 
		        OMElement method = fac.createOMElement("feeCalculation",omNs);  //myairprocessRequest
		        //指定方法的参数  
		        OMElement value1 = fac.createOMElement("chooseAirClass",omNs1);  
		        OMElement value2 = fac.createOMElement("chooseArea",omNs1);
		        OMElement value3 = fac.createOMElement("isStudent",omNs1);
		        OMElement value4 = fac.createOMElement("luggage",omNs1);
		        OMElement value5 = fac.createOMElement("economicfee",omNs1);
		        
		        value1.setText(parameter1+""); 
		        value2.setText(parameter2+"");//需要把所有参数转成String形式，因此加入空字符串进行转换“”
		        value3.setText(parameter3+"");
		        value4.setText(parameter4+"");
		        value5.setText(parameter5+"");
		        
		        method.addChild(value1);
		        method.addChild(value2);
		        method.addChild(value3);
		        method.addChild(value4);
		        method.addChild(value5);
		        
		       System.out.println("发送的消息:"+ method);
		        //返回方法（实际上就是OMElement封装的xml字符串）  
		        return method;   
		    } ;
		    public static void main(String args[]) throws Exception{
		    	
		    	sendmessage(0,0,true,35,300);
		    }

}
