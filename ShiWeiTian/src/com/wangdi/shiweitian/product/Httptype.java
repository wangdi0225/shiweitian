package com.wangdi.shiweitian.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import android.util.Log;
public class Httptype {
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	String str;
public String login(String username,String password){
	
	StringBuilder builder = new StringBuilder();
	try {
		String httpHost = "http://192.168.1.152/index.php/Home/api/login";
		String name = "username="+username+"&password="+password;
		String urlName = httpHost + "?" + name;
		URL url = new URL(urlName);
		HttpURLConnection connection = (HttpURLConnection) url
				.openConnection();
		connection.setConnectTimeout(5000);
		connection.setRequestProperty("accept", "*/*");// 设置客户端接受那些类型的信息，通配符代表接收所有类型的数据
		connection.setRequestProperty("connection", "Keep-Alive");// 保持长链接
		connection
				.setRequestProperty("user-agent",
						"Mozilla/4.0(compatible;MSIE 6.0;Windows NT5.1;SV1)");// 设置浏览器代理
		connection
				.setRequestProperty("accept-charset", "utf-8;GBK");// 客户端接受的字符集
		connection.connect();// 建立连接
		InputStream inputStream = connection.getInputStream();
		Map<String, List<String>> headers = connection
				.getHeaderFields();
		for (String key : headers.keySet()) {
			System.out.println(key + "----" + headers.get(key));

		}
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = bufferedReader.readLine();
		while (line != null && line.length() > 0) {
			builder.append(line);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		inputStream.close();
		Log.i("builder-----", builder.toString());
	
		setStr(builder.toString());
	} catch (MalformedURLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return str;
}

	public void change(String username,String password){
		
		
		StringBuilder builder = new StringBuilder();
		try {
			String httpHost = "http://192.168.1.152/index.php/Home/api/change";
			String name = "username="+username+"&password="+password;
			String urlName = httpHost + "?" + name;
			URL url = new URL(urlName);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(5000);
			connection.setRequestProperty("accept", "*/*");// 设置客户端接受那些类型的信息，通配符代表接收所有类型的数据
			connection.setRequestProperty("connection", "Keep-Alive");// 保持长链接
			connection
					.setRequestProperty("user-agent",
							"Mozilla/4.0(compatible;MSIE 6.0;Windows NT5.1;SV1)");// 设置浏览器代理
			connection
					.setRequestProperty("accept-charset", "utf-8;GBK");// 客户端接受的字符集
			connection.connect();// 建立连接
			InputStream inputStream = connection.getInputStream();
			Map<String, List<String>> headers = connection
					.getHeaderFields();
			for (String key : headers.keySet()) {
				System.out.println(key + "----" + headers.get(key));

			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream));
			String line = bufferedReader.readLine();
			while (line != null && line.length() > 0) {
				builder.append(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStream.close();
			Log.i("builder-----", builder.toString());
			
			
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	} 

	public String read(String username){
		StringBuilder builder = new StringBuilder();
		try {
			String httpHost = "http://192.168.1.152/index.php/Home/api/read";
			String name = "username="+username;
			String urlName = httpHost + "?" + name;
			URL url = new URL(urlName);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(5000);
			connection.setRequestProperty("accept", "*/*");// 设置客户端接受那些类型的信息，通配符代表接收所有类型的数据
			connection.setRequestProperty("connection", "Keep-Alive");// 保持长链接
			connection
					.setRequestProperty("user-agent",
							"Mozilla/4.0(compatible;MSIE 6.0;Windows NT5.1;SV1)");// 设置浏览器代理
			connection
					.setRequestProperty("accept-charset", "utf-8;GBK");// 客户端接受的字符集
			connection.connect();// 建立连接
			InputStream inputStream = connection.getInputStream();
			Map<String, List<String>> headers = connection
					.getHeaderFields();
			for (String key : headers.keySet()) {
				System.out.println(key + "----" + headers.get(key));

			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream));
			String line = bufferedReader.readLine();
			while (line != null && line.length() > 0) {
				builder.append(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStream.close();
			Log.i("builder-----", builder.toString());
			setStr(builder.toString());
			
			} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return str;
	}
	public void write(String username){
		StringBuilder builder = new StringBuilder();
		try {
			String httpHost = "http://192.168.1.152/index.php/Home/api/add";
			String name = "username="+username;
			String urlName = httpHost + "?" + name;
			URL url = new URL(urlName);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(5000);
			connection.setRequestProperty("accept", "*/*");// 设置客户端接受那些类型的信息，通配符代表接收所有类型的数据
			connection.setRequestProperty("connection", "Keep-Alive");// 保持长链接
			connection
					.setRequestProperty("user-agent",
							"Mozilla/4.0(compatible;MSIE 6.0;Windows NT5.1;SV1)");// 设置浏览器代理
			connection
					.setRequestProperty("accept-charset", "utf-8;GBK");// 客户端接受的字符集
			connection.connect();// 建立连接
			InputStream inputStream = connection.getInputStream();
			Map<String, List<String>> headers = connection
					.getHeaderFields();
			for (String key : headers.keySet()) {
				System.out.println(key + "----" + headers.get(key));

			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream));
			String line = bufferedReader.readLine();
			while (line != null && line.length() > 0) {
				builder.append(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStream.close();
			Log.i("builder-----", builder.toString());
			
			
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
