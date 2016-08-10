package com.wangdi.shiweitian;

import java.util.ArrayList;

import com.wangdi.shiweitian.adapter.MyAdapter;
import com.wangdi.shiweitian.SouyeFragment;
import com.wangdi.shiweitian.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {
	RadioButton radioButtonsy;
	RadioButton radioButtoncy;
	RadioButton radioButtonzb;
	RadioButton radioButtonwo;
	RadioGroup radioGroup;
	ViewPager viewPager;
	ArrayList<Fragment> fragmentList;
	MyAdapter myAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.souye);
		radioButtonsy = (RadioButton) findViewById(R.id.radiobutton_souye);
		radioButtoncy = (RadioButton) findViewById(R.id.radiobutton_chuyi);
		radioButtonzb = (RadioButton) findViewById(R.id.radiobutton_zhibo);
		radioButtonwo = (RadioButton) findViewById(R.id.radiobutton_wode);
		getDate();
		myAdapter = new MyAdapter(getSupportFragmentManager(), fragmentList);
		viewPager = (ViewPager) findViewById(R.id.android_viewPager);
		viewPager.setAdapter(myAdapter);
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
		viewPager.setOnPageChangeListener(onPageChangeListener);
	}

	OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			// TODO 自动生成的方法存根
			switch (arg0) {
			case 0:
				radioButtonsy.setChecked(true);
				break;
			case 1:
				radioButtoncy.setChecked(true);
				break;
			case 2:
				radioButtonzb.setChecked(true);
				break;
			case 3:
				radioButtonwo.setChecked(true);
				break;
			default:
				break;
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO 自动生成的方法存根

		}
	};

	public void getDate() {
		fragmentList = new ArrayList<Fragment>();
		SouyeFragment souyeFragment = new SouyeFragment();
		fragmentList.add(souyeFragment);

		ChuyiFragment chuyiFragment = new ChuyiFragment();
		fragmentList.add(chuyiFragment);

		ZhiboFragment zhiboFragment = new ZhiboFragment();
		fragmentList.add(zhiboFragment);

		WodeFragment wodeFragment = new WodeFragment();
		fragmentList.add(wodeFragment);
	}

	OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {

		@SuppressLint({ "ResourceAsColor", "NewApi" })
		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO 自动生成的方法存根
			switch (arg0.getCheckedRadioButtonId()) {
			case R.id.radiobutton_souye:
				viewPager.setCurrentItem(0);
				Drawable drawable = getResources().getDrawable(
						R.drawable.souyedian);
				radioButtonsy.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable, null, null);
				Drawable drawable1 = getResources().getDrawable(
						R.drawable.chuyiwei);
				radioButtoncy.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable1, null, null);
				Drawable drawable2 = getResources().getDrawable(
						R.drawable.zhibowei);
				radioButtonzb.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable2, null, null);
				Drawable drawable3 = getResources().getDrawable(
						R.drawable.wodewei);
				radioButtonwo.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable3, null, null);
				break;
			case R.id.radiobutton_chuyi:
				viewPager.setCurrentItem(1);
				Drawable drawable5 = getResources().getDrawable(
						R.drawable.souyewei);
				radioButtonsy.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable5, null, null);
				Drawable drawable4 = getResources().getDrawable(
						R.drawable.chuyidian);
				radioButtoncy.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable4, null, null);
				Drawable drawable6 = getResources().getDrawable(
						R.drawable.zhibowei);
				radioButtonzb.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable6, null, null);
				Drawable drawable7 = getResources().getDrawable(
						R.drawable.wodewei);
				radioButtonwo.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable7, null, null);
				break;
			case R.id.radiobutton_zhibo:
				viewPager.setCurrentItem(2);
				Drawable drawable8 = getResources().getDrawable(
						R.drawable.souyewei);
				radioButtonsy.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable8, null, null);
				Drawable drawable9 = getResources().getDrawable(
						R.drawable.chuyiwei);
				radioButtoncy.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable9, null, null);
				Drawable drawable10 = getResources().getDrawable(
						R.drawable.zhibodian);
				radioButtonzb.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable10, null, null);
				Drawable drawable11 = getResources().getDrawable(
						R.drawable.wodewei);
				radioButtonwo.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable11, null, null);
				break;
			case R.id.radiobutton_wode:
				Drawable drawable12 = getResources().getDrawable(
						R.drawable.souyewei);
				radioButtonsy.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable12, null, null);
				Drawable drawable13 = getResources().getDrawable(
						R.drawable.chuyiwei);
				radioButtoncy.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable13, null, null);
				Drawable drawable14 = getResources().getDrawable(
						R.drawable.zhibowei);
				radioButtonzb.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable14, null, null);
				Drawable drawable15 = getResources().getDrawable(
						R.drawable.wodedian);
				radioButtonwo.setCompoundDrawablesWithIntrinsicBounds(null,
						drawable15, null, null);
				viewPager.setCurrentItem(3);
				break;
			default:
				break;
			}
		}
	};
}
