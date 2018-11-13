package cn.bb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class Client {
	public static void main(String[] args) {
		
		try {
			//1.创建socket 指定服务器地址和端口号
			Socket socket = new Socket("localhost", 8888);
			//2.获取输出流 
			//字节流
			OutputStream outputStream = socket.getOutputStream();
			//包装成打印流
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.write("用户名: admin;密码: 123");
			printWriter.flush();
			//关闭输出流
			socket.shutdownOutput();
			
			//读取服务端响应 获取输入流
			InputStream inputStream = socket.getInputStream();
			//包装
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String info = null;
			while((info = bufferedReader.readLine()) != null){
				System.err.println("我是客户端,服务端说: "+info);
			}
			//关闭
			bufferedReader.close();
			inputStream.close();
			printWriter.close();
			outputStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
