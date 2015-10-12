package com.danny.datastruct.sort;

import java.util.ArrayList;
import java.util.Vector;

import com.danny.datastruct.AlgorithmRunnable;
import com.danny.datastruct.Cell;
import com.danny.datastruct.ListArray;

public class MergeSortRunnable extends AlgorithmRunnable {
	private static Comparable[] aux;

	private void merge(Comparable[] arr, int lo, int mid, int hi) {
		int i = lo;

		int j = mid + 1;
		// 先把数组复制到缓存中
		for (int k = lo; k <= hi; k++) {
			aux[k] = arr[k];
		}

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				// 左边用尽
				arr[k] = aux[j++];
			else if (j > hi)
				// 右边用尽
				arr[k] = aux[i++];
			else if (aux[j].compareTo(aux[i]) < 0) {
				// 右边小于左边
				arr[k] = aux[j++];
			} else {
				// 左边小于等于右边
				arr[k] = aux[i++];
			}

		}
	}

	private void sort(Comparable[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		// 分别排序左边和右边，再合并
		sort(arr, lo, mid);
		sort(arr, mid + 1, hi);
		merge(arr, lo, mid, hi);
	}

	public void sort(Comparable[] arr) {
		// 缓存数组
		aux = new Comparable[arr.length];
		sort(arr, 0, arr.length - 1);
	}

//////////////////////////////////// 下面是正文///////////////////////
	/**
	 * 这个列表用于临时存放交换数据
	 */
	private ListArray<Cell> auxList;
	private float rectWidth;
	private float verticalInterval;
	private float horizontalInterval;
	private float initialx;
	private float initialy;

	@Override
	public void run() {
		sort(mCells.toArray(new Comparable[mCells.size()]));
		auxList = new ListArray<Cell>(mCells.size());
		Cell cell = mCells.get(0);
		rectWidth = cell.getRect().width();
		verticalInterval = rectWidth;
		initialx = cell.getLeft();
		initialy = cell.getTop();
		horizontalInterval = mCells.get(1).getLeft() - rectWidth-initialx;

		sortList(mCells, 0, mCells.size() - 1);
		auxList.clear();
		for (Cell c : mCells)
			System.out.print(c.toTextString());
		System.out.println();
	}

	private void sortList(ListArray<Cell> arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		sortList(arr, lo, mid);
		sortList(arr, mid + 1, hi);
		mergeList(arr, lo, mid, hi);
	}

	private void mergeList(ListArray<Cell> arr, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Cell from = arr.get(k);
			float[] angles = from.getAngles();
			from.getRect().set(angles[0], angles[3] + verticalInterval, angles[2],
					verticalInterval + rectWidth + angles[3]);
			auxList.set(k, from);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int k = lo; k <= hi; k++) {
			Cell cell;
//			Cell remove = mDrawers.remove(k);
			if (i > mid) {
				cell = auxList.get(j);
				j++;
			} else if (j > hi) {
				cell = auxList.get(i);
				i++;
			} else if (auxList.get(j).compareTo(auxList.get(i)) < 0) {
				cell = auxList.get(j);
				j++;
			} else {
				cell = auxList.get(i);
				i++;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			restorePosition(cell, k);
			//FIXME 修正交换时错乱的问题(ListArray问题);

//			int index = mDrawers.get(cell);
//			if (index > -1) {
//				mDrawers.add(index, remove);
//				mDrawers.add(k, cell);
//			} else {
//				mDrawers.add(k, remove);
//			}
		}
	}

	private void restorePosition(Cell cell, int position) {
		cell.getRect().set(initialx+position*(rectWidth+horizontalInterval)
				, initialy, initialx+position*(rectWidth+horizontalInterval)+rectWidth
				, rectWidth+initialy);
	}
}
