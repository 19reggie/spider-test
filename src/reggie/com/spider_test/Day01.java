package reggie.com.spider_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Day01 {

	public static void main(String[] args) {
		String path = "http://www.chanpin100.com/";
		try {
			// 构造URL对象
			URL pageURL = new URL(path);
			// 通过URL对象来取得网络流
			InputStream is = pageURL.openStream();
			// 读取网络流并转化为BufferedReader，利用BufferedReader的readLine()方法读取网页内容
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");//处理中文乱码问题
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			isr.close();
			is.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
