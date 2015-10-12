package com.danny.datastruct.sort;

import com.danny.datastruct.AlgorithmRunnable;
import com.danny.datastruct.Cell;

public class InsertionRunnable extends AlgorithmRunnable {
	
	/**
	 * 1对于每个元素
	 * 2依次与左边的比较
	 * 3小于则交换，大于则终止
	 */
	public void sort(Comparable[] arr) {
		for (int i=1; i<arr.length; i++) {
			for (int j=i; j>0 && Sort.less(arr[j], arr[j-1]); j--) {
				Sort.exch(arr, j, j-1);
			}
		}
	}
	
	@Override
	public void run() {
		for (int i=1; i<mCells.size() && isRunning; i++) {
			final Cell cell = mCells.get(i);
			cell.setDrawing(true);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			for (int j=i; j>0 && 
					mCells.get(j).compareTo(mCells.get(j-1)) < 0; j--) {
				Cell smaller = mCells.get(j-1);
				Cell larger = mCells.get(j);
				exch(smaller, larger);
				
				mCells.set(j, mCells.get(j-1));
				mCells.set(j-1, larger);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			cell.setDrawing(false);
		}
		isRunning = false;
	}

}
