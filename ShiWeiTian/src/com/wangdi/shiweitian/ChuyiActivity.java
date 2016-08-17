package com.wangdi.shiweitian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ChuyiActivity extends Activity implements OnClickListener {
	ListView listview;
	ListView listview2;
	
	
	SimpleAdapter simpleAdapter;
	SimpleAdapter simpleAdapter2;

	List<Map<String, Object>> list, list2;

	
	
	ImageView chuyi_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chuyi_zhanshi);

		chushi();

		listview.setAdapter(simpleAdapter);
		listview2.setAdapter(simpleAdapter2);
		

		

	}

	public void chushi() {
		listview = (ListView) findViewById(R.id.chuyi_zhanshi_view);

		list = new ArrayList<Map<String, Object>>();

		listview2 = (ListView) findViewById(R.id.zuofa);

		list2 = new ArrayList<Map<String, Object>>();
		
		chuyi_back=(ImageView) findViewById(R.id.chuyi_back);
		
		chuyi_back.setOnClickListener(this);
		
		
		String[] from = { "shicai", "numbs" };
		int[] to = { R.id.shicai, R.id.numbs };

		String[] from2 = { "image", "diyibu", "shuoming" };
		int[] to2 = { R.id.shanyao_image1, R.id.diyibu_textView,
				R.id.neirong_textView };

		getdata();
		getdata2();
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

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("image", "meishi");
		map.put("diyibu", "第一步: 洗");
		map.put("shuoming", "AAAAAA");
		list2.add(map);

		map = new HashMap<String, Object>();
		map.put("image", "meishi");
		map.put("diyibu", "第二步: 洗");
		map.put("shuoming", "AAAAAA");
		list2.add(map);

		map = new HashMap<String, Object>();
		map.put("image", "meishi");
		map.put("diyibu", "第三步: 洗");
		map.put("shuoming", "AAAAAA");
		list2.add(map);

		map = new HashMap<String, Object>();
		map.put("image", "meishi");
		map.put("diyibu", "第四步: 洗");
		map.put("shuoming", "AAAAAA");
		list2.add(map);

		map = new HashMap<String, Object>();
		map.put("image", "meishi");
		map.put("diyibu", "第五步: 洗");
		map.put("shuoming", "AAAAAA");
		list2.add(map);

		map = new HashMap<String, Object>();
		map.put("image", "meishi");
		map.put("diyibu", "第六步: 洗");
		map.put("shuoming", "AAAAAA");
		list2.add(map);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.chuyi_back:
			Intent intent = new Intent(ChuyiActivity.this, MainActivity.class);
			startActivity(intent);

			break;

		default:
			break;
		}
	}

}
