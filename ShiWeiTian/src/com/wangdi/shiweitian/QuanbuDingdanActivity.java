package com.wangdi.shiweitian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class QuanbuDingdanActivity extends Activity {
	ListView listview;
	SimpleAdapter simpleAdpter;
	List<Map<String, Object>> list;
	
	RadioButton radioButtonfukuan;
	RadioButton radioButtonfahuo;
	RadioButton radioButtonshouhuo;
	RadioButton radioButtonpingjia;
	
	RadioGroup radioGroup;
	

	ImageButton imageButton;
	TextView quxiao_dingdan, queren_fukuan, dfukuan_textView,
			dpingjia_textView, dshouhuo_textView, dfahuo_textView;
	ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_quanbu_dingdan); // 布局listView

		radioButtonfukuan=(RadioButton)findViewById(R.id.dfukuan_button);
		radioButtonfahuo=(RadioButton)findViewById(R.id.dfahuo_button);
		radioButtonpingjia=(RadioButton)findViewById(R.id.dpingjia_button);
		radioButtonshouhuo=(RadioButton)findViewById(R.id.dshouhuo_button);
		
		getData();
		Dingdan();
		
		radioGroup=(RadioGroup)findViewById(R.id.dingdan_radioGroup);
		

		listview.setAdapter(simpleAdpter);

		imageButton = (ImageButton) findViewById(R.id.bofang_anniu);

		quxiao_dingdan = (TextView) findViewById(R.id.quxiao_dingdan);
		queren_fukuan = (TextView) findViewById(R.id.queren_fukuan);

		

		imageView = (ImageView) findViewById(R.id.dingdan_back);

	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.quxiao_dingdan:
				Toast.makeText(QuanbuDingdanActivity.this, "取消订单",
						Toast.LENGTH_SHORT).show();

				break;
			case R.id.queren_fukuan:
				Toast.makeText(QuanbuDingdanActivity.this, "确认付款",
						Toast.LENGTH_SHORT).show();

				break;
			case R.id.dfukuan_button:
				Toast.makeText(QuanbuDingdanActivity.this, "待付款",
						Toast.LENGTH_SHORT).show();

				break;

			default:
				break;
			}
		}
	};

	public void Dingdan() {

	//	listview = (ListView) findViewById(R.id.dingdan_listView);

		list = new ArrayList<Map<String, Object>>();

		String[] from = { "biaoti", "image", "neirong", "jiage" };
		int[] to = { R.id.biaoti_textView, R.id.meishi_image,
				R.id.neirong_textView, R.id.jiage_textView };

		simpleAdpter = new SimpleAdapter(QuanbuDingdanActivity.this, list,
				R.layout.quanbu_dingdan_item, from, to);
	}

	public void getData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("biaoti", "芒果姐姐小厨房");
		map.put("image", "meishi");
		map.put("neirong", "AAAAAAAA");
		map.put("jiage", "¥ 168");
		list.add(map);
	}

}