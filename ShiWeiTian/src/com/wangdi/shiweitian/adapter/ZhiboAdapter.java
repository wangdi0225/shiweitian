package com.wangdi.shiweitian.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangdi.shiweitian.R;
import com.wangdi.shiweitian.product.Zhibopriduct;

public class ZhiboAdapter extends BaseAdapter {
	LayoutInflater inflater;
	Context context;
	List<Zhibopriduct> lists;
	int resourceId;

	public ZhiboAdapter() {
		// TODO 自动生成的构造函数存根
	}

	public ZhiboAdapter(Context context, int resourceId,
			List<Zhibopriduct> lists) {
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
				.findViewById(R.id.zhibo_bofangcai);
		TextView textView1 = (TextView) arg1.findViewById(R.id.zhibo_jiaru);
		TextView textView2 = (TextView) arg1.findViewById(R.id.zhibo_soucang);
		TextView textView3 = (TextView) arg1
				.findViewById(R.id.zhibo_chufangname);
		TextView textview_name1 = (TextView) arg1
				.findViewById(R.id.zhibo_mingzi);
		TextView textview_name2 = (TextView) arg1
				.findViewById(R.id.zhibo_neirong);
		Zhibopriduct products = lists.get(arg0);
		imageView.setBackgroundDrawable(context.getResources().getDrawable(
				products.getImge()));
		Drawable drawable = context.getResources().getDrawable(
				products.getImgjr());
		textView1.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null,
				null);
		Drawable drawable1 = context.getResources().getDrawable(
				products.getImgsc());
		textView2.setCompoundDrawablesWithIntrinsicBounds(drawable1, null,
				null, null);
		textview_name1.setText(products.getName());
		textview_name2.setText(products.getNeirong());
		textView3.setText(products.getChufang());
		return arg1;
	}

}
