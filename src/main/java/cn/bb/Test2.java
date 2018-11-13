package cn.bb;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
/*
 * URL shiyong
 */
public class Test2 {
	public static void main(String[] args) throws UnknownHostException {
		try {
			URL imooc = new URL("http://www.imooc.com");
			URL url = new URL(imooc,"/index.html?username=tom#test");
			System.out.println("协议: "+url.getProtocol());
			System.out.println("主机: "+url.getHost());
			System.out.println("端口: " +url.getPort());
			System.out.println("文件路径: "+url.getPath());
			System.out.println("file name: "+ url.getFile());
			System.out.println("xiang dui lujing: " +url.getRef());
			System.out.println("canshu:  "+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
