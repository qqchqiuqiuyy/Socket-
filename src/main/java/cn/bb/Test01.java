package cn.bb;

import java.net.InetAddress;
import java.net.UnknownHostException;
/*
 * InetAddress shi yong
 */
public class Test01 {
	public static void main(String[] args) throws UnknownHostException {
		//get InetAddress实例
		InetAddress address = InetAddress.getLocalHost(); 
		System.err.println("直接获取local: "+address);
		
		InetAddress inetAddress2 = InetAddress.getByName("Bobo");
		System.out.println("通过主机名获取: "+inetAddress2.getHostName()+inetAddress2.getHostAddress());
		
		InetAddress addressByIp = InetAddress.getByName("10.30.14.60");
		System.err.println("通过IP地址获取:"+addressByIp);
	}
}
