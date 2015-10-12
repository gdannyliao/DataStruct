package com.danny.datastruct.string;

import android.app.Activity;
import android.os.Bundle;

public class KMPActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		testKMP();
	}
	
	void testKMP() {
		String s = "abaaaabaaaaaaaa";
		String p = "baaaaa";
				
		Kmp kmp = new Kmp();
		int result = kmp.kmp(s, p);
		System.out.println("matched at: " + result);
	}
}
