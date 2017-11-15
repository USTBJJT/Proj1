package cn.edu.ustb.cbwstc.analysis;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class FindIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10.10.10.116 是否属于固定格式的IP段10.10.1.00-10.10.255.255
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ip);
        String ipSection="202.203.62.0-202.203.62.255";

       boolean exists=ipExistsInRange(ip,ipSection);

        System.out.println(exists);
	}
	
	public static boolean ipExistsInRange(String ip,String ipSection) {

        ipSection = ipSection.trim();

        ip = ip.trim();

       int idx = ipSection.indexOf('-');

        String beginIP = ipSection.substring(0, idx);

        String endIP = ipSection.substring(idx + 1);

       return getIp2long(beginIP)<=getIp2long(ip) &&getIp2long(ip)<=getIp2long(endIP);

    }
	
	public static long getIp2long(String ip) {

        ip = ip.trim();

        String[] ips = ip.split("\\.");

       long ip2long = 0L;

       for (int i = 0; i < 4; ++i) {

            ip2long = ip2long << 8 | Integer.parseInt(ips[i]);

        }

       return ip2long;

    }

}
