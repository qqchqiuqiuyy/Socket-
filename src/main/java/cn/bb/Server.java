package cn.bb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/*
 * 基于TCP 的socket通信 实现用户登陆
 */
public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			//1.创建服务器socket即ServerSocket, 指定端口并监听
			serverSocket = new ServerSocket(8888);
			//2.调用accept()方法监听,等待客户端连接
			System.err.println("***服务器即将启动,等待客户端连接***");
			Socket socket = serverSocket.accept();
			//3.获取输入流,并读取客户端信息
			InputStream iStream = socket.getInputStream();
			//字节流包装成字符流
			InputStreamReader inputStreamReader = new InputStreamReader(iStream);
			//添加缓冲
			BufferedReader  bufferedReader = new BufferedReader(inputStreamReader);
			String info = null;
			while((info = bufferedReader.readLine()) != null){
				System.err.println("我是服务器,客户端说:" + info);
			}
			
			//关闭
			socket.close();
			bufferedReader.close();
			inputStreamReader.close();
			iStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
		}
		
	}
}
