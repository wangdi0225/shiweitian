package com.wangdi.shiweitian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class ZhiboActivity extends Activity {

	Spinner spinner;
	ImageButton imageButtonXiala;

	OnItemSelectedListener itemClickListener;
	OnClickListener onClickListener;



	TextView textView,zhibo;

	ImageView imageView, shareWeiXin, shareQQ, shareWeiBo;


	
	


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

		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strs);
		spinner = (Spinner) findViewById(R.id.leibie_spinner);
		spinner.setAdapter(arrayAdapter);
		imageView = (ImageView) findViewById(R.id.zhibo_back);
		
		
		imageButtonXiala=(ImageButton)findViewById(R.id.xiala_jiantou);
		imageButtonXiala.setOnClickListener(clickListener);
		zhibo = (TextView) findViewById(R.id.kaishi_zhibo);
		zhibo.setOnClickListener(clickListener);

		textView = (TextView) findViewById(R.id.neirong_anniu);
		textView.setOnClickListener(clickListener);

		shareWeiXin = (ImageView) findViewById(R.id.weixin_imageView);
		shareQQ = (ImageView) findViewById(R.id.QQ_imageView);
		shareWeiBo = (ImageView) findViewById(R.id.weibo_imageView);

		shareWeiXin.setOnClickListener(clickListener);
		shareQQ.setOnClickListener(clickListener);
		shareWeiBo.setOnClickListener(clickListener);

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

			case R.id.kaishi_zhibo:
				Toast.makeText(ZhiboActivity.this, "直播", Toast.LENGTH_SHORT)
						.show();

				break;

			case R.id.weixin_imageView:
				Toast.makeText(ZhiboActivity.this, "微信分享", Toast.LENGTH_SHORT)
						.show();

				break;

			
				
			case R.id.QQ_imageView:
				Toast.makeText(ZhiboActivity.this, "丘丘分享", Toast.LENGTH_SHORT)
						.show();

				break;

			case R.id.weibo_imageView:
				Toast.makeText(ZhiboActivity.this, "微博分享", Toast.LENGTH_SHORT)
						.show();

				break;
				
			case R.id.xiala_jiantou:
				spinner.performClick();
				
				break;

			default:
				break;
			}
		}
	};

	

}
