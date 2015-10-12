package com.danny.datastruct;

import com.danny.datastruct.sort.InsertionRunnable;
import com.danny.datastruct.sort.MergeSortRunnable;


public abstract class AlgorithmRunnable implements Runnable, Cloneable {
	protected volatile boolean isRunning = false;
	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean run) {
		this.isRunning = run;
	}

	protected ListArray<Cell> mCells;
	protected ListArray<Cell> mDrawers;

	public void setCells(final ListArray<Cell> mCells) {
		this.mCells = mCells;
	}
	
	public void setDrawers(ListArray<Cell> drawers) {
		mDrawers = drawers;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected AlgorithmRunnable clone() throws CloneNotSupportedException {
		ListArray<Cell> newCells = (ListArray<Cell>) mCells.clone();
		AlgorithmRunnable newRunnable = (AlgorithmRunnable) super.clone();
		newRunnable.setCells(newCells);
		return newRunnable;
	}

	public static AlgorithmRunnable getAlgorithmRunnable(String[] arrays, String type) {
		if (arrays == null || arrays.length == 0) {
			throw new IllegalArgumentException("you can not send a empty arrays");
		}
		for (int i = 0; i < arrays.length; i++) {
			String s = arrays[i];
			if (s.equals(type)) {
				switch (i) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
					return new InsertionRunnable();
				case 7:
				case 8:
					return new MergeSortRunnable();
				case 9:
				}
			}
		}
		return null;
	}
	
	protected void exch(Cell to, Cell from) {
		float[] smallEdges = to.getAngles();
		to.getRect().set(from.getRect());
		from.getRect().set(smallEdges[0], smallEdges[1]
				, smallEdges[2], smallEdges[3]);
	}
}
