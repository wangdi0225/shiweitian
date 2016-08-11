package com.wangdi.shiweitian.adapter;

import java.util.List;





import com.wangdi.shiweitian.R;
import com.wangdi.shiweitian.product.MembersListLists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VIPListViewAdapter extends BaseAdapter {
	Context mContext;
	List<MembersListLists> myList;

	public VIPListViewAdapter(Context mContext) {
		super();
		this.mContext = mContext;

	}

	/**
	 * 设置数据源
	 * 
	 * @param lists
	 */
	public void setData(List<MembersListLists> lists) {
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
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_memberslistview, null);
			viewHolder = new ViewHolder();
			
			viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
			viewHolder.name = (TextView) convertView.findViewById(R.id.name);
			viewHolder.check = (ImageView) convertView.findViewById(R.id.check);
	

			convertView.setTag(viewHolder);//标签记住
		} else {
			viewHolder = (ViewHolder) convertView.getTag();//获得标签
		}

		// 填充数据
		viewHolder.icon.setImageResource(myList.get(position).icon);
		viewHolder.name.setText(myList.get(position).name);
		viewHolder.check.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for(int i= 0 ;i<myList.size();i++){
					myList.get(i).ischeck=false;
				}
				myList.get(position).ischeck=true;
				notifyDataSetChanged();
			}
			
		});
		if(myList.get(position).ischeck){
			viewHolder.check.setImageResource(R.drawable.yeschange);
		}else{
			viewHolder.check.setImageResource(R.drawable.nochange);
		}
		return convertView;
	}

	class ViewHolder {
		ImageView icon;
		TextView name;
		ImageView check;
	}

}