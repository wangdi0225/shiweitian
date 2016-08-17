package com.wangdi.shiweitian;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Video.Media;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.wangdi.shiweitian.R;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class Release_Image extends Fragment  implements OnClickListener {
	private static final int CHUAN_1=1;
	Button sc_image,fabu_image;
	ImageButton ib_zl, ib_nd;
	Spinner sp_zl, sp_nd;
	ArrayAdapter aa_zl,aa_nd;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.release_image, container, false);
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
		case R.id.sc_image:
			xiangji();
			break;
		case R.id.fabu_image:
			Toast.makeText(getActivity(), "已发布", Toast.LENGTH_SHORT).show();
			Intent i=new Intent(getActivity(),Released.class);
			startActivity(i);
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
		sc_image = (Button) view.findViewById(R.id.sc_image);
		fabu_image = (Button) view.findViewById(R.id.fabu_image);
				
		String[] str1 = { "选择菜系种类", "川菜", "粤菜", "湘菜", "鲁菜", "闽菜", "苏菜", "浙菜",
				"徽菜" };
		String[] str2 = { "困难", "一般", "简单" };
		aa_zl = new ArrayAdapter(getActivity(), R.drawable.sp_item, str1);
		aa_nd = new ArrayAdapter(getActivity(), R.drawable.sp_item, str2);
		ib_zl.setOnClickListener(this);
		ib_nd.setOnClickListener(this);
		sc_image.setOnClickListener(this);
		fabu_image.setOnClickListener(this);
	}
	private void xiangji() {
		Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(i, CHUAN_1);
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		super.onActivityResult(requestCode, resultCode, data);
			if(requestCode==CHUAN_1){
				Bundle bundle=data.getExtras();
				Bitmap bitmap=(Bitmap) bundle.get("data");
				Media media=(Media) bundle.get("data");
				Drawable drawable = new BitmapDrawable(bitmap);
				
				
			}
	}
}
