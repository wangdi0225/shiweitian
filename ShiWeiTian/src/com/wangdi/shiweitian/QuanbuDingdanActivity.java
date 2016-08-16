package com.wangdi.shiweitian;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class QuanbuDingdanActivity extends Activity {
	ListView listview;
	SimpleAdapter simpleAdpter;
	
	ArrayList<Fragment> fragmentList;
	ViewPager viewPager;
	
	
	RadioButton radioButtonfahuo;
	RadioButton radioButtonshouhuo;
	RadioButton radioButtonpingjia;
	RadioButton radioButtonfukuan;
	
	RadioGroup radioGroup;
	
//	simpleAdapter =new SimpleAdapter(getSupportFragmentManager(),fragmentList);
	
	

	ImageButton imageButton;
	TextView quxiao_dingdan, queren_fukuan;
	
	/* dfukuan_textView,
			dpingjia_textView, dshouhuo_textView, dfahuo_textView;*/
	ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_quanbu_dingdan); // 布局listView

		

		listview.setAdapter(simpleAdpter);

		imageButton = (ImageButton) findViewById(R.id.bofang_anniu);

		quxiao_dingdan = (TextView) findViewById(R.id.quxiao_dingdan);
		queren_fukuan = (TextView) findViewById(R.id.queren_fukuan);

		
		
		radioButtonfukuan = (RadioButton) findViewById(R.id.dfukuan_button);
		radioButtonpingjia = (RadioButton) findViewById(R.id.dpingjia_button);
		radioButtonshouhuo = (RadioButton) findViewById(R.id.dshouhuo_button);
		radioButtonfahuo = (RadioButton) findViewById(R.id.dfahuo_button);

		
		radioGroup=(RadioGroup)findViewById(R.id.dingdan_radioGroup);
		
		getData();
		
	}

	
	OnPageChangeListener onPageChangeListener=new OnPageChangeListener() {
		
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
				
			case 3:radioButtonpingjia.setChecked(true);
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
	
	public void getData(){
		  fragmentList =new ArrayList<Fragment>();
		  FukuanFragment fukuanFragment=new FukuanFragment();
		  fragmentList.add(fukuanFragment);
		  
		  FahuoFragment fahuoFragment=new FahuoFragment();
		  fragmentList.add(fahuoFragment);
		  
		  ShouhuoFragment shouhuoFragment=new ShouhuoFragment();
		  fragmentList.add(shouhuoFragment);
		  
		  PingjiaFragment pingjiaFragment=new PingjiaFragment();
		  fragmentList.add(pingjiaFragment);
		  
		  
		  
		  
	}
	
	
	

	

}