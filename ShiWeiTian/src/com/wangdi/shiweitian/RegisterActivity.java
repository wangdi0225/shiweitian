package com.wangdi.shiweitian;

import java.util.Set;

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


import com.wangdi.shiweitian.R;


public class RegisterActivity extends Activity {
		TextView back;
		Button getSMS,register;
		CheckBox checkbox;
		EditText phonenumb,sms;
		private boolean check;
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
					getSMS(phonenumb.getText().toString());
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
		 String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。  
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
}
