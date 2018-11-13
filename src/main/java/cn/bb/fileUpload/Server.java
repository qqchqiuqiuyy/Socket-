package cn.bb.fileUpload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(8777);
		int cout = 0;
		while(true){
			Socket socket = serverSocket.accept();
			cout++;
			System.err.println("服务端启动 当前 : " + cout + " 个client");
			ServerThread serverThread = new ServerThread(socket);
			serverThread.run();
		}
		
	}

}
