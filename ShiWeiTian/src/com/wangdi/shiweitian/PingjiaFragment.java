package com.wangdi.shiweitian;

import java.util.List;
import java.util.Map;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class PingjiaFragment extends Fragment {

	ListView listView_pingjia;
	SimpleAdapter simpleAdpter;
	View v;
	List<Map<String, Object>> list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		v = inflater.inflate(R.layout.fragment_pingjia, container, false);

		return v;
	}

	private void chushi() {
		listView_pingjia = (ListView) v.findViewById(R.id.pingjia_listView);

		String[] from = {};
		int[] to = {};

		simpleAdpter = new SimpleAdapter(getActivity(), list,
				R.layout.quanbu_dingdan_item, from, to);

	}
}
