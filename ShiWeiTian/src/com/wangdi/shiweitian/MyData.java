package com.wangdi.shiweitian;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wangdi.shiweitian.R;

;

/**
 * Created by Administrator on 2016/8/5 0005.
 */
public class MyData extends Activity implements View.OnClickListener {
	ImageView fanhui_data, tx_data;
	TextView bianji_data, name_data, mingpian_data, sex_data, diqu_data,
			qianming_data, shouji_data, youxiang_data, tuichu_data;
	private String[] items = new String[] { "选择本地图片", "拍照" };
	private static final String IMAGE_FILE_NAME = "rub_course_default_user_icon.png";
	private static final int IMAGE_REQUEST_CODE = 0;
	private static final int CAMERA_REQUEST_CODE = 1;
	private static final int RESULT_REQUEST_CODE = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mydata);
		chushi();

	}

	public void chushi() {
		fanhui_data = (ImageView) findViewById(R.id.fanhui_data);
		tx_data = (ImageView) findViewById(R.id.tx_data);
		bianji_data = (TextView) findViewById(R.id.bianji_data);
		name_data = (TextView) findViewById(R.id.name_data);
		mingpian_data = (TextView) findViewById(R.id.mingpian_data);
		sex_data = (TextView) findViewById(R.id.sex_data);
		diqu_data = (TextView) findViewById(R.id.diqu_data);
		qianming_data = (TextView) findViewById(R.id.qianming_data);
		shouji_data = (TextView) findViewById(R.id.shouji_data);
		youxiang_data = (TextView) findViewById(R.id.youxiang_data);
		tuichu_data = (TextView) findViewById(R.id.tuichu_data);
		fanhui_data.setOnClickListener(this);
		tx_data.setOnClickListener(this);
		name_data.setOnClickListener(this);
		mingpian_data.setOnClickListener(this);
		sex_data.setOnClickListener(this);
		diqu_data.setOnClickListener(this);
		qianming_data.setOnClickListener(this);
		shouji_data.setOnClickListener(this);
		youxiang_data.setOnClickListener(this);
		tuichu_data.setOnClickListener(this);
		bianji_data.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		Intent intent = new Intent();
		switch (view.getId()) {
		case R.id.fanhui_data:
			intent.setClass(MyData.this, MainActivity.class);
			startActivity(intent);
			break;
		case R.id.tx_data:
			replaceTx();
			break;
		case R.id.bianji_data:
			bianji();
			break;
		case R.id.name_data:
			break;
		case R.id.mingpian_data:
			break;
		case R.id.sex_data:
			break;
		case R.id.diqu_data:
			break;
		case R.id.qianming_data:
			break;
		case R.id.shouji_data:
			break;
		case R.id.youxiang_data:
			break;
		case R.id.tuichu_data:
			break;

		}
	}

	String sex1;

	private void bianji() {
		// LayoutInflater是用来找layout文件夹下的xml布局文件，并且实例化
		LayoutInflater factory = LayoutInflater.from(MyData.this);
		// 把activity_login中的控件定义在View中
		final View textEntryView = factory.inflate(R.layout.data_view, null);
		// 将LoginActivity中的控件显示在对话框中
		new AlertDialog.Builder(MyData.this)
				// 对话框的标题
				.setTitle("编辑信息")
				// 设定显示的View
				.setView(textEntryView)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

						// 注意：textEntryView.findViewById很重要，因为上面factory.inflate(R.layout.activity_login,
						// null)将页面布局赋值给了textEntryView了
						final EditText etname = (EditText) textEntryView
								.findViewById(R.id.etname);
						final EditText etsjh = (EditText) textEntryView
								.findViewById(R.id.etsjh);
						final EditText etqianming = (EditText) textEntryView
								.findViewById(R.id.etqianming);
						final EditText etdiqu = (EditText) textEntryView
								.findViewById(R.id.etdiqu);
						final EditText etyouxiang = (EditText) textEntryView
								.findViewById(R.id.etyouxiang);
						final RadioGroup rg_data = (RadioGroup) textEntryView
								.findViewById(R.id.rg_data); // 将页面输入框中获得的“用户名”，“密码”转为字符串
						String name = etname.getText().toString().trim();
						String sjh = etsjh.getText().toString().trim();
						String qianming = etqianming.getText().toString()
								.trim();
						String youxiang = etyouxiang.getText().toString()
								.trim();
						String shouji = etsjh.getText().toString().trim();
						String diqu = etqianming.getText().toString().trim();
						// 现在为止已经获得了字符型的用户名和密码了，接下来就是根据自己的需求来编写代码了
						// 这里做一个简单的测试，假定输入的用户名和密码都是1则进入其他操作页面（OperationActivity）
						if (!name.equals("")) {
							name_data.setText(name);
							rg_data.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
								@Override
								public void onCheckedChanged(
										RadioGroup radioGroup, int i) {
									switch (i) {
									case R.id.nan:
										sex_data.setText("男");
										break;
									case R.id.nv:
										sex_data.setText("女");
										break;
									}
								}
							});
							diqu_data.setText(diqu);
							qianming_data.setText(qianming);
							shouji_data.setText(shouji);
							youxiang_data.setText(youxiang);
							Toast.makeText(MyData.this, "编辑成功",
									Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(MyData.this, "姓名不能为空",
									Toast.LENGTH_SHORT).show();
							try {
								// 注意此处是通过反射，修改源代码类中的字段mShowing为true，系统会认为对话框打开
								// 从而调用dismiss()
								Field field = dialog.getClass().getSuperclass()
										.getDeclaredField("mShowing");
								field.setAccessible(true);
								field.set(dialog, false);
								dialog.dismiss();
							} catch (Exception e) {
							}
						}
					}
				})
				// 对话框的“退出”单击事件
				.setNegativeButton("退出", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						MyData.this.finish();
					}
				})
				// 设置dialog是否为模态，false表示模态，true表示非模态
				.setCancelable(false)
				// 对话框的创建、显示
				.create().show();
	}

	private void replaceTx() {
		new AlertDialog.Builder(this)
				.setTitle("设置头像")
				.setItems(items, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						case 0:
							Intent intentFromGallery = new Intent();
							intentFromGallery.setType("image/*"); // 设置文件类型
							intentFromGallery
									.setAction(Intent.ACTION_GET_CONTENT);
							startActivityForResult(intentFromGallery,
									IMAGE_REQUEST_CODE);
							break;
						case 1:
							Intent intentFromCapture = new Intent(
									MediaStore.ACTION_IMAGE_CAPTURE);
							// 判断存储卡是否可以用，可用进行存储
							if (hasSdcard()) {
								intentFromCapture.putExtra(
										MediaStore.EXTRA_OUTPUT,
										Uri.fromFile(new File(Environment
												.getExternalStorageDirectory(),
												IMAGE_FILE_NAME)));
							}
							startActivityForResult(intentFromCapture,
									CAMERA_REQUEST_CODE);
							break;
						}
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				}).show();
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case IMAGE_REQUEST_CODE:
			startPhotoZoom(data.getData());
			break;
		case CAMERA_REQUEST_CODE:
			if (hasSdcard()) {
				File tempFile = new File(
						Environment.getExternalStorageDirectory()
								+ IMAGE_FILE_NAME);
				startPhotoZoom(Uri.fromFile(tempFile));
			} else {
				Toast.makeText(MyData.this, "未找到存储卡，无法存储照片！", Toast.LENGTH_LONG)
						.show();
			}
			break;
		case RESULT_REQUEST_CODE:
			if (data != null) {
				tx_data.setBackgroundDrawable(getImageToView(data));
			}
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void startPhotoZoom(Uri uri) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// 设置裁剪
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 320);
		intent.putExtra("outputY", 320);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, 2);
	}

	private Drawable getImageToView(Intent data) {
		Bundle extras = data.getExtras();
		if (extras != null) {
			Bitmap photo = extras.getParcelable("data");
			Drawable drawable = new BitmapDrawable(photo);
			return drawable;
		}
		return null;
	}

	public static boolean hasSdcard() {
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}
}
