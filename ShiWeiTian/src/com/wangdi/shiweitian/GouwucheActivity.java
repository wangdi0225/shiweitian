package com.wangdi.shiweitian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class GouwucheActivity extends Activity {
	ListView listview;

	SimpleAdapter simpleAdapter;

	List<Map<String, Object>> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_gouwuche);

		gouwuche();
		getData();

		listview.setAdapter(simpleAdapter);
	}

	public void gouwuche() {
		listview = (ListView) findViewById(R.id.gouwu_listView);

		list = new ArrayList<Map<String, Object>>();

		String[] from = { "biaoti", "image", "neirong", "jiage" };
		int[] to = { R.id.biaoti_textView, R.id.meishi_image,
				R.id.neirong_textView, R.id.jiage_textView };

		simpleAdapter = new SimpleAdapter(GouwucheActivity.this, list,
				R.layout.gouwuche_item, from, to);

	}

	public void getData() {
		for (int i = 0; i < 6; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("biaoti", "芒果姐姐小厨房");
			map.put("image", "meishi");
			map.put("neirong", "美味与要值得双重缴械，从舌尖到心底的惊艳诱惑。");
			map.put("jiage", "¥ 168");
			list.add(map);
		}

	}

}
