package com.wangdi.shiweitian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wangdi.shiweitian.R;

public class LoginActivity extends Activity {
	RelativeLayout login;
	TextView  forgotpassword, registernow;
	ImageView loginqq, loginweixing, loginweibo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		login = (RelativeLayout) findViewById(R.id.login);
		forgotpassword = (TextView) findViewById(R.id.forgotpassword);
		registernow = (TextView) findViewById(R.id.registernow);
		loginqq = (ImageView) findViewById(R.id.qq);
		loginweibo = (ImageView) findViewById(R.id.weibo);
		loginweixing = (ImageView) findViewById(R.id.weixing);
		loginqq.setOnClickListener(onClickListener);
		loginweibo.setOnClickListener(onClickListener);
		loginweixing.setOnClickListener(onClickListener);
		forgotpassword.setOnClickListener(onClickListener);
		registernow.setOnClickListener(onClickListener);
		login.setOnClickListener(onClickListener);

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.login:
				login();
				break;
			
				
			case R.id.forgotpassword:
				forgotpassword();
				;
				break;
			case R.id.registernow:
				registernow();
				break;
			case R.id.qq:
				QQlogin();
				break;
			case R.id.weixing:
				WeiXinglogin();
				break;
			case R.id.weibo:
				WeiBologin();
				break;

			default:
				break;
			}

		}
	};

	// 登录验证账号密码方法
	public void login() {
		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, MainActivity.class);
		startActivity(intent);
	}

	
	

	// 忘记密码跳转密码找回界面
	public void forgotpassword() {
		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, ForgetpasswordActivity.class);
		startActivity(intent);
		finish();
	}

	// 跳转立即注册页面
	public void registernow() {
		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, RegisterActivity.class);
		startActivity(intent);
		finish();

	}

	// QQ登录
	public void QQlogin() {
		Toast.makeText(this, "QQ登录尚未开发", Toast.LENGTH_SHORT).show();
	}

	// 微博登录
	public void WeiBologin() {
		Toast.makeText(this, "微博登录尚未开发", Toast.LENGTH_SHORT).show();
	}

	// 微信登录
	public void WeiXinglogin() {
		Toast.makeText(this, "微信登录尚未开发", Toast.LENGTH_SHORT).show();
	}
}
