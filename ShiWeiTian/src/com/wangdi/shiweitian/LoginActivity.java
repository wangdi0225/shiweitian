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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import com.wangdi.shiweitian.product.Httptype;

public class LoginActivity extends Activity {
	RelativeLayout login;
	TextView forgotpassword, registernow, prompt;
	ImageView loginqq, loginweixing, loginweibo;
	EditText username, password;

	UMShareAPI mShareAPI = null;

	String str;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		login = (RelativeLayout) findViewById(R.id.login);
		forgotpassword = (TextView) findViewById(R.id.forgotpassword);
		prompt = (TextView) findViewById(R.id.prompt);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
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

		// QQ和Qzone appid appkey
		PlatformConfig.setQQZone("1105621986", "pUub4oHhuKSKXUyz");
		// 新浪微博 appkey appsecret
		PlatformConfig.setSinaWeibo("1689579222",
				"8cb1ae1ac5e49b4838607183f8b6e954");

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.login:
				//直接登录
				//loginmain();

				
				//账号密码登录
				logintype(username.getText().toString(), password.getText().toString());

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
		mShareAPI = UMShareAPI.get(this);
		SHARE_MEDIA platform = SHARE_MEDIA.QQ;

		mShareAPI.doOauthVerify(LoginActivity.this, platform, umAuthListener);

	}

	// 微博登录
	public void WeiBologin() {
		mShareAPI = UMShareAPI.get(this);
		SHARE_MEDIA platform = SHARE_MEDIA.SINA;

		mShareAPI.doOauthVerify(LoginActivity.this, platform, umAuthListener);

	}

	// 微信登录
	public void WeiXinglogin() {
		Toast.makeText(LoginActivity.this, "微信登录未开放", Toast.LENGTH_SHORT)
				.show();
	}

	private UMAuthListener getAuthListener = new UMAuthListener() {

		@Override
		public void onCancel(SHARE_MEDIA arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onComplete(SHARE_MEDIA arg0, int arg1,
				Map<String, String> data) {
			// TODO Auto-generated method stub
			Log.i("登录成功返回", data.toString());
		}

		@Override
		public void onError(SHARE_MEDIA arg0, int arg1, Throwable arg2) {
			// TODO Auto-generated method stub

		}

	};

	private UMAuthListener umAuthListener = new UMAuthListener() {
		@Override
		public void onComplete(SHARE_MEDIA platform, int action,
				Map<String, String> data) {

			Log.i("登录成功返回", data.toString());
			mShareAPI.getPlatformInfo(LoginActivity.this, platform,
					getAuthListener);
			loginmain();

		}

		@Override
		public void onError(SHARE_MEDIA platform, int action, Throwable t) {
			Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT)
					.show();

		}

		@Override
		public void onCancel(SHARE_MEDIA platform, int action) {
			Toast.makeText(getApplicationContext(), "取消登录", Toast.LENGTH_SHORT)
					.show();
		}
	};

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		mShareAPI.onActivityResult(requestCode, resultCode, data);
	}

	// 调用登录借口验证账号密码方法

	public void logintype(final String username, final String password) {
		new Thread(new Runnable() {
			@Override
			public void run() {

				Httptype httptype = new Httptype();
				str = httptype.login(username, password);
				myHandler.sendEmptyMessage(0);
			}

		}).start();
	}

	Handler myHandler = new Handler() {
		public void handleMessage(Message msg) {
			try {
				JSONObject jsonObject = new JSONObject(str);
				int status = jsonObject.getInt("status");
				String message = jsonObject.getString("message");
				if (status == 2) {
					prompt.setText(message);

				} else {
					loginmain();
				}

			} catch (JSONException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}
	};

	public void loginmain() {

		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}
