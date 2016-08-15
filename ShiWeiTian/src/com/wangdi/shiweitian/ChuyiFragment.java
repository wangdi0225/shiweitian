package com.wangdi.shiweitian;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wangdi.shiweitian.adapter.ChuyiAdapter;
import com.wangdi.shiweitian.adapter.ChuyiAdapter2;
import com.wangdi.shiweitian.product.Chuyipriduct;
import com.wangdi.shiweitian.product.Chuyipriduct2;

public class ChuyiFragment extends Fragment {
	private ImageView imageViewss;
	private ImageView imageViewgwc;
	private RadioButton radioButtonsp;
	private RadioButton radioButtontw;
	private RadioGroup radioGroup;
	private View header;
	private ListView listview;
	private ListView listview1;
	private List<Chuyipriduct> lists;
	private List<Chuyipriduct2> lists2;
	private Chuyipriduct chuyipriduct;
	private Chuyipriduct2 chuyipriduct2;
	private ChuyiAdapter adapter;
	private static final String[] m = { "全部", "渝菜", "川菜", "鲁菜", "粤菜" };
	private Spinner spinner;
	private ArrayAdapter<String> arrayadapter;
	private TextView textViewnyd;
	private TextView textViewrq;
	private ImageView imageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View v = inflater.inflate(R.layout.chuyi, container, false);
		header = LayoutInflater.from(getActivity()).inflate(
				R.layout.chuyi_zhanshi_item, null);
		listview = (ListView) v.findViewById(R.id.chuyi_listview);
		listview.addHeaderView(header);
		listview1 = (ListView) v.findViewById(R.id.chuyi_listview2);
		listview1.addHeaderView(header);
		imageViewss = (ImageView) v.findViewById(R.id.chuyi_gouwuche);
		imageView = (ImageView) v.findViewById(R.id.chuyi_image_spinner);
		imageView.setOnClickListener(onClickListener);
		radioButtonsp = (RadioButton) header.findViewById(R.id.chuyi_shiping);
		radioButtontw = (RadioButton) header.findViewById(R.id.chuyi_tuwen);
		textViewnyd = (TextView) header.findViewById(R.id.chuyi_nanyidu);
		textViewrq = (TextView) header.findViewById(R.id.chuyi_renqi);
		imageViewss.setOnClickListener(onClickListener);
		radioGroup = (RadioGroup) header.findViewById(R.id.chuyi_radiogroup);
		radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
		spinner = (Spinner) header.findViewById(R.id.chuyi_spinner);
		arrayadapter = new ArrayAdapter<String>(getActivity(),
				R.layout.myspinner, m);

		// 设置下拉列表的风格
		arrayadapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// 将adapter 添加到spinner中
		spinner.setAdapter(arrayadapter);
		spinner.setOnItemSelectedListener(onItemSelectedListener);
		// 设置默认值
		spinner.setVisibility(View.VISIBLE);
		getDate();

		return v;
	}

	OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO 自动生成的方法存根

		}
	};

	public void getDate() {
		lists = new ArrayList<Chuyipriduct>();
		for (int i = 0; i < 5; i++) {
			chuyipriduct = new Chuyipriduct();
			chuyipriduct.setImgebf(R.drawable.shipingbofang);
			chuyipriduct.setImgedt(R.drawable.timg1);
			chuyipriduct.setCaiming("龙虾香蕉香菜根");
			chuyipriduct.setUsername("食神");
			lists.add(chuyipriduct);

			chuyipriduct = new Chuyipriduct();
			chuyipriduct.setImgebf(R.drawable.shipingbofang);
			chuyipriduct.setImgedt(R.drawable.timg3);
			chuyipriduct.setCaiming("鸭肠辣椒黄瓜条");
			chuyipriduct.setUsername("厨神");
			lists.add(chuyipriduct);
		}
		ChuyiAdapter chuyiAdapter = new ChuyiAdapter(getActivity(),
				R.layout.chuyi_item, lists);
		listview.setAdapter(chuyiAdapter);
		listview.setOnItemClickListener(onitemClickListener);

	}

	public void getdate() {
		lists2 = new ArrayList<Chuyipriduct2>();
		for (int i = 0; i < 5; i++) {
			chuyipriduct2 = new Chuyipriduct2();
			chuyipriduct2.setImgedt(R.drawable.timg1);
			chuyipriduct2.setCaiming("龙虾香蕉香菜根");
			chuyipriduct2.setUsername("食神");
			lists2.add(chuyipriduct2);

			chuyipriduct2 = new Chuyipriduct2();
			chuyipriduct2.setImgedt(R.drawable.timg3);
			chuyipriduct2.setCaiming("鸭肠辣椒黄瓜条");
			chuyipriduct2.setUsername("厨神");
			lists2.add(chuyipriduct2);
		}
		ChuyiAdapter2 chuyiAdapter = new ChuyiAdapter2(getActivity(),
				R.layout.chuyi_item1, lists2);
		listview1.setAdapter(chuyiAdapter);
		listview1.setOnItemClickListener(onitemClickListener);
	}

	OnItemClickListener onitemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO 自动生成的方法存根
			Toast.makeText(getActivity(), "你点的第" + arg2 + "行",
					Toast.LENGTH_SHORT).show();
		}

	};
	OnClickListener onClickListener = new OnClickListener() {

		@SuppressLint({ "ResourceAsColor", "NewApi" })
		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			Intent intent = new Intent();
			switch (arg0.getId()) {
			case R.id.chuyi_gouwuche:
				intent.setClass(getActivity(), SousuoActivity.class);
				startActivity(intent);
				break;
			case R.id.chuyi_image_spinner:
				spinner.performClick();
				break;
			default:
				break;
			}
		}
	};

	OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {

		@SuppressWarnings("deprecation")
		@SuppressLint("NewApi")
		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO 自动生成的方法存根
			switch (arg0.getCheckedRadioButtonId()) {
			case R.id.chuyi_shiping:
				radioButtonsp.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu4));
				radioButtontw.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu1));
				getDate();
				listview.setVisibility(listview.VISIBLE);
				listview1.setVisibility(listview1.GONE);
				break;
			case R.id.chuyi_tuwen:
				radioButtonsp.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu3));
				radioButtontw.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.denglu2));
				getdate();
				listview1.setVisibility(listview.VISIBLE);
				listview.setVisibility(listview1.GONE);
				break;
			default:
				break;
			}
		}
	};

}
