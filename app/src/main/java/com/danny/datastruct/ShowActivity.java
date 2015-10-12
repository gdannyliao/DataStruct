package com.danny.datastruct;

import android.app.Activity;
import android.os.Bundle;

public class ShowActivity extends Activity {
	public final static String TYPE_ALGORITHM = "typeAlgorithm";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_show);
		DrawSurfaceView drawView = (DrawSurfaceView) findViewById(R.id.drawSurfaceView);

		String algo = getIntent().getStringExtra(TYPE_ALGORITHM);
		String[] array = getResources().getStringArray(R.array.data_struct_types);
		AlgorithmRunnable runnable = AlgorithmRunnable
				.getAlgorithmRunnable(array, algo);
		if (runnable != null) {
			
			drawView.setAlgorithmRunnable(runnable);
		}
	}

}
