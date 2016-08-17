package com.wangdi.shiweitian;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class QuanbuDingdanActivity extends Activity {
	ListView listview;
	PagerAdapter simpleAdpter;
	// MyAdapter myAdapter;

	List<Fragment> fragmentList;

	ViewPager viewPager;

	RadioButton radioButtonfahuo;
	RadioButton radioButtonshouhuo;
	RadioButton radioButtonpingjia;
	RadioButton radioButtonfukuan;

	RadioGroup radioGroup;

	ImageButton imageButton;
	TextView quxiao_dingdan, queren_fukuan;

	ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_quanbu_dingdan); // 布局listView

		getData();
		chushi();

		// myAdapter=new MyAdapter(getSupportFragmentManager(),fragmentList);

		// listview.setAdapter(myAdapter);

		imageButton = (ImageButton) findViewById(R.id.bofang_anniu);

		quxiao_dingdan = (TextView) findViewById(R.id.quxiao_dingdan);
		queren_fukuan = (TextView) findViewById(R.id.queren_fukuan);

		// radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);

		viewPager = (ViewPager) findViewById(R.id.android_viewPager);
		viewPager.setAdapter(simpleAdpter);

	}

	// 控件找ID

	public void chushi() {
		radioGroup = (RadioGroup) findViewById(R.id.dingdan_radioGroup);

		radioButtonfukuan = (RadioButton) findViewById(R.id.dfukuan_button);
		radioButtonpingjia = (RadioButton) findViewById(R.id.dpingjia_button);
		radioButtonshouhuo = (RadioButton) findViewById(R.id.dshouhuo_button);
		radioButtonfahuo = (RadioButton) findViewById(R.id.dfahuo_button);

		viewPager.setAdapter(simpleAdpter);
	}

	OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			switch (arg0) {
			case 0:
				radioButtonfukuan.setChecked(true);
				break;

			case 1:
				radioButtonfahuo.setChecked(true);
				break;

			case 2:
				radioButtonshouhuo.setChecked(true);
				break;

			case 3:
				radioButtonpingjia.setChecked(true);
				break;

			default:
				break;
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}
	};
	
	
	
	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.dfukuan_button:
					viewPager.setCurrentItem(0);
					
				break;
			case R.id.dfahuo_button:
					viewPager.setCurrentItem(1);
					
				break;
			case R.id.dshouhuo_button:
					viewPager.setCurrentItem(2);
					
				break;
			case R.id.dpingjia_button:
					viewPager.setCurrentItem(3);
					
				break;

			default:
				break;
			}
		}
	};
	
	

	public void getData() {
		fragmentList = new ArrayList<Fragment>();
		FukuanFragment fukuanFragment = new FukuanFragment();
		fragmentList.add(fukuanFragment);

		FahuoFragment fahuoFragment = new FahuoFragment();
		fragmentList.add(fahuoFragment);

		ShouhuoFragment shouhuoFragment = new ShouhuoFragment();
		fragmentList.add(shouhuoFragment);

		PingjiaFragment pingjiaFragment = new PingjiaFragment();
		fragmentList.add(pingjiaFragment);

	}

}