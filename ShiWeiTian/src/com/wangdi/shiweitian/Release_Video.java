package com.wangdi.shiweitian;


import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class Release_Video extends Fragment implements OnClickListener {

	Button sc_video,fabu_video;
	ImageButton ib_zl, ib_nd;
	Spinner sp_zl, sp_nd;
	@SuppressWarnings("rawtypes")
	ArrayAdapter aa_zl, aa_nd;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.release_video, container, false);
		chushi();
		sp_zl.setAdapter(aa_zl);
		sp_nd.setAdapter(aa_nd);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.ib_zl:
			sp_zl.performClick();
			break;
		case R.id.ib_nd:
			sp_nd.performClick();
			break;
		case R.id.fabu_video:
			Intent i=new Intent(getActivity(),Released.class);
			startActivity(i);
			Toast.makeText(getActivity(), "已发布", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void chushi() {
		sp_zl = (Spinner) view.findViewById(R.id.sp_zl);
		sp_nd = (Spinner) view.findViewById(R.id.sp_nd);
		ib_zl = (ImageButton) view.findViewById(R.id.ib_zl);
		ib_nd = (ImageButton) view.findViewById(R.id.ib_nd);	
		ib_nd = (ImageButton) view.findViewById(R.id.ib_nd);
		fabu_video = (Button) view.findViewById(R.id.fabu_video);
		String[] str1 = { "选择菜系种类", "川菜", "粤菜", "湘菜", "鲁菜", "闽菜", "苏菜", "浙菜",
				"徽菜" };
		String[] str2 = { "困难", "一般", "简单" };
		aa_zl = new ArrayAdapter(getActivity(), R.drawable.sp_item, str1);
		aa_nd = new ArrayAdapter(getActivity(), R.drawable.sp_item, str2);
		ib_zl.setOnClickListener(this);
		ib_nd.setOnClickListener(this);
		fabu_video.setOnClickListener(this);
	}
}
