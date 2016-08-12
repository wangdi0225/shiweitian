package com.wangdi.shiweitian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ChuyiActivity extends Activity {
	ListView listview;
	ListView listview2;

	SimpleAdapter simpleAdapter;
	SimpleAdapter simpleAdapter2;

	List<Map<String, Object>> list;
	List<Map<String, Object>> list2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chuyi_zhanshi);

		chushi();
		
		getdata();
		getdata2();

		listview.setAdapter(simpleAdapter);
		listview2.setAdapter(simpleAdapter2);
	}

	public void chushi() {
		listview = (ListView) findViewById(R.id.chuyi_zhanshi_view);

		list = new ArrayList<Map<String, Object>>();

		listview2 = (ListView) findViewById(R.id.zuofa);

		list2 = new ArrayList<Map<String, Object>>();

		String[] from = { "shicai", "numbs" };
		int[] to = { R.id.shicai, R.id.numbs };

		String[] from2 = { "image", "diyibu", "shuoming" };
		int[] to2 = { R.id.shanyao_image1, R.id.diyibu_textView,
				R.id.neirong_textView };

		simpleAdapter = new SimpleAdapter(ChuyiActivity.this, list,
				R.layout.chuyiqingdan, from, to);

		simpleAdapter2 = new SimpleAdapter(ChuyiActivity.this, list2,
				R.layout.chuyi_zuofa, from2, to2);
	}

	public void getdata() {
		for (int i = 0; i < 5; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("shicai", "白芝麻");
			map.put("numbs", "适量");
			list.add(map);
			
			
			
		}

	}

	public void getdata2() {
		
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("image", "meishi");
			map2.put("diyibu", "第一步: 洗");
			map2.put("shuoming", "AAAAAA");
			list2.add(map2);
			
			
			map2.put("image", "meishi");
			map2.put("diyibu", "第二步: 洗");
			map2.put("shuoming", "AAAAAA");
			list2.add(map2);
			
			
			map2.put("image", "meishi");
			map2.put("diyibu", "第三步: 洗");
			map2.put("shuoming", "AAAAAA");
			list2.add(map2);
			
			
			map2.put("image", "meishi");
			map2.put("diyibu", "第四步: 洗");
			map2.put("shuoming", "AAAAAA");
			list2.add(map2);

	}

}
