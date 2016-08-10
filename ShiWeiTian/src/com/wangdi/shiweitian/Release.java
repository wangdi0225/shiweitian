package com.wangdi.shiweitian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wangdi.shiweitian.Release_Image;
import com.wangdi.shiweitian.Release_Video;

/**
 * Created by Administrator on 2016/8/4 0004.
 */
public class Release extends FragmentActivity implements
		RadioGroup.OnCheckedChangeListener {
	RadioButton shiping_release, tuwen_release;
	ImageView fanhui_release;
	RadioGroup rg_release;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.release);
		chushi();
		rg_release.setOnCheckedChangeListener(this);
		shiping_release.setChecked(true);
	}

	public void chushi() {
		shiping_release = (RadioButton) findViewById(R.id.shiping_release);
		tuwen_release = (RadioButton) findViewById(R.id.tuwen_release);
		fanhui_release = (ImageView) findViewById(R.id.fanhui_release);
		rg_release = (RadioGroup) findViewById(R.id.rg_release);
		fanhui_release.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent();
			// TODO 自动生成的方法存根
			switch (arg0.getId()) {
			case R.id.fanhui_release:
				intent.setClass(Release.this, MainActivity.class);
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
		Release_Image image = new Release_Image();
		Release_Video video = new Release_Video();
		switch (i) {
		case R.id.shiping_release:
			transaction.replace(R.id.fabu, video);
			transaction.commit();
			break;
		case R.id.tuwen_release:
			transaction.replace(R.id.fabu, image);
			transaction.commit();
			break;
		}
	}
}
