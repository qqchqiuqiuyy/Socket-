package cn.bb.fast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
// buff flush 循环外面 350ms
// fileinoutstream 32585
//DataInputstream 35000
public class upload {
	public static void main(String[] args) throws Exception{
		
	
	}
	
	public void uploadByDataStream(String path,String end)throws IOException{
		
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File(path )));
		DataOutputStream dataOutputStream= new DataOutputStream(new FileOutputStream(new File(end)));
		int n;
		Long start = System.currentTimeMillis();
		while((n = dataInputStream.read()) != -1){
			dataOutputStream.write(n);    
			
		}
		Long endT = System.currentTimeMillis();
		System.err.println(endT - start);
		dataInputStream.close();
		dataOutputStream.close();
	}
		public void uploadByFileStream(String path,String end)throws IOException{
		
		FileInputStream fileInputStream = new FileInputStream(new File(path ));
		FileOutputStream fileOutputStream= new FileOutputStream(new File(end));
		int n;
		Long start = System.currentTimeMillis();
		while((n = fileInputStream.read()) != -1){
			fileOutputStream.write(n);    
			
		}
		Long endT = System.currentTimeMillis();
		System.err.println(endT - start);
		fileOutputStream.close();
		fileOutputStream.close();
	}
		
		public void uploadByBufferStream(String path,String end)throws IOException{
			
			FileInputStream fileInputStream = new FileInputStream(new File(path ));
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			
			FileOutputStream fileOutputStream= new FileOutputStream(new File(end));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			int n;
			Long start = System.currentTimeMillis();
			while((n = bufferedInputStream.read()) != -1){
				bufferedOutputStream.write(n);    
				
			}
			//放在循环外面 里面效率最慢
			bufferedOutputStream.flush();
			
			Long endT = System.currentTimeMillis();
			System.err.println(endT - start);
			bufferedInputStream.close();
			bufferedOutputStream.close();
		}
	
	
	
}
