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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;


public class RegisterActivity extends Activity {
		TextView back,prompt;
		Button getSMS,register;
		CheckBox checkbox;
		EditText phonenumb,sms;
		private boolean check;
		private boolean checkphone=false;
		private static String APPKEY="15e33a34bd368";
		private static String APPSECRET="fcabe53739edca54187d1604b186fbdf";
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_register);
			back=(TextView) findViewById(R.id.back);
			getSMS=(Button) findViewById(R.id.getSMS);
			register=(Button) findViewById(R.id.register);
			prompt=(TextView) findViewById(R.id.prompt);
			checkbox=(CheckBox) findViewById(R.id.register_checkbox);
			phonenumb=(EditText) findViewById(R.id.phonenumb);
			sms=(EditText) findViewById(R.id.sms);
			getSMS.setOnClickListener(onClickListener);
			register.setOnClickListener(onClickListener);
			back.setOnClickListener(onClickListener);
			checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub	
					check=isChecked;
				}
			});
			SMSSDK.initSDK(this,APPKEY,APPSECRET,false);
			EventHandler eh=new EventHandler(){
				
				@Override
				public void afterEvent(int event, int result, Object data) {
					Message msg = new Message();
					msg.arg1 = event;
					msg.arg2 = result;
					msg.obj = data;
					mHandler.sendMessage(msg);
				}
				
			};
			SMSSDK.registerEventHandler(eh);
		}
		
		//监听
		
		
		
		OnClickListener onClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.back:
					Intent intent =new Intent();
					intent.setClass(RegisterActivity.this, LoginActivity.class);
					startActivity(intent);
					finish();
					break;
				case R.id.getSMS:
					read(phonenumb.getText().toString());
					if(checkphone){
						getSMS(phonenumb.getText().toString());	
					}
					
					break;
				case R.id.register:
					saveuser();
					
					break;

				default:
					break;
				}
			}
		};
		
		
		//获取验证码方法
		private String phString;
		public void getSMS(String str){
			if(isMobileNO(str)){
					SMSSDK.getVerificationCode("86",str);   
					//SMSSDK.getVoiceVerifyCode("86",phonEditText.getText().toString());
					phString=str;
				
			}else{
				Toast.makeText(RegisterActivity.this, "请填写正确的手机号", Toast.LENGTH_LONG).show();
			}
			
		}
		//判断验证码是否正确,用户协议是否打钩方法
		public void saveuser(){
			if(check){
					SMSSDK.submitVerificationCode("86", phString, sms.getText().toString());
					
				}else{
				Toast.makeText(this, "请阅读用户协议", Toast.LENGTH_SHORT).show();}
		}
		
		
		Handler mHandler = new Handler()
		{
			public void handleMessage(Message msg) {

				// TODO Auto-generated method stub
				super.handleMessage(msg);
				int event = msg.arg1;
				int result = msg.arg2;
				Object data = msg.obj;
				Log.e("event", "event="+event);
//				System.out.println("--------result---0"+event+"--------*"+result+"--------"+data);
				
				if (result == SMSSDK.RESULT_COMPLETE) {
					if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
					        	Toast.makeText(getApplicationContext(), "发送验证码成功", Toast.LENGTH_SHORT).show();
					}else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {//提交验证码成功
								Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
								write(phString);
								go_user();
								
					} 
			} else {
				int status = 0;	
				try {
					((Throwable) data).printStackTrace();
					Throwable throwable = (Throwable) data;
					JSONObject object = new JSONObject(throwable.getMessage());
					String des = object.optString("detail");
					status = object.optInt("status");
					if (!TextUtils.isEmpty(des)) {
						Toast.makeText(RegisterActivity.this, des, Toast.LENGTH_SHORT).show();
						return;
					}
				} catch (Exception e) {
					SMSLog.getInstance().w(e);
				}
		}
			
			};
		};
		protected void onDestroy() {
			super.onDestroy();
			SMSSDK.unregisterAllEventHandler();
		};
		
		
		
		
		
		//验证手机号是否正确的方法
		public static boolean isMobileNO(String mobiles) {  
		    /* 
		    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188 
		    联通：130、131、132、152、155、156、185、186 
		    电信：133、153、180、189、（1349卫通） 
		    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9 
		    */  
		 String telRegex = "[1][3578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。  
		 if (TextUtils.isEmpty(mobiles)) {//如果该参数为空或""
			 return false;  }
		  else {
			  return mobiles.matches(telRegex); 
		  } 
		  }
		
		//写入用户数据方法
		public void go_user(){
			Intent intent =new Intent();
			intent.setClass(RegisterActivity.this, LoginActivity.class);
			startActivity(intent);
			finish();
			
		}
		//判断数据是否已存在
		String str1;
		public void read(final String username) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					
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
						str1 = builder.toString();
						phoneHandler.sendEmptyMessage(0);
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
		Handler phoneHandler = new Handler() {  
	        public void handleMessage(Message msg) {   
	        	try {
	    			JSONObject jsonObject = new JSONObject(str1);
	    			int status = jsonObject.getInt("status");
	    			String message = jsonObject.getString("message");
	    			if(status==2){
	    			prompt.setText("该手机已注册");
	    			}else{
	    			prompt.setText(" ");
	    			checkphone=true;
	    			}
	    			
	    		} catch (JSONException e) {
	    			// TODO 自动生成的 catch 块
	    			e.printStackTrace();
	    		}
	            
	        }   
	   };
	
		
		//服务器写入数据
	 
		public void write(final String username) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					
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
				
			
			}).start();
		}
		
		
		
		
}
