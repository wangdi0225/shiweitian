package com.wangdi.shiweitian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class HuanyingActivity extends Activity {

	private final long SPLASH_LENGTH = 5000;
	Handler handler = new Handler();

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.huanying);
		handler.postDelayed(new Runnable() { // 使用handler的postDelayed实现延时跳转
					public void run() {
						Intent intent = new Intent(HuanyingActivity.this,
								LoginActivity.class);
						startActivity(intent);
						finish();
					}
				}, SPLASH_LENGTH);// 5秒后跳转至应用主界面MainActivity

	}
}