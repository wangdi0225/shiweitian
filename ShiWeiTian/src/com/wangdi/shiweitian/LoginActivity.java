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

public class LoginActivity extends Activity {
	RelativeLayout login;
	TextView forgotpassword, registernow, prompt;
	ImageView loginqq, loginweixing, loginweibo;
	EditText username, password;

	UMShareAPI mShareAPI = null;

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

		PlatformConfig.setWeixin("wxf65af94a2f31a2dd",
				"e05f09078bf0096fe27359381ab9ea4c");

		PlatformConfig.setQQZone("1105621986", "pUub4oHhuKSKXUyz");
		// QQ和Qzone appid appkey
		PlatformConfig.setSinaWeibo("1689579222",
				"8cb1ae1ac5e49b4838607183f8b6e954");
		// 新浪微博 appkey appsecret
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.login:
				loginmain(null);

				// login();
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
		logintype(username.getText().toString(), password.getText().toString());
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
		mShareAPI = UMShareAPI.get(this);
		SHARE_MEDIA platform = SHARE_MEDIA.QQ;
		// mShareAPI.isInstall(this, SHARE_MEDIA.QQ);
		mShareAPI.doOauthVerify(LoginActivity.this, platform, umAuthListener);
		// mShareAPI.getPlatformInfo(LoginActivity.this, platform,
		// umAuthListener);
	}

	// 微博登录
	public void WeiBologin() {
		mShareAPI = UMShareAPI.get(this);
		SHARE_MEDIA platform = SHARE_MEDIA.SINA;
		// mShareAPI.isInstall(this, SHARE_MEDIA.SINA);
		mShareAPI.doOauthVerify(LoginActivity.this, platform, umAuthListener);

	}

	// 微信登录
	public void WeiXinglogin() {
		mShareAPI = UMShareAPI.get(this);
		SHARE_MEDIA platform = SHARE_MEDIA.WEIXIN;
		// mShareAPI.isInstall(this, SHARE_MEDIA.SINA);
		mShareAPI.doOauthVerify(LoginActivity.this, platform, umAuthListener);
		// mShareAPI.deleteOauth(LoginActivity.this, platform,
		// umdelAuthListener);
	}

	private UMAuthListener getAuthListener = new UMAuthListener() {

		@Override
		public void onCancel(SHARE_MEDIA arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onComplete(SHARE_MEDIA arg0, int arg1,
				Map<String, String> arg2) {
			// TODO Auto-generated method stub

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
			loginmain(platform);

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

	// 调用登录借口
	String str;

	public void logintype(final String username, final String password) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				StringBuilder builder = new StringBuilder();
				try {
					String httpHost = "http://192.168.1.152/index.php/Home/api/login";
					String name = "username=" + username + "&password="
							+ password;
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
					str = builder.toString();
					myHandler.sendEmptyMessage(0);

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

	Handler myHandler = new Handler() {
		public void handleMessage(Message msg) {
			try {
				JSONObject jsonObject = new JSONObject(str);
				int status = jsonObject.getInt("status");
				String message = jsonObject.getString("message");
				if (status == 2) {
					prompt.setText(message);

				} else {
					loginmain(null);
				}

			} catch (JSONException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}
	};

	public void loginmain(SHARE_MEDIA platform) {
		mShareAPI
				.getPlatformInfo(LoginActivity.this, platform, getAuthListener);
		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}
