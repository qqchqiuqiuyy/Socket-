package cn.bb.fileUpload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8777);
		
		File file = new File("D://a.txt");
		OutputStream outputStream = socket.getOutputStream();
		FileReader f = new FileReader(file);
		BufferedReader reader = new BufferedReader(f);
		String string = null;
		StringBuffer stringBuffer = new StringBuffer();
		while((string = reader.readLine() ) != null){
			stringBuffer.append(string);
		}
		PrintWriter printWriter = new PrintWriter(outputStream);
		printWriter.write(stringBuffer.toString());
		printWriter.flush();
		
		
		printWriter.close();
		outputStream.close();
		socket.close();
		
	}
}
