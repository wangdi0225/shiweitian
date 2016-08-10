package com.wangdi.shiweitian.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
	ArrayList<Fragment> fragmentList;

	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO 自动生成的构造函数存根
	}

	public MyAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
		super(fm);
		this.fragmentList = fragmentList;
		// TODO 自动生成的构造函数存根
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO 自动生成的方法存根
		return fragmentList.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return fragmentList.size();
	}

}