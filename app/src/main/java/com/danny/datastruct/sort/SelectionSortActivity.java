package com.danny.datastruct.sort;

import android.app.Activity;
import android.os.Bundle;

public class SelectionSortActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		testSelectionSort();
	}
	
	 void testSelectionSort() {
		SelectionSort sort = new SelectionSort();
		sort.sort(Sort.chars);
		System.out.print("selection sorted: ");
		Comparable[] chars = Sort.chars;
		for (int i = 1; i < chars.length; i++) {
			Comparable c = chars[i];
			System.out.print(c);
		}
		System.out.println();
	}
}
