package cn.bb.Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
 public static void main(String[] args) throws IOException {
	//创建服务端DatagramSocket 指定端口
	 DatagramSocket socket = new DatagramSocket(8800);
	 //创建数据报 用于接受客户端发送数据
	 byte[] data = new byte[1024];  //创建字节数组,指定接受的数据包大小
	 DatagramPacket packet = new DatagramPacket(data, data.length);
	 //接受客户端发送数据
	 System.err.println("***服务器启动,等待客户端");
	 socket.receive(packet);//此方法在接受到数据报之前会一直阻塞
	 
	 //读取数据
	 String info = new String(data, 0, packet.getLength());
	 
	 System.err.println("我是服务器,客户端说:"+info);
	 
	 
	 /*
	  * 客户端响应
	  */
	 InetAddress address = packet.getAddress();
	 int port = packet.getPort();
	 byte[] data2 = "欢迎您".getBytes();
	 //创建数据报,包含响应数据信息
	 DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
	 //响应客户端
	 socket.receive(packet2);
	 //关闭资源
	 socket.close();
	 
}
}
