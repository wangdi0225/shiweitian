package com.wangdi.shiweitian;

import java.util.ArrayList;
import java.util.List;

import com.wangdi.shiweitian.adapter.ZhiboAdapter;
import com.wangdi.shiweitian.product.Zhibopriduct;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ZhiboFragment extends Fragment {
	ImageView imageView;
	ImageButton imageButton;
	ImageView imageViewbfc;
	TextView textViewjr;
	TextView textViewsc;
	TextView textViewgm;
	ListView listView;
	List<Zhibopriduct> lists;
	Zhibopriduct zhibopriduct;
	ZhiboAdapter adapter;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View v = inflater.inflate(R.layout.zhibo, container, false);
		listView = (ListView) v.findViewById(R.id.zhibo_listview);
		getDate();
		ZhiboAdapter adapter = new ZhiboAdapter(getActivity(),
				R.layout.zhibo_item1, lists);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(onitemClickListener);
		return v;
	}

	OnItemClickListener onitemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO 自动生成的方法存根
			imageView = (ImageView) arg1.findViewById(R.id.zhibo_sousuo);
			imageButton = (ImageButton) arg1
					.findViewById(R.id.zhibo_bofangimageButton);
			imageViewbfc = (ImageView) arg1.findViewById(R.id.zhibo_bofangcai);
			textViewjr = (TextView) arg1.findViewById(R.id.zhibo_jiaru);
			textViewsc = (TextView) arg1.findViewById(R.id.zhibo_soucang);
			textViewgm = (TextView) arg1.findViewById(R.id.zhibo_goumai);
			textViewjr.setOnClickListener(onClickListener);
			textViewsc.setOnClickListener(onClickListener);
			imageViewbfc.setOnClickListener(onClickListener);		
		}

	};

	public void getDate() {
		lists = new ArrayList<Zhibopriduct>();
		for (int i = 0; i < 5; i++) {	
			zhibopriduct = new Zhibopriduct();
			zhibopriduct.setImge(R.drawable.timg1);
			zhibopriduct.setName("龙虾香蕉香菜根");
			zhibopriduct.setNeirong("美味与颜值的双重缴械，从舌尖到心底的惊艳诱惑");
			zhibopriduct.setImgjr(R.drawable.gouwuchewei);
			zhibopriduct.setImgsc(R.drawable.shoucangwei);
			zhibopriduct.setChufang("芒果姐姐小厨房");
			lists.add(zhibopriduct);

			zhibopriduct = new Zhibopriduct();
			zhibopriduct.setImge(R.drawable.timg3);
			zhibopriduct.setName("鸭肠辣椒黄瓜条");
			zhibopriduct.setNeirong("美味与颜值的双重缴械，从舌尖到心底的惊艳诱惑");
			zhibopriduct.setImgjr(R.drawable.gouwuchedian);
			zhibopriduct.setImgsc(R.drawable.shoucangdian);
			zhibopriduct.setChufang("黄瓜姐姐小厨房");
			lists.add(zhibopriduct);
		}
	}

	OnClickListener onClickListener = new OnClickListener() {

		@SuppressLint({ "ResourceAsColor", "NewApi" })
		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			switch (arg0.getId()) {
			case R.id.zhibo_sousuo:
				Toast.makeText(getActivity(), "搜索", Toast.LENGTH_SHORT).show();
				break;
			case R.id.zhibo_goumai:
				Toast.makeText(getActivity(), "购买", Toast.LENGTH_SHORT).show();
				break;
			case R.id.zhibo_jiaru:
				Intent intent=new Intent();
				intent.setClass(getActivity(), GouwucheActivity.class);
				startActivity(intent);
				break;
			case R.id.zhibo_soucang:
				Toast.makeText(getActivity(), "收藏", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	};
}
