package com.wangdi.shiweitian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wangdi.shiweitian.Fragment_Image;
import com.wangdi.shiweitian.Fragment_Video;

/**
 * Created by Administrator on 2016/8/5 0005.
 */
public class Released extends FragmentActivity implements
		RadioGroup.OnCheckedChangeListener {
	RadioButton shiping_released, tuwen_released;
	ImageView fanhui_released;
	RadioGroup rg_released;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.released);
		chushi();
		rg_released.setOnCheckedChangeListener(this);
		shiping_released.setChecked(true);
	}

	public void chushi() {
		shiping_released = (RadioButton) findViewById(R.id.shiping_released);
		tuwen_released = (RadioButton) findViewById(R.id.tuwen_released);
		fanhui_released = (ImageView) findViewById(R.id.fanhui_released);
		rg_released = (RadioGroup) findViewById(R.id.rg_released);
		fanhui_released.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent();
			// TODO 自动生成的方法存根
			switch (arg0.getId()) {
			case R.id.fanhui_released:
				intent.setClass(Released.this, MainActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};

	@Override
	public void onCheckedChanged(RadioGroup radioGroup, int i) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		Fragment_Video video = new Fragment_Video();
		Fragment_Image image = new Fragment_Image();
		switch (i) {
		case R.id.shiping_released:
			transaction.replace(R.id.yifabu, video);
			transaction.commit();
			break;
		case R.id.tuwen_released:
			transaction.replace(R.id.yifabu, image);
			transaction.commit();
			break;
		}
	}
}
