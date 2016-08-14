package com.wangdi.shiweitian;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wangdi.shiweitian.R;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class Release_Image extends Fragment {
	View view;
	Button sc_image;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view= inflater.inflate(R.layout.release_image, container, false);
		chushi();
		return view;
	}
	private void chushi(){
		sc_image=(Button) view.findViewById(R.id.sc_image);
	}
	private void sc_image() {
		
	}
}
