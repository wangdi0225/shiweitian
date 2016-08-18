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

import com.wangdi.shiweitian.product.Httptype;

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
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;


public class ForgetpasswordActivity	extends Activity {
		TextView back,promptone;
		EditText phonenumb,code;
		Button getsms,next;
		boolean check;
		
		private static String APPKEY="15e33a34bd368";
		private static String APPSECRET="fcabe53739edca54187d1604b186fbdf";
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_forgetpassword);
			back=(TextView) findViewById(R.id.back);
			phonenumb=(EditText) findViewById(R.id.phonenumb);
			promptone=(TextView) findViewById(R.id.promptsone);
			code=(EditText) findViewById(R.id.code);
			getsms=(Button) findViewById(R.id.getSMS);
			next=(Button) findViewById(R.id.next);
			
			back.setOnClickListener(onClickListener);
			getsms.setOnClickListener(onClickListener);
			next.setOnClickListener(onClickListener);
			
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
		
		OnClickListener onClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.back:
					back();
					break;
				case R.id.getSMS:
					read(phonenumb.getText().toString());
				
					break;
				case R.id.next:
					if(check){
					SMSSDK.submitVerificationCode("86", phString, code.getText().toString());
					}else{
						Toast.makeText(ForgetpasswordActivity.this, "请获取验证码", Toast.LENGTH_SHORT).show();
					}
					break;

				default:
					break;
				}
			}
		};
		//下一步页面跳转方法
		public void next(){
			phString=phonenumb.getText().toString();
			Intent intent= new Intent();
				intent.putExtra("phonenumb", phString);
				intent.setClass(ForgetpasswordActivity.this, ChangepasswordActivity.class);
				startActivity(intent);
				finish();
		}
		
	
		//返回方法
		public void back(){
			Intent intent= new Intent();
			intent.setClass(ForgetpasswordActivity.this, LoginActivity.class);
			startActivity(intent);
			finish();
		}
		
		//发送短信
		String phString;
		public void getsms(String str){
				SMSSDK.getVerificationCode("86",str);
				phString=str;
				
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
								next();
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
						Toast.makeText(ForgetpasswordActivity.this, des, Toast.LENGTH_SHORT).show();
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
		
		
		
		String str1;
		public void read(final String username) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					Httptype httptype = new Httptype();
					str1=httptype.read(username);
					phoneHandler.sendEmptyMessage(0);
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
	    			promptone.setText(" ");
	    			check=true;
	    			getsms(phonenumb.getText().toString());
	    			}else{
	    			promptone.setText("没有该账号");
	    			}
	    			
	    		} catch (JSONException e) {
	    			// TODO 自动生成的 catch 块
	    			e.printStackTrace();
	    		}
	            
	        }   
	   };
		
		
	
		
		
}
