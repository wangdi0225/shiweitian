package com.wangdi.shiweitian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.wangdi.shiweitian.MyListView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class SouyeFragment extends Fragment {
	private ImageView imageViewss;
	private ImageView imageViewgwc;
	private RadioButton textviewzr;
	private RadioButton textviewzx;
	private ViewPager guidePages;
	private ScheduledExecutorService scheduledExecutorService;
	private int currentItem;
	private ArrayList<View> viewList = new ArrayList<View>();
	private ImageView[] imageViews;
	private LinearLayout viewGroup;
	private RadioGroup radioGroup;
	private View header;
	private ListView listview;
	private ViewFlipper flipper;
	public static String TAG = "HIPPO_DEBUG";

	@SuppressWarnings("deprecation")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View v = inflater.inflate(R.layout.souye_item, container, false);
		header = LayoutInflater.from(getActivity()).inflate(
				R.layout.souye_item1, null);
		viewGroup = (LinearLayout) header.findViewById(R.id.viewGroup);
		listview = (ListView) v.findViewById(R.id.souye_listview);
		listview.addHeaderView(header);
		SimpleAdapter adapter = new SimpleAdapter(getActivity(), getData(),
				R.layout.imag, new String[] { "iamg" },
				new int[] { R.id.img_view });
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(onitemClickListener);
		imageViewss = (ImageView) v.findViewById(R.id.souye_shousuo);
		imageViewgwc = (ImageView) v.findViewById(R.id.souye_gouwuche);
		textviewzr = (RadioButton) v.findViewById(R.id.souye_zuire);
		textviewzx = (RadioButton) v.findViewById(R.id.souye_zuixin);
		imageViewss.setOnClickListener(onClickListener);
		imageViewgwc.setOnClickListener(onClickListener);
		radioGroup = (RadioGroup) v.findViewById(R.id.souye_radiogroup);
		radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
		flipper = (ViewFlipper) v.findViewById(R.id.souye_viewflipper);
		flipper.startFlipping();
		fillGuanggao();
		return v;
	}

	OnItemClickListener onitemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO 自动生成的方法存根
			Toast.makeText(getActivity(), "你点的第" + arg2 + "行",
					Toast.LENGTH_SHORT).show();

		}

	};
	OnClickListener onClickListener = new OnClickListener() {

		@SuppressWarnings("deprecation")
		@SuppressLint({ "ResourceAsColor", "NewApi" })
		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			Intent intent = new Intent();
			switch (arg0.getId()) {
			case R.id.souye_shousuo:
				intent.setClass(getActivity(), SousuoActivity.class);
				startActivity(intent);
				break;
			case R.id.souye_gouwuche:
				intent.setClass(getActivity(), GouwucheActivity.class);
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
			case R.id.souye_zuire:
				textviewzr.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu4));
				textviewzx.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu1));
				break;
			case R.id.souye_zuixin:
				textviewzr.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu3));
				textviewzx.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu2));
				break;
			default:
				break;
			}
		}
	};
	int[] img = { R.drawable.timg, R.drawable.timg1, R.drawable.timg2,
			R.drawable.timg3, R.drawable.timg5 };

	public void fillGuanggao() {
		for (int i = 0; i < 5; i++) {
			ImageView iv = new ImageView(getActivity());
			iv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			iv.setBackgroundResource(img[i]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			viewList.add(iv);
		}
	}

	public void fillGuanggao1() {
		for (int i = 5; i > 0; i--) {
			ImageView iv = new ImageView(getActivity());
			iv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			iv.setBackgroundResource(img[i]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			viewList.add(iv);
		}
	}

	class NavigationPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			currentItem = arg0;
			for (int i = 0; i < imageViews.length; i++) {
				if (arg0 == i) {
					imageViews[i].setImageDrawable(getResources().getDrawable(
							R.drawable.page_focused));
				} else {
					imageViews[i].setImageDrawable(getResources().getDrawable(
							R.drawable.page_unfocused));
				}
			}
		}

	}

	public class MyViewPagerAdapter extends PagerAdapter {
		private List<View> mListViews;

		public MyViewPagerAdapter(List<View> mListViews) {
			this.mListViews = mListViews;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(mListViews.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(mListViews.get(position), 0);
			return mListViews.get(position);
		}

		@Override
		public int getCount() {
			return mListViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
	}

	OnGestureListener onGestureListener = new OnGestureListener() {

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return true;
		}

		@SuppressLint("NewApi")
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub

			flipper.setFocusable(true);
			flipper.setFocusableInTouchMode(true);
			if (e1.getX() - e2.getX() > 20) {
				flipper.showNext();
				flipper.startFlipping();
				return true;
			} else if (e2.getX() - e1.getX() > 20) {
				flipper.showPrevious();
				flipper.startFlipping();
				return true;
			}
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

	};

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		for (int i = 0; i < img.length; i++) {
			map = new HashMap<String, Object>();
			map.put("iamg", img[i]);
			list.add(map);
		}
		return list;
	}

}
