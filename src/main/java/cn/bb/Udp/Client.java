package cn.bb.Udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class Client {
	public static void main(String[] args) throws Exception {
		//定义服务器的地址,端口号,数据
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "用户名: admin; 密码:1213".getBytes();
		//创建数据报,包含发送数据信息
		DatagramPacket packet = new DatagramPacket(data, data.length,address,port);
		
		//创建DatagramSocket对象
		DatagramSocket socket = new DatagramSocket();
		
		//想服务器发送数据报
		socket.send(packet);
		
		/*
		 * 接受服务器端响应数据
		 */
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		//接受服务器响应数据
		socket.receive(packet2);
		//读取数据
		String reply = new String(data2, 0, packet2.getLength());
		
		System.err.println("我是客户端,服务器说: "+reply);
		//关闭
		socket.close();
	}
}
