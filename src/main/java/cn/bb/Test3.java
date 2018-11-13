package cn.bb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
/*
 * URL 读取页面
 */
public class Test3 {
	public static void main(String[] args) throws UnknownHostException {
		try {
			URL imooc = new URL("http://www.baidu.com");
			URL url = new URL(imooc,"/index.html?username=tom#test");
			InputStream inputStream = url.openStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bReader = new BufferedReader(inputStreamReader);
			String data = bReader.readLine();
			while(data!=null){
				System.err.println(data);
				data = bReader.readLine();
			}
			bReader.close();
			inputStreamReader.close();
			inputStream.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
