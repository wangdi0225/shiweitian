package com.wangdi.shiweitian;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Video.Media;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wangdi.shiweitian.R;
import com.wangdi.shiweitian.R.drawable;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class Release_Image extends Fragment  implements OnClickListener {
	Button sc_image,fabu_image;
	ImageButton ib_zl, ib_nd;
	TextView image_file;
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
			sc_image();
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
	private void sc_image() {
		// TODO 自动生成的方法存根
		Intent i = new Intent();
		i.setType("image/*"); // 设置文件类型
		i.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(i,0);
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		
		switch (requestCode) {
		case 0:
			openxiangce(data.getData());
			break;
		case 1:
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {//如果有内存卡
				File file = new File(Environment.getExternalStorageDirectory(), "tp");
				openxiangce(Uri.fromFile(file));
			} else {
				Toast.makeText(getActivity(), "未找到存储卡，无法存储照片！", Toast.LENGTH_LONG).show();
			}
			break;
		case 2:
			if (data != null) {
			Bundle bundle=data.getExtras();
			Bitmap bitmap= (Bitmap) bundle.get("data");
			cuntx(bitmap);
			qutx();
			}
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	private void openxiangce(Uri uri) {//打开系统相册
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");	// 设置裁剪
		intent.putExtra("aspectX", 1);// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 350);// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputY", 320);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, 2);
	}

	private void chushi() {
		sp_zl = (Spinner) view.findViewById(R.id.sp_zl);
		sp_nd = (Spinner) view.findViewById(R.id.sp_nd);
		ib_zl = (ImageButton) view.findViewById(R.id.ib_zl);
		ib_nd = (ImageButton) view.findViewById(R.id.ib_nd);
		sc_image = (Button) view.findViewById(R.id.sc_image);
		fabu_image = (Button) view.findViewById(R.id.fabu_image);
		image_file=(TextView) view.findViewById(R.id.image_file);
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
	String sj =System.currentTimeMillis()+"";
	String tpname="TX"+sj;
	String fileName = Environment.getExternalStorageDirectory() +"/"+tpname+".png"; 
	private void cuntx(Bitmap bitmap) {
		 Log.i("123", tpname);
		File file=new File(fileName);
		
		 if(!file.exists()){  
		        try {  
		            file.createNewFile() ;  
		            FileOutputStream fileOutputStream = new FileOutputStream(file) ;  
		            bitmap.compress(CompressFormat.PNG, 50, fileOutputStream) ;  
		            Toast.makeText(getActivity(), "存入成功", Toast.LENGTH_SHORT).show();   
		            fileOutputStream.close();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		    }  
	}
	private void qutx() {
		 File file = new File(fileName) ;  
		    if(file.exists()){  
		        Bitmap bitmap = BitmapFactory.decodeFile(fileName) ;
		       Drawable drawable=  new BitmapDrawable(bitmap);
		        
		        image_file.setText(tpname+".png");
		    }  
	}

}
