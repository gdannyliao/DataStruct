package com.danny.datastruct.queue;

import com.danny.datastruct.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class PriorityQueueActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_priorityqueue);
		
		
	}
	
	void testBiggest(int max) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(max);
	}
}
