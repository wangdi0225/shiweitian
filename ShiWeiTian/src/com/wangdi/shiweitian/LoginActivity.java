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
	TextView  forgotpassword, registernow,prompt;
	ImageView loginqq, loginweixing, loginweibo;
	EditText username,password;

	//UMShareAPI mShareAPI = UMShareAPI.get(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		login = (RelativeLayout) findViewById(R.id.login);
		forgotpassword = (TextView) findViewById(R.id.forgotpassword);
		prompt=(TextView) findViewById(R.id.prompt);
		username=(EditText) findViewById(R.id.username);
		password=(EditText) findViewById(R.id.password);
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
		
		

		
		//PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
	       //微信 appid appsecret
		//PlatformConfig.setQQZone("1105621986", "pUub4oHhuKSKXUyz"); 
	        // QQ和Qzone appid appkey     
		//PlatformConfig.setSinaWeibo("1689579222","8cb1ae1ac5e49b4838607183f8b6e954");
		 //新浪微博 appkey appsecret
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.login:
				loginmain();
				
				//login();
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
		//mShareAPI.isInstall(this, SHARE_MEDIA.QQ);
		//mShareAPI.doOauthVerify(LoginActivity.this, platformqq, umAuthListener);
		//mShareAPI.getPlatformInfo(LoginActivity.this, platformqq, umAuthListener);
	}

	// 微博登录
	public void WeiBologin() {
		//mShareAPI.isInstall(this, SHARE_MEDIA.SINA);
		//mShareAPI.doOauthVerify(LoginActivity.this, platformsina, umAuthListener);
		//mShareAPI.getPlatformInfo(LoginActivity.this, platformsina, umAuthListener);
		}

	// 微信登录
	public void WeiXinglogin() {
		
		Toast.makeText(this, "微信登录尚未开发", Toast.LENGTH_SHORT).show();
	}
	
	
	
	
	
/*	SHARE_MEDIA platformsina = SHARE_MEDIA.SINA; 
	SHARE_MEDIA platformweixin = SHARE_MEDIA.WEIXIN; 
	SHARE_MEDIA platformqq = SHARE_MEDIA.QQ; 
	
	private UMAuthListener umAuthListener = new UMAuthListener() {
	        @Override
	        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
	           Toast.makeText( getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
	           Log.i("登录成功返回", data.toString());
	           loginmain();
	         *
	        }

	        @Override
	        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
	            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
	            
	        }

	        @Override
	        public void onCancel(SHARE_MEDIA platform, int action) {
	            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
	        }
	    };
	
	   
	    
	   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	        mShareAPI.onActivityResult(requestCode, resultCode, data);
	    } */
	    
	//调用登录借口
	String str;
	public void logintype(final String username ,final String password) {
		new Thread(new Runnable() {
			@Override
			public void run() {
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
    			if(status==2){
    			prompt.setText(message);
    			
    			}else{
    				loginmain();
    			}
    			
    		} catch (JSONException e) {
    			// TODO 自动生成的 catch 块
    			e.printStackTrace();
    		}
            
        }   
   };
	public void loginmain(){
		
		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
	
}
