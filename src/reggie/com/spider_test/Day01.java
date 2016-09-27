package reggie.com.spider_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Day01 {

	static Day01 d = new Day01();
	static String path = "http://www.chanpin100.com/";

	public static void main(String[] args) {
		//d.testURL(path);
		d.testHttpClient(path);
	}

	public void testURL(String path) {
		try {
			// 构造URL对象
			URL pageURL = new URL(path);
			// 通过URL对象来取得网络流
			InputStream is = pageURL.openStream();
			// 读取网络流并转化为BufferedReader，利用BufferedReader的readLine()方法读取网页内容
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");// 处理中文乱码问题
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
	
	public void testHttpClient(String path){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//得到get方法
		HttpGet httpget = new HttpGet(path);
		try {
			CloseableHttpResponse httpresponse = httpclient.execute(httpget);
			HttpEntity entity=httpresponse.getEntity();
			if(entity!=null){
				String htmlContent=EntityUtils.toString(entity,Consts.UTF_8);
				System.out.println(htmlContent);
			}
			//释放
			httpget.releaseConnection();
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
