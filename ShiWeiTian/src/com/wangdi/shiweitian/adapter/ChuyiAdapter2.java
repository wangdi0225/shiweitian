package com.wangdi.shiweitian.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangdi.shiweitian.R;
import com.wangdi.shiweitian.product.Chuyipriduct2;

public class ChuyiAdapter2 extends BaseAdapter {
	LayoutInflater inflater;
	Context context;
	List<Chuyipriduct2> lists;
	int resourceId;

	public ChuyiAdapter2() {
		// TODO 自动生成的构造函数存根
	}

	public ChuyiAdapter2(Context context, int resourceId,
			List<Chuyipriduct2> lists) {
		// TODO 自动生成的构造函数存根
		this.lists = lists;
		this.context = context;
		this.resourceId = resourceId;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return lists.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO 自动生成的方法存根
		return lists.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO 自动生成的方法存根
		return arg0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO 自动生成的方法存根
		if (arg1 == null) {
			arg1 = inflater.inflate(resourceId, null);
		}
		ImageView imageView = (ImageView) arg1
				.findViewById(R.id.chuyi_bofangcai1);
		TextView textview_name1 = (TextView) arg1
				.findViewById(R.id.chuyi_name1);
		TextView textview_name2 = (TextView) arg1
				.findViewById(R.id.chuyi_touxiang1);
		Chuyipriduct2 products = lists.get(arg0);
		imageView.setBackgroundDrawable(context.getResources().getDrawable(
				products.getImgedt()));
		textview_name1.setText(products.getCaiming());
		textview_name2.setText(products.getUsername());
		return arg1;
	}

}
