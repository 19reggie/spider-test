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
			// ����URL����
			URL pageURL = new URL(path);
			// ͨ��URL������ȡ��������
			InputStream is = pageURL.openStream();
			// ��ȡ��������ת��ΪBufferedReader������BufferedReader��readLine()������ȡ��ҳ����
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");//����������������
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
