package com.wangdi.shiweitian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class FukuanFragment extends Fragment implements OnClickListener {
	ListView listView_fukuan;
	SimpleAdapter simpleAdpter;
	View v;
	List<Map<String, Object>> list;
	ImageButton imageButton;
	OnClickListener clickListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		v = inflater.inflate(R.layout.fragment_fukuan, container, false);

		getData();
		chushi();

		return v;
	}

	private void chushi() {
		listView_fukuan = (ListView) v.findViewById(R.id.fukuan_listView);

		String[] from = { "biaoti", "image", "neirong", "jiage" };
		int[] to = { R.id.biaoti_textView, R.id.meishi_image,
				R.id.neirong_textView, R.id.jiage_textView };

		simpleAdpter = new SimpleAdapter(getActivity(), list,
				R.layout.quanbu_dingdan_item, from, to);

		imageButton = (ImageButton) v.findViewById(R.id.bofang_anniu);

		imageButton.setOnClickListener(clickListener);

	}

	/*
	 * OnItemSelectedListener onItemSelectedListener=new
	 * OnItemSelectedListener() {
	 * 
	 * @Override public void onItemSelected(AdapterView<?> parent, View view,
	 * int position, long id) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void onNothingSelected(AdapterView<?> parent) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * 
	 * };
	 */

	public void getData() {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("biaoti", "AAAAA");
		map.put("image", "meishi");
		map.put("neirong", "BBBBB");
		map.put("jiage", "¥ 168");
		list.add(map);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.dfukuan_button:
			// intent.setClass(getActivity(), FragmentActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}

	}

}
