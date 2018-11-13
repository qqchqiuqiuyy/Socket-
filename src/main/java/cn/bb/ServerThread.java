package cn.bb;
/*
 * 服务器端线程处理类
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	//和本线程相关的socket
	Socket socket = null;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		InputStream iStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		OutputStream outputStream = null;
		PrintWriter pWriter = null;
		try {
			//3.获取输入流,并读取客户端信息
			iStream = socket.getInputStream();
			//字节流包装成字符流
			inputStreamReader = new InputStreamReader(iStream);
			//添加缓冲
			bufferedReader = new BufferedReader(inputStreamReader);
			String info = null;
			while ((info = bufferedReader.readLine()) != null) {
				System.err.println("我是服务器,客户端说:" + info);
			}
			//关闭输入流
			socket.shutdownInput();
			//4.获取输出流 响应客户端请求
			outputStream = socket.getOutputStream();
			pWriter = new PrintWriter(outputStream);//包装成打印流
			pWriter.write("欢饮您");
			pWriter.flush();
			
			//5.关闭
			pWriter.close();
			outputStream.close();
			bufferedReader.close();
			inputStreamReader.close();
			iStream.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}
