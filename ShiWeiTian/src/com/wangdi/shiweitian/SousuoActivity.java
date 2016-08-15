package com.wangdi.shiweitian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SousuoActivity extends Activity {
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sousuo);
		button = (Button) findViewById(R.id.sousuo_quxiao);
		button.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent();
			// TODO 自动生成的方法存根
			switch (arg0.getId()) {
			case R.id.sousuo_quxiao:
				intent.setClass(SousuoActivity.this, MainActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};
}
