package com.danny.datastruct.sort;

public class HeapSort extends Sort {

	void sink(Comparable[] arr, int i, int range) {
		while (i*2 < range) {
			int j = i*2;
			if (j < range && less(arr[j], arr[j+1]))
				++j;
			if (!less(arr[i], arr[j]))
				break;
			exch(arr, i, j);
			i = j;
		}
	}

	@Override
	public void sort(Comparable[] arr) {
		int range = arr.length - 1;
		for (int k=range/2; k>=1; --k) {
			sink(arr, k, range);
		}
		
		while (range > 1) {
			exch(arr, 1, range);
			--range;
			sink(arr, 1, range);
		}
	}
}
