package com.wangdi.shiweitian;

import org.json.JSONObject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;

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


public class ForgetpasswordActivity	extends Activity {
		TextView back;
		EditText phonenumb,code;
		Button getsms,next;
		
		private static String APPKEY="15e33a34bd368";
		private static String APPSECRET="fcabe53739edca54187d1604b186fbdf";
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_forgetpassword);
			back=(TextView) findViewById(R.id.back);
			phonenumb=(EditText) findViewById(R.id.phonenumb);
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
					getsms(phonenumb.getText().toString());
					break;
				case R.id.next:
					SMSSDK.submitVerificationCode("86", phString, code.getText().toString());
					
					break;

				default:
					break;
				}
			}
		};
		//下一步页面跳转方法
		public void next(){
			Intent intent= new Intent();
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
			if(isMobileNO(str)){
				if(judge(str)){
				SMSSDK.getVerificationCode("86",str);
				phString=str;
				}
			}else{
				Toast.makeText(ForgetpasswordActivity.this, "输入的电话号码格式错误",Toast.LENGTH_SHORT).show();
				
			}
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
		
		
		
	
		
		
		/** 
		 * 验证手机格式 
		 */  
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
		
		///判断手机号是否为已注册用户方法
		public boolean judge(String str){
			return true;
			
		}
		
		
}
