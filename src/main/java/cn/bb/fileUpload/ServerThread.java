package cn.bb.fileUpload;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{

	private Socket socket = null;
	public  ServerThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			InputStream ipStream= socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(ipStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			byte[] bs = new byte[1024];
			String string= null;
			while((string = bufferedReader.readLine()) != null){
				System.err.println(string);
			}
			
			

			ipStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
