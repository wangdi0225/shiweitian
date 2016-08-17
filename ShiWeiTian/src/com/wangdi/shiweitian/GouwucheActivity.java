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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class GouwucheActivity extends Activity {
	private ListView listview;
	private TextView textView;
	private ImageView imageView;
	private ImageView imageView2;
	private CheckBox checkBox;
	private CheckBox biaotiCheckBox;
	private SimpleAdapter simpleAdapter;
	private TextView bianji_textView, quanxuan_anniu, jiesuan_textView,
			heji_textView, biaoti_bianji;
	private List<Map<String, Object>> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_gouwuche);

		imageView = (ImageView) findViewById(R.id.gouwuche_fanhui);
		imageView.setOnClickListener(clickListener);
		bianji_textView = (TextView) findViewById(R.id.bianji_textView);
		quanxuan_anniu = (TextView) findViewById(R.id.quanxuan_anniu);
		jiesuan_textView = (TextView) findViewById(R.id.jiesuan_textView);
		heji_textView = (TextView) findViewById(R.id.heji_textView);

		bianji_textView.setOnClickListener(clickListener);

		// checkBox.setOnClickListener(clickListener);

		// biaotiCheckBox = (CheckBox) findViewById(R.id.biaoti_checkBox);
		// biaotiCheckBox.setOnClickListener(clickListener);

		gouwuche();
		getData();

		listview.setAdapter(simpleAdapter);
	}

	OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub

		}
	};

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {

			// TODO 自动生成的方法存根
			switch (arg0.getId()) {
			case R.id.gouwuche_fanhui:
				Intent intent = new Intent();
				intent.setClass(GouwucheActivity.this, MainActivity.class);
				startActivity(intent);

				break;

			case R.id.bianji_textView:
				Toast.makeText(GouwucheActivity.this, "编辑", Toast.LENGTH_SHORT)
						.show();
				break;

			case R.id.biaoti_bianji:
				Toast.makeText(GouwucheActivity.this, "编辑", Toast.LENGTH_SHORT)
						.show();

				break;

			default:
				break;
			}
		}
	};

	public void gouwuche() {
		listview = (ListView) findViewById(R.id.gouwu_listView);

		list = new ArrayList<Map<String, Object>>();

		String[] from = { "biaoti", "image", "neirong", "jiage", "yuanjiage" };
		int[] to = { R.id.biaoti_textView, R.id.meishi_image,
				R.id.neirong_textView, R.id.jiage_textView,
				R.id.yuanjia_textView };

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
			map.put("yuanjiage", "¥ 316");
			list.add(map);

		}

	}

}
