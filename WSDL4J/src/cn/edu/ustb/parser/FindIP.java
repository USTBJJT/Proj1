package cn.edu.ustb.parser;

import java.net.InetAddress;

public class FindIP {
	
	public void findmyIP() {
		InetAddress ia=null;
        try {
            ia=InetAddress.getLocalHost();
            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("���������ǣ�"+ localname);
            System.out.println("������ip�� ��"+localip);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
