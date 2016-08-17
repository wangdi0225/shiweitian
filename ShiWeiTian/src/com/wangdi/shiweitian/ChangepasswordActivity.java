package com.wangdi.shiweitian;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.wangdi.shiweitian.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class ChangepasswordActivity extends Activity{
		TextView back;
		EditText newpassword,passswordsame;
		TextView promptsone,promptstwo;
		Button complete;
		String phonenumb;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_changepassword);
			back=(TextView) findViewById(R.id.back);
			newpassword=(EditText) findViewById(R.id.newpassword);
			passswordsame=(EditText) findViewById(R.id.passwordsame);
			promptsone=(TextView) findViewById(R.id.promptspassword);
			promptstwo=(TextView) findViewById(R.id.promptssame);
			complete=(Button) findViewById(R.id.complete);
			back.setOnClickListener(onClickListener);
			complete.setOnClickListener(onClickListener);
			
			Bundle bundle = this.getIntent().getExtras();  
			phonenumb = bundle.getString("phonenumb");  
			
		}
		OnClickListener onClickListener=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.back:
					back();
					break;
				case R.id.complete:
					complete(newpassword.getText().toString());
					break;
				

				default:
					break;
				}
			}
		};
		//返回方法
		public void back(){
			Intent intent=new Intent();
			intent.setClass(ChangepasswordActivity.this, ForgetpasswordActivity.class);
			startActivity(intent);
			finish();
		}
		//完成方法
		public void complete(String str){
			if(judegpassword(str)){
				if(str.equals(passswordsame.getText().toString())){
					
					change(phonenumb, str);
					Toast.makeText(ChangepasswordActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
					Intent intent=new Intent();
					intent.setClass(ChangepasswordActivity.this, LoginActivity.class);
					startActivity(intent);
					finish();
				}else{
					promptsone.setText(" ");
					promptstwo.setText("两次密码输入不一致");	
					
				}
			}else{
				promptsone.setText("密码请用字母与数字,且大于5位不大于 15位");
			}
		}
	
		//验证密码格式是否正确
		public boolean judegpassword(String password){
			 String format = "^([A-Za-z]|[0-9])+$";//密码格式//字母于数字大小写,
			 if (TextUtils.isEmpty(password)) {//如果该参数为空或""
				 return false;  }
			  else {
				  if(password.length()>5&&password.length()<15){
					  return password.matches(format); 
				  }else{
					  return false;
				  }
			  } 
			   }  
	
		
		
		String str;
		public void change(final String username ,final String password) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					
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
				
			
			}).start();
		}
		
		
		
	
	    
		
		
		
}
