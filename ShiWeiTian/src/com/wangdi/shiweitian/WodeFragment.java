package com.wangdi.shiweitian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WodeFragment extends Fragment {
	LinearLayout layoutqbdd;
	LinearLayout layouthykt;
	LinearLayout layoutyfb;
	LinearLayout layoutfb;
	LinearLayout layoutgrzl;
	LinearLayout layoutsc;
	LinearLayout layoutjl;
	TextView textViewdfk;
	TextView textViewdfh;
	TextView textViewdsh;
	TextView textViewdpj;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View v = inflater.inflate(R.layout.wode, container, false);
		layoutqbdd = (LinearLayout) v.findViewById(R.id.wode_quanbudingdan);
		layouthykt = (LinearLayout) v.findViewById(R.id.wode_huiyuankaitong);
		layoutyfb = (LinearLayout) v.findViewById(R.id.wode_yifabudezuoping);
		layoutfb = (LinearLayout) v.findViewById(R.id.wode_fabuxinzuoping);
		layoutgrzl = (LinearLayout) v.findViewById(R.id.wode_gerenziliao);
		layoutsc = (LinearLayout) v.findViewById(R.id.wode_wodeshoucang);
		layoutjl = (LinearLayout) v.findViewById(R.id.wode_zuijinliulanjilu);
		layoutqbdd.setOnTouchListener(onTouchListener);
		layouthykt.setOnTouchListener(onTouchListener);
		layoutyfb.setOnTouchListener(onTouchListener);
		layoutfb.setOnTouchListener(onTouchListener);
		layoutgrzl.setOnTouchListener(onTouchListener);
		layoutsc.setOnTouchListener(onTouchListener);
		layoutjl.setOnTouchListener(onTouchListener);
		textViewdfk = (TextView) v.findViewById(R.id.wode_daifukuan);
		textViewdfh = (TextView) v.findViewById(R.id.wode_daifahuo);
		textViewdsh = (TextView) v.findViewById(R.id.wode_daishouhuo);
		textViewdpj = (TextView) v.findViewById(R.id.wode_daipingjia);
		textViewdfk.setOnClickListener(onClickListener);
		textViewdfh.setOnClickListener(onClickListener);
		textViewdsh.setOnClickListener(onClickListener);
		textViewdpj.setOnClickListener(onClickListener);
		return v;
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO 自动生成的方法存根
			switch (arg0.getId()) {
			case R.id.wode_daifukuan:
				Toast.makeText(getActivity(), "点啥", Toast.LENGTH_SHORT).show();
				break;
			case R.id.wode_daifahuo:
				Toast.makeText(getActivity(), "点啥", Toast.LENGTH_SHORT).show();
				break;
			case R.id.wode_daishouhuo:
				Toast.makeText(getActivity(), "点啥", Toast.LENGTH_SHORT).show();
				break;
			case R.id.wode_daipingjia:
				Toast.makeText(getActivity(), "点啥", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	};

	OnTouchListener onTouchListener = new OnTouchListener() {

		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			// TODO 自动生成的方法存根
			Intent intent = new Intent();
			switch (arg0.getId()) {
			case R.id.wode_quanbudingdan:
				Toast.makeText(getActivity(), "点啥", Toast.LENGTH_SHORT).show();
				break;
			case R.id.wode_huiyuankaitong:

				intent.setClass(getActivity(), MembersAcitivity.class);
				startActivity(intent);
				break;
			case R.id.wode_yifabudezuoping:
				intent.setClass(getActivity(), Released.class);
				startActivity(intent);
				break;
			case R.id.wode_fabuxinzuoping:
				intent.setClass(getActivity(), Release.class);
				startActivity(intent);
				break;
			case R.id.wode_gerenziliao:
				intent.setClass(getActivity(), MyData.class);
				startActivity(intent);
				break;
			case R.id.wode_wodeshoucang:
				Toast.makeText(getActivity(), "点啥", Toast.LENGTH_SHORT).show();
				break;
			case R.id.wode_zuijinliulanjilu:
				Toast.makeText(getActivity(), "点啥", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
			return false;
		}
	};
}
