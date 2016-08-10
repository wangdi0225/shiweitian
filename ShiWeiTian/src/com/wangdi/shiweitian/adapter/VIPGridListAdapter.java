package com.wangdi.shiweitian.adapter;

import java.util.List;

import com.wangdi.shiweitian.R;


import com.wangdi.shiweitian.product.MembersGridList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VIPGridListAdapter extends BaseAdapter {
	Context mContext;
	List<MembersGridList> myList;

	public VIPGridListAdapter(Context mContext) {
		super();
		this.mContext = mContext;

	}

	/**
	 * 设置数据源
	 * 
	 * @param lists
	 */
	public void setData(List<MembersGridList> lists) {
		this.myList = lists;
		notifyDataSetInvalidated();
	}

	/**
	 * 获取总数
	 */
	@Override
	public int getCount() {
		return myList == null ? 0 : myList.size();
	}

	@Override
	public Object getItem(int position) {
		if (myList != null && position < myList.size()) {
			return myList.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup arg2) {

		ViewHolder viewHolder = null;

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_membersgridview, null);
			viewHolder = new ViewHolder();
			
			viewHolder.onetext = (TextView) convertView.findViewById(R.id.onetext);
			viewHolder.twotext = (TextView) convertView.findViewById(R.id.twotext);
			viewHolder.threetext = (TextView) convertView.findViewById(R.id.threetext);
			convertView.setTag(viewHolder);//标签记住
		} else {
			viewHolder = (ViewHolder) convertView.getTag();//获得标签
		}

		// 填充数据
		viewHolder.onetext.setText(myList.get(position).moneyone);
		viewHolder.twotext.setText(myList.get(position).moneytwo);
		viewHolder.threetext.setText(myList.get(position).moneytype);
		
return convertView;
	}

	class ViewHolder {
		TextView onetext;
		TextView twotext;
		TextView threetext;
	}
}