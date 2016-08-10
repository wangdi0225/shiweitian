package com.wangdi.shiweitian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.wangdi.shiweitian.product.GouWuChe;

public class GouwucheActivity extends Activity {

	ListView list;
	ArrayAdapter arrayAdapter;
	SimpleAdapter simpleAdapter;

	List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
	List<GouWuChe> lists = new ArrayList<GouWuChe>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gouwuche);

		list = (ListView) findViewById(R.id.gouwu_listView); // 传listview 控件

		String[] keys = { "image", "biaoti", "neirong", "jiage" };

		int[] viewIds = { R.id.meishi_image, R.id.biaoti_textView,
				R.id.neirong_textView, R.id.jiage_textView };

		getData();

		simpleAdapter = new SimpleAdapter(GouwucheActivity.this, listData,
				R.layout.gouwuche_item, keys, viewIds);

		list.setAdapter(simpleAdapter);

	}

	public void getData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("image", R.drawable.meishi);
		map.put("biaoti", "芒果姐姐小厨房");
		map.put("neirong", "美味与颜值的双重缴械，从舌尖到心底的惊艳诱惑。");
		map.put("jiage", "¥ 168");

		listData.add(map);

		map.put("image", R.drawable.meishi);
		map.put("biaoti", "宝宝辅食微课堂");
		map.put("neirong", "为宝宝补充铁元素，促进宝宝的视力发育和上皮组织生长。");
		map.put("jiage", "¥ 338");

		listData.add(map);

		map.put("image", R.drawable.meishi);
		map.put("biaoti", "饭合Foodlink");
		map.put("neirong", "夏至已至，把‘杏’福送给自己或是你可爱的TA!");
		map.put("jiage", "¥ 299");

		listData.add(map);

	}

}
