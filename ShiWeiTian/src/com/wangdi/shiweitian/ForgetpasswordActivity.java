package com.wangdi.shiweitian;

import com.wangdi.shiweitian.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
		TextView promptsone,promptstwo;
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
			promptsone=(TextView) findViewById(R.id.promptsone);
			promptstwo=(TextView) findViewById(R.id.promptstwo);
			back.setOnClickListener(onClickListener);
			getsms.setOnClickListener(onClickListener);
			next.setOnClickListener(onClickListener);
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
					next();
					break;

				default:
					break;
				}
			}
		};
		//下一步页面跳转方法
		public void next(){
			judgecode();
			if(promptsone.getText().toString().equals(" ")&&promptstwo.getText().toString().equals(" ")){
				Intent intent= new Intent();
				intent.setClass(ForgetpasswordActivity.this, ChangepasswordActivity.class);
				startActivity(intent);
				finish();
			}else{
				
			}
			
		}
		
		//判断验证码是否正确方法
		public void judgecode(){
			if(code.getText().toString().equals("A123")){
				promptstwo.setText(" ");
			}else{
				promptstwo.setText("验证码不正确");
			}
		}
		//返回方法
		public void back(){
			Intent intent= new Intent();
			intent.setClass(ForgetpasswordActivity.this, LoginActivity.class);
			startActivity(intent);
			finish();
		}
		
		//检验电话号码是否规范,规范发送短信,不规范提醒
		public void getsms(String str){
			if(isMobileNO(str)){
				Toast.makeText(this, "发不来", Toast.LENGTH_SHORT).show();
				promptsone.setText(" ");
			}else{
				promptsone.setText("输入的电话号码格式错误");
			}
		}
		
		
		
		
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
}
