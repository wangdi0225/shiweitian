package com.wangdi.shiweitian;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Video.Media;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

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
	SQLiteDatabase db;
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
		case R.id.sc_video:
			sc_video();
			break;
		default:
			break;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void chushi() {
		db=getActivity().openOrCreateDatabase("shiweitian", getActivity().MODE_PRIVATE, null);
		
		sp_zl = (Spinner) view.findViewById(R.id.sp_zl);
		sp_nd = (Spinner) view.findViewById(R.id.sp_nd);
		ib_zl = (ImageButton) view.findViewById(R.id.ib_zl);
		ib_nd = (ImageButton) view.findViewById(R.id.ib_nd);	
		ib_nd = (ImageButton) view.findViewById(R.id.ib_nd);
		fabu_video = (Button) view.findViewById(R.id.fabu_video);
		sc_video=(Button) view.findViewById(R.id.sc_video);
		String[] str1 = { "选择菜系种类", "川菜", "粤菜", "湘菜", "鲁菜", "闽菜", "苏菜", "浙菜",
				"徽菜" };
		String[] str2 = { "困难", "一般", "简单" };
		aa_zl = new ArrayAdapter(getActivity(), R.drawable.sp_item, str1);
		aa_nd = new ArrayAdapter(getActivity(), R.drawable.sp_item, str2);
		ib_zl.setOnClickListener(this);
		ib_nd.setOnClickListener(this);
		fabu_video.setOnClickListener(this);
		sc_video.setOnClickListener(this);
	}
	private void sc_video() {
		// TODO 自动生成的方法存根
		Intent i = new Intent();
		i.setType("video/*"); // 设置文件类型
		i.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(i,0);
	}
	File file;
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		
		switch (requestCode) {
		case 0:
			Uri uri=data.getData();
			file=new File(uri.toString());
			
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	
}
