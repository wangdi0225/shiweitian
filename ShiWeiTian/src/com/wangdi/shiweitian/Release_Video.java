package com.wangdi.shiweitian;

import android.content.Intent;
import android.media.Image;
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

import com.wangdi.shiweitian.R;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class Release_Video extends Fragment implements OnClickListener {
	Button sc_video;
	ImageButton ib_zl, ib_nd;
	Spinner sp_zl, sp_nd;
	ArrayAdapter aa_zl,aa_nd;
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

		default:
			break;
		}
	}

	private void chushi() {
		sp_zl = (Spinner) view.findViewById(R.id.sp_zl);
		sp_nd = (Spinner) view.findViewById(R.id.sp_nd);
		ib_zl = (ImageButton) view.findViewById(R.id.ib_zl);
		ib_nd = (ImageButton) view.findViewById(R.id.ib_nd);	
		String[] str1 = { "选择菜系种类", "川菜", "粤菜", "湘菜", "鲁菜", "闽菜", "苏菜", "浙菜",
				"徽菜" };
		String[] str2 = { "困难", "一般", "简单" };
		aa_zl = new ArrayAdapter(getActivity(), R.drawable.sp_item, str1);
		aa_nd = new ArrayAdapter(getActivity(), R.drawable.sp_item, str2);
		ib_zl.setOnClickListener(this);
		ib_nd.setOnClickListener(this);
	}
}
