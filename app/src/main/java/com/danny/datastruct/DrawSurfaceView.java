package com.danny.datastruct;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * 该类会开启一个线程不断地绘制列表中的数据，使用该类，只需要传入一个
 * @author jkl
 *
 */
public class DrawSurfaceView extends SurfaceView {

	private static final String TAG = "DrawSurfaceView";

	//用来绘制方块背景的画笔
	private Paint mCellPaint;
	//用于绘制文字的画笔
	private Paint mTextPaint;
	//绘制线程，每秒大概40帧
	private DrawRunnable mDrawRunnable;
	//绘制线程是否正在工作
	private volatile boolean isRunning;
	//储存演示数据的结构
	private ListArray<Cell> mCells;
	private ListArray<Cell> mDrawers;
	
	//方块的宽度
	private int mRectWidth = 60;
	//初始x点
	private int initialx = 20;
	//初始y点
	private int initialy = 20;
	//方块之间的间隔
	private int interval = 10;
	//用于存储用户正在拖动的单元
	private Cell mTouchTarget;

	private AlgorithmRunnable mAlgorithmRunnable;

	private static ExecutorService mExecutor;
	
	public DrawSurfaceView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (isInEditMode())
			return ;
	}

	public DrawSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if (isInEditMode())
			return ;
	}

	public DrawSurfaceView(Context context) {
		super(context);
		if (isInEditMode())
			return ;
	}

	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		getHolder().addCallback(new SurfaceCallback());
		
		mCells = new ListArray<Cell>();
		mDrawers = new ListArray<Cell>();
		
		mCellPaint = new Paint();
		mCellPaint.setColor(Color.BLUE);
		mTextPaint = new Paint();
		mTextPaint.setColor(Color.WHITE);
		mTextPaint.setAntiAlias(true);
		mTextPaint.setTextSize(22);
		
		if (mExecutor == null)
			mExecutor = Executors.newCachedThreadPool();
		mDrawRunnable = new DrawRunnable();
		
	}
	
	public void setAlgorithmRunnable(AlgorithmRunnable run) {
		if (run == null)
			return ;
		
		mAlgorithmRunnable = run;
		run.setCells(mCells);
		run.setDrawers(mDrawers);
		postDelayed(new Runnable() {
			
			@Override
			public void run() {
				mAlgorithmRunnable.isRunning = true;
				mExecutor.execute(mAlgorithmRunnable);
			}
		}, 1000);
	}

	@Override
	@SuppressLint("ClickableViewAccessibility")
	public boolean onTouchEvent(MotionEvent event) {
		float touchx = event.getX();
		float touchy = event.getY();
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			for (Cell rect : mDrawers) {
				if (rect.getRect().contains((int) touchx, (int) touchy)) {
					Log.d(TAG, "touch hint rect");
					mAlgorithmRunnable.setRunning(false);
					
					mTouchTarget = rect;
					rect.getRect().offsetTo(touchx - rect.width()/2, touchy - rect.height()/2);
					return true;
				}
			}
			break;
		case MotionEvent.ACTION_MOVE:
			if (mTouchTarget != null)
				mTouchTarget.getRect().offsetTo(touchx - mTouchTarget.width()/2, touchy - mTouchTarget.height()/2);
			return true;
		case MotionEvent.ACTION_UP:
			mTouchTarget = null;
			return true;
		}
		return super.onTouchEvent(event);
	}

	private class SurfaceCallback implements Callback{
//TODO 绘制一个数组保存轨迹
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			if (mDrawRunnable != null && mDrawRunnable != null) {
				if (!isRunning) {
					isRunning = true;
					mExecutor.execute(mDrawRunnable);
				}
			}
			int width = getWidth();
			int height = getHeight();
			initialy = height / 2 - mRectWidth;
			width -= initialx;
			int count = width / (mRectWidth + interval);
			
			Random rand = new Random();
			char base = 'A';
			for (int i=0; i<count; i++) {
				Cell cell = new Cell();
				cell.setRect(new RectF(initialx + i*(mRectWidth+interval)
						, initialy, initialx+i*(mRectWidth+interval)+mRectWidth
						, mRectWidth + initialy));
				cell.setText((char) (base + rand.nextInt(26)));
				mCells.add(cell);
				mDrawers.add(cell);
			}
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			isRunning = false;
		}
	}
	
	private class DrawRunnable implements Runnable {
		
		private void drawPicture() {
			Canvas canvas = getHolder().lockCanvas();
			if (canvas != null) {
				canvas.drawColor(Color.BLACK);
				for (Cell cell : mDrawers) {
					if (cell == null)
						continue;
					if (cell.isDrawing()) {
						mCellPaint.setColor(Color.RED);
					} else mCellPaint.setColor(Color.BLUE);
					
					canvas.drawRect(cell.getRect(), mCellPaint);
					if (cell.getText() > 0) {
						canvas.drawText(String.valueOf(cell.getText())
								, cell.getCenterX(), cell.getCenterY(), mTextPaint);
					}
				}
				getHolder().unlockCanvasAndPost(canvas);
			}
		}
		
		@Override
		public void run() {
			while (isRunning) {
				drawPicture();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
