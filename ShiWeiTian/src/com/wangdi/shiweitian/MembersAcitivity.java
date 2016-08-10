package com.wangdi.shiweitian;

import java.util.ArrayList;
import java.util.List;

import com.wangdi.shiweitian.R;
import com.wangdi.shiweitian.adapter.VIPGridListAdapter;
import com.wangdi.shiweitian.adapter.VIPListViewAdapter;
import com.wangdi.shiweitian.product.MembersGridList;
import com.wangdi.shiweitian.product.MembersListLists;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

public class MembersAcitivity extends Activity {
	GridView gridView;
	ListView listview;
	ImageView back;
	List<MembersGridList> gridlists = new ArrayList<MembersGridList>();
	List<MembersListLists> listlists = new ArrayList<MembersListLists>();
	VIPGridListAdapter gridadapter;
	VIPListViewAdapter listadapter;
	int[] icon = { R.drawable.baiduplay, R.drawable.weixingplay,
			R.drawable.zhifubaoplay, R.drawable.huafeiplay };
	String[] name = { "百度钱包", "微信支付", "支付宝支付", "话费支付" };

	String[] onegridstr = { "连续包月", "198/12月", "58/3个月", "19.8/1个月" };
	String[] twogridstr = { "15元/月", "16.5元/每月", "15/每月", "" };
	String[] typegridstr = { "自动续费,可随时取消", "", "", "" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_members);
		back = (ImageView) findViewById(R.id.back);
		gridView = (GridView) findViewById(R.id.sion_listview_gridview);
		listview = (ListView) findViewById(R.id.members_listview);
		listadapter = new VIPListViewAdapter(this);
		gridadapter = new VIPGridListAdapter(this);
		listview.setAdapter(listadapter);
		gridView.setAdapter(gridadapter);
		back.setOnClickListener(onClickListener);
		addgrid();// 添加数据
		addlist();
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.back:
				Intent intent = new Intent();
				intent.setClass(MembersAcitivity.this, MainActivity.class);
				startActivity(intent);
				break;

			default:
				break;
			}
		}
	};

	// 返回方法
	public void back() {
		Intent intent = new Intent();

	}

	private void addlist() {
		for (int i = 0; i < icon.length; i++) {
			MembersListLists lists = new MembersListLists();
			lists.icon = icon[i];
			lists.name = name[i];
			listlists.add(lists);
		}
		listadapter.setData(listlists);
	}

	public void addgrid() {
		for (int i = 0; i < 4; i++) {
			MembersGridList meberslist = new MembersGridList();
			meberslist.moneyone = onegridstr[i];
			meberslist.moneytwo = twogridstr[i];
			meberslist.moneytype = typegridstr[i];
			gridlists.add(meberslist);
		}
		gridadapter.setData(gridlists);
	}
}
