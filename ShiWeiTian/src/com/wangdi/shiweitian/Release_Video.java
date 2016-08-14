package com.wangdi.shiweitian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.wangdi.shiweitian.R;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class Release_Video extends Fragment implements OnClickListener{
	Button sc_video;
	View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	view=inflater.inflate(R.layout.release_video,container,false);
        return view;
    }
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		
	}
}
