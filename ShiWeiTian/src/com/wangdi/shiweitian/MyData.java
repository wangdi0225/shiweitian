package com.wangdi.shiweitian;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
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
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

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
	ImageView fanhui_data, tx_data, mingpian_data;
	LinearLayout dj_diqu, dj_email, dj_mingpian, dj_name, dj_numb, dj_qianming,
			dj_sex;
	TextView name_data, sex_data, diqu_data, qianming, shouji_data,
			youxiang_data, tuichu_data, dj_tx;
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
		name_data = (TextView) findViewById(R.id.name_data);
		mingpian_data = (ImageView) findViewById(R.id.mingpian_data);
		sex_data = (TextView) findViewById(R.id.sex_data);
		diqu_data = (TextView) findViewById(R.id.diqu_data);
		qianming = (TextView) findViewById(R.id.qianming);
		shouji_data = (TextView) findViewById(R.id.shouji_data);
		youxiang_data = (TextView) findViewById(R.id.youxiang_data);
		tuichu_data = (TextView) findViewById(R.id.tuichu_data);
		dj_diqu = (LinearLayout) findViewById(R.id.dj_diqu);
		dj_email = (LinearLayout) findViewById(R.id.dj_email);
		dj_mingpian = (LinearLayout) findViewById(R.id.dj_mingpian);
		dj_name = (LinearLayout) findViewById(R.id.dj_name);
		dj_numb = (LinearLayout) findViewById(R.id.dj_numb);
		dj_qianming = (LinearLayout) findViewById(R.id.dj_qianming);
		dj_sex = (LinearLayout) findViewById(R.id.dj_sex);
		dj_tx = (TextView) findViewById(R.id.dj_tx);
		fanhui_data.setOnClickListener(this);
		
		tx_data.setOnClickListener(this);
		dj_diqu.setOnClickListener(this);
		dj_email.setOnClickListener(this);
		dj_mingpian.setOnClickListener(this);
		dj_name.setOnClickListener(this);
		dj_numb.setOnClickListener(this);
		dj_qianming.setOnClickListener(this);
		dj_sex.setOnClickListener(this);
		dj_tx.setOnClickListener(this);
		tuichu_data.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		Intent intent = new Intent();
		switch (view.getId()) {
		case R.id.fanhui_data:
			intent.setClass(MyData.this, MainActivity.class);
			startActivity(intent);
			break;
		case R.id.dj_tx:
			replaceTx();
			break;
		case R.id.tuichu_data:
			Intent i = new Intent(MyData.this, LoginActivity.class);
			startActivity(i);
			break;
		case R.id.dj_name:
			bjname();
			break;
		case R.id.dj_mingpian:
			bjmingpian();
			break;
		case R.id.dj_numb:
			bjnumb();
			break;
		case R.id.dj_qianming:
			bjqianming();
			break;
		case R.id.dj_sex:
			bjsex();
			break;
		case R.id.dj_email:
			bjemail();
			break;
		case R.id.dj_diqu:
			bjdiqu();
			break;
		case R.id.tx_data:
			kantx();
			break;


		}
	}

	private void replaceTx() {
		new AlertDialog.Builder(this,R.style.AlertDialog_style)
				
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
		intent.putExtra("outputX", 350);
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

	private void bjname() {
		LayoutInflater factory = LayoutInflater.from(MyData.this);
		final View textEntryView = factory.inflate(R.layout.bianji_data, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(MyData.this,
				R.style.AlertDialog_style);
		builder.setView(textEntryView);
		EditText et = (EditText) textEntryView.findViewById(R.id.et);
		et.setText(name_data.getText());
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				TextView iv = (TextView) textEntryView.findViewById(R.id.tv);
				EditText et = (EditText) textEntryView.findViewById(R.id.et);

				String name = et.getText().toString();
				if (name != null) {
					name_data.setText(name);
					Toast.makeText(MyData.this, "编辑成功", Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(MyData.this, "姓名不能为空", Toast.LENGTH_SHORT)
							.show();
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
		});
		builder.setCancelable(true);
		// 对话框的创建、显示
		builder.create().show();
	}

	private void bjmingpian() {
		LayoutInflater factory = LayoutInflater.from(MyData.this);
		final View textEntryView = factory
				.inflate(R.layout.mingpian_item, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(MyData.this,
				R.style.AlertDialog_style);
		builder.setView(textEntryView);
		TextView tv = (TextView) textEntryView.findViewById(R.id.tv);
		tv.setText("我的二维码");
		
		ImageView iv = (ImageView) textEntryView.findViewById(R.id.iv);
		iv.setImageResource(R.drawable.ewm);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				dialog.dismiss();
			}
		});
		builder.setCancelable(true);
		// 对话框的创建、显示
		builder.create().show();
	}

	private void bjsex() {
		String[] str = { "男", "女" };
		new AlertDialog.Builder(MyData.this, R.style.AlertDialog_style)
				.setItems(str, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO 自动生成的方法存根
						switch (which) {
						case 0:
							sex_data.setText("男");

							break;
						case 1:
							sex_data.setText("女");
							break;
						default:
							break;
						}
						dialog.dismiss();
					}
				}).create().show();

	}
	private void kantx() {
		LayoutInflater factory = LayoutInflater.from(MyData.this);
		final View textEntryView = factory
				.inflate(R.layout.mingpian_item, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(MyData.this,
				R.style.AlertDialog_style);
		builder.setView(textEntryView);
		TextView tv = (TextView) textEntryView.findViewById(R.id.tv);
		tv.setText("我的头像");
		Drawable d=tx_data.getBackground();
		ImageView iv = (ImageView) textEntryView.findViewById(R.id.iv);
		iv.setBackgroundDrawable(d);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				dialog.dismiss();
			}
		});
		builder.setCancelable(true);
		// 对话框的创建、显示
		builder.create().show();
	}
	private void bjdiqu() {
		LayoutInflater factory = LayoutInflater.from(MyData.this);
		final View textEntryView = factory.inflate(R.layout.bianji_data, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(MyData.this,
				R.style.AlertDialog_style);

		builder.setView(textEntryView);
		TextView iv = (TextView) textEntryView.findViewById(R.id.tv);
		iv.setText("地区");
		EditText et = (EditText) textEntryView.findViewById(R.id.et);
		et.setText(diqu_data.getText());
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				TextView iv = (TextView) textEntryView.findViewById(R.id.tv);
				EditText et = (EditText) textEntryView.findViewById(R.id.et);

				String name = et.getText().toString();
				if (name != null) {
					diqu_data.setText(name);
					Toast.makeText(MyData.this, "编辑成功", Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(MyData.this, "地区不能为空", Toast.LENGTH_SHORT)
							.show();
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
		});
		builder.setCancelable(true);
		// 对话框的创建、显示
		builder.create().show();
	}

	private void bjqianming() {
		LayoutInflater factory = LayoutInflater.from(MyData.this);
		final View textEntryView = factory.inflate(R.layout.bianji_qianming, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(MyData.this,
				R.style.AlertDialog_style);

		builder.setView(textEntryView);
		TextView iv = (TextView) textEntryView.findViewById(R.id.tv);
		iv.setText("个性签名");
		EditText et = (EditText) textEntryView.findViewById(R.id.et);
		et.setText(qianming.getText());
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				TextView iv = (TextView) textEntryView.findViewById(R.id.tv);
				EditText et = (EditText) textEntryView.findViewById(R.id.et);

				String name = et.getText().toString();
				if (name != null) {
					qianming.setText(name);
					Toast.makeText(MyData.this, "编辑成功", Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(MyData.this, "地区不能为空", Toast.LENGTH_SHORT)
							.show();
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
		});
		builder.setCancelable(true);
		// 对话框的创建、显示
		builder.create().show();
	}

	
	private void bjnumb() {
		LayoutInflater factory = LayoutInflater.from(MyData.this);
		final View textEntryView = factory.inflate(R.layout.bianji_data, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(MyData.this,
				R.style.AlertDialog_style);

		builder.setView(textEntryView);
		TextView iv = (TextView) textEntryView.findViewById(R.id.tv);
		iv.setText("手机号");
		EditText et = (EditText) textEntryView.findViewById(R.id.et);
		et.setText(shouji_data.getText());
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				TextView iv = (TextView) textEntryView.findViewById(R.id.tv);
				EditText et = (EditText) textEntryView.findViewById(R.id.et);

				String name = et.getText().toString();
				if (name != null) {
					shouji_data.setText(name);
					Toast.makeText(MyData.this, "编辑成功", Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(MyData.this, "地区不能为空", Toast.LENGTH_SHORT)
							.show();
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
		});
		builder.setCancelable(true);
		// 对话框的创建、显示
		builder.create().show();
	}

	private void bjemail() {
		LayoutInflater factory = LayoutInflater.from(MyData.this);
		final View textEntryView = factory.inflate(R.layout.bianji_data, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(MyData.this,
				R.style.AlertDialog_style);

		builder.setView(textEntryView);
		TextView iv = (TextView) textEntryView.findViewById(R.id.tv);
		iv.setText("邮箱");
		EditText et = (EditText) textEntryView.findViewById(R.id.et);
		et.setText(youxiang_data.getText());
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				TextView iv = (TextView) textEntryView.findViewById(R.id.tv);
				EditText et = (EditText) textEntryView.findViewById(R.id.et);

				String name = et.getText().toString();
				if (name != null) {
					youxiang_data.setText(name);
					Toast.makeText(MyData.this, "编辑成功", Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(MyData.this, "地区不能为空", Toast.LENGTH_SHORT)
							.show();
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
		});
		builder.setCancelable(true);
		// 对话框的创建、显示
		builder.create().show();
	}

}
