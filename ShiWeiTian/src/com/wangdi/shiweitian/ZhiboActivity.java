package com.wangdi.shiweitian;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ZhiboActivity extends Activity {

	Spinner spinner;
	ArrayAdapter<String> arrayAdapter;
	String strs[] = {"选择菜品类别","川菜","湘菜","粤菜","鲁菜"};
    OnItemSelectedListener itemClickListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhibo_jiaoyue_item);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, strs);
		
		
		Spinner spinner=(Spinner)findViewById(R.id.zhibo_spinner);
		
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(itemClickListener);
		

	}

	OnItemSelectedListener itemSelectedListener=new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			Log.i("parent",""+parent);
			
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}};
	
	
	
}
