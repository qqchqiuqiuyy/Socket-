package cn.bb.charUpload;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class charUpload {

	public static void main(String[] args) throws IOException{
		String pathname = "D:\\a.txt";
		BufferedReader bufferedReader = new BufferedReader(new  InputStreamReader(new  FileInputStream(new File(pathname))) );
		
		 String target = "D:\\b.txt";
		 
		/* 用PrintWriter比较方便
			BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(target))));
		*/
		
		PrintWriter printWriter = new PrintWriter(new File(target));
		
		String line ;
		while((line = bufferedReader.readLine() ) != null){
			printWriter.write(line);
		}
		printWriter.flush();
		
		printWriter.close();
		bufferedReader.close();
	
	}
	
	
}
