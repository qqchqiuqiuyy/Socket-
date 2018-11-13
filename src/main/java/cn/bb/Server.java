package cn.bb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/*
 * 基于TCP 的socket通信 实现用户登陆
 */
public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			
			//1.创建服务器socket即ServerSocket, 指定端口并监听
			serverSocket = new ServerSocket(8888);
			//记录客户端数量
			int count = 0;
			System.err.println("***服务器即将启动,等待客户端连接***");
			while(true){
				//2.调用accept()方法监听,等待客户端连接
				socket = serverSocket.accept();
				//创建新线程
				ServerThread serverThread = new ServerThread(socket);
				//启动线程
				serverThread.run();
				
				count++;
				System.out.println("客户端数量: "+count);
				InetAddress address = socket.getInetAddress();
				System.err.println("当前客户端IP:" +address);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
