package com.wangdi.shiweitian.adapter;

import java.util.List;

import com.wangdi.shiweitian.R;
import com.wangdi.shiweitian.product.Chuyipriduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ChuyiAdapter extends BaseAdapter {
	LayoutInflater inflater;
	Context context;
	List<Chuyipriduct> lists;
	int resourceId;

	public ChuyiAdapter() {
		// TODO 自动生成的构造函数存根
	}

	public ChuyiAdapter(Context context, int resourceId,
			List<Chuyipriduct> lists) {
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
				.findViewById(R.id.chuyi_bofangcai);
		ImageButton imageButton = (ImageButton) arg1
				.findViewById(R.id.chuyi_bofangimageButton);
		TextView textview_name1 = (TextView) arg1.findViewById(R.id.chuyi_name);
		TextView textview_name2 = (TextView) arg1
				.findViewById(R.id.chuyi_touxiang);
		Chuyipriduct products = lists.get(arg0);
		imageView.setBackgroundDrawable(context.getResources().getDrawable(
				products.getImgedt()));
		imageButton.setBackgroundDrawable(context.getResources().getDrawable(
				products.getImgebf()));
		textview_name1.setText(products.getCaiming());
		textview_name2.setText(products.getUsername());
		return arg1;
	}

}
