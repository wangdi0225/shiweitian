package com.wangdi.shiweitian;

import java.util.ArrayList;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SimpleAdapter;

public class FukuanFragment extends Fragment implements OnClickListener {
	ListView listView;
	SimpleAdapter simpleAdpter;
	View view;
	View header;

	RadioButton textViewdingdan;
	RadioButton textViewquefukuan;

	RadioGroup radioGroupfukuan;
	RadioGroup radioGroupquxiao;

	List<Map<String, Object>> list;
	ImageButton imageButton;
	OnClickListener clickListener;
	OnItemClickListener onItemClickListener;
	OnCheckedChangeListener OnCheckedChangeListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		view = inflater.inflate(R.layout.fragment_fukuan, container, false);

		SimpleAdapter simpleAdpter = new SimpleAdapter(getActivity(),
				getData(), R.layout.quanbu_dingdan_item, new String[] {
						"biaoti", "image", "neirong", "jiage" }, new int[] {
						R.id.biaoti_textView, R.id.meishi_image,
						R.id.neirong_textView, R.id.jiage_textView });
		chushi();

		return view;
	}

	
	
	//控件找Id
	public void chushi() {
		listView = (ListView) view.findViewById(R.id.fukuan_listView);

		listView.setAdapter(simpleAdpter);
		listView.setOnItemClickListener(onItemClickListener);

		textViewdingdan = (RadioButton) view.findViewById(R.id.quxiao_dingdan);
		textViewquefukuan = (RadioButton) view.findViewById(R.id.queren_fukuan);

		radioGroupfukuan = (RadioGroup) view.findViewById(R.id.queren_fukuan);
		radioGroupquxiao = (RadioGroup) view.findViewById(R.id.quxiao_dingdan);

		radioGroupfukuan.setOnCheckedChangeListener(OnCheckedChangeListener);
		radioGroupquxiao.setOnCheckedChangeListener(OnCheckedChangeListener);

		
		
		
		
	}

	public void onClick(View v) {
		// TODO 自动生成的方法存根
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.quxiao_dingdan:
			intent.setClass(getActivity(), MainActivity.class);
			startActivity(intent);
			break;
		case R.id.queren_fukuan:
			intent.setClass(getActivity(), MainActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	};

	List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		for (int i = 0; i < 5; i++) {
			map = new HashMap<String, Object>();
			map.put("biaoti", "AAAAA");
			map.put("image", "meishi");
			map.put("neirong", "BBBB");
			map.put("jiage", "¥ 168");

			list.add(map);
		}
		return list;
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

}
