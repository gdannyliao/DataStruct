package com.danny.datastruct;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class StructListFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_structlist, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String[] stringArray = getResources().getStringArray(R.array.data_struct_types);
				Intent intent = null;
				intent = new Intent(getActivity(), ShowActivity.class);

				if (intent != null) {
					intent.putExtra(ShowActivity.TYPE_ALGORITHM, stringArray[position]);
					startActivity(intent);
				}
			}
		});
	}
}