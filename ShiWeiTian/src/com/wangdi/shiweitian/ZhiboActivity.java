package com.wangdi.shiweitian;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ZhiboActivity extends Activity {

	Spinner spinner;
	ImageButton imageButton;

	List<Map<String, Object>> list;
	String from[] = { "选择菜品类别", "川菜", "湘菜", "粤菜", "鲁菜" };

	// ArrayAdapter arrayAdapter;
	SimpleAdapter simpleAdapter;
	View view;
	OnItemSelectedListener itemClickListener;
	OnClickListener onClickListener;

	PopupWindow popupWindow;
	private View show_popvieView;

	ImageView imageView;

	/*
	 * public View onCreateView(LayoutInflater inflater, ViewGroup container,
	 * Bundle savedInstanceState) {
	 * 
	 * view = inflater.inflate(R.layout.zhibo_jiaoyue_item, container, false);
	 * 
	 * spinner.setAdapter(simpleAdapter);
	 * 
	 * chushi();
	 * 
	 * return view; }
	 */

	ArrayAdapter<String> arrayAdapter;
	String strs[] = { "选择菜品类别", "川菜", "湘菜", "粤菜", "鲁菜" };

	@Override
	protected void onCreate(Bundle savedInstanceState) { // TODO
		// Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhibo_jiaoxue);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, strs);
		Spinner spinner = (Spinner) findViewById(R.id.zhibo_spinner);
		spinner.setAdapter(adapter);
		imageView = (ImageView) findViewById(R.id.zhibo_back);
		imageView.setOnClickListener(clickListener);
		// itemClickListener = (OnItemSelectedListener)
		// findViewById(R.id.xiala_jiantou);

		// onClickListener = (OnClickListener) findViewById(R.id.xiala_jiantou);
	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO 自动生成的方法存根
			switch (v.getId()) {
			case R.id.zhibo_back:

				Intent intent = new Intent(ZhiboActivity.this,
						MainActivity.class);
				startActivity(intent);

				break;

			case R.id.neirong_anniu:
				Toast.makeText(ZhiboActivity.this, "提交内容", Toast.LENGTH_SHORT)
						.show();

				break;

			default:
				break;
			}
		}
	};

	/*
	 * @Override public void onClick(View v) { // TODO Auto-generated method
	 * stub
	 * 
	 * switch (v.getId()) { case R.id.xiala_jiantou: spinner.performClick();
	 * break;
	 * 
	 * default: break;
	 * 
	 * }
	 */

	/*
	 * public void chushi() {
	 * 
	 * spinner = (Spinner) findViewById(R.id.zhibo_spinner);
	 * 
	 * imageButton = (ImageButton) findViewById(R.id.xiala_jiantou);
	 * 
	 * 
	 * int to[] = { R.id.leibie, R.id.xiala_jiantou };
	 * 
	 * // arrayAdapter=new ArrayAdapter(getActivity(), //
	 * R.layout.zhibo_item,strs);
	 * 
	 * // simpleAdapter = new SimpleAdapter(ZhiboActivity.this,list, from,to);
	 * 
	 * imageButton.setOnClickListener(this); }
	 */

}
