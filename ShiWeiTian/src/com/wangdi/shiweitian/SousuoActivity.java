package com.wangdi.shiweitian;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SousuoActivity extends FragmentActivity {
	Button button;
	RadioButton radioButton, radioButton2;
	RadioGroup radioGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sousuo);
		button = (Button) findViewById(R.id.sousuo_quxiao);
		button.setOnClickListener(onClickListener);
		radioGroup = (RadioGroup) findViewById(R.id.sousuo_radiogroup);
		radioButton2 = (RadioButton) findViewById(R.id.sousuo_zuixin);
		radioButton = (RadioButton) findViewById(R.id.sousuo_zuire);
		radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
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
	OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {		
		@SuppressWarnings("deprecation")
		@SuppressLint("NewApi")
		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO 自动生成的方法存根
			switch (arg0.getCheckedRadioButtonId()) {
			case R.id.sousuo_zuire:
				radioButton.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu4));
				radioButton2.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu1));
				break;
			case R.id.sousuo_zuixin:
				radioButton.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu3));
				radioButton2.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu2));
				break;
			default:
				break;
			}
		}
	};
}
