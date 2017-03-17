package cn.edu.ustb.parser;

import java.net.InetAddress;

public class FindIP {
	
	public void findmyIP() {
		InetAddress ia=null;
        try {
            ia=InetAddress.getLocalHost();
            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
