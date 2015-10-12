package com.danny.datastruct.sort;

import android.app.Activity;
import android.os.Bundle;

public class ShellSortActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	void test() {
		ShellSort sort = new ShellSort();
		sort.sort(Sort.chars);
		for (int i=0; i<Sort.chars.length; i++) {
			System.out.print(Sort.chars);
		}
		System.out.println();
	}
}
