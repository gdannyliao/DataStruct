package com.danny.datastruct.sort;

public class ShellSort extends Sort {

	@Override
	public void sort(Comparable[] arr) {
		int N = arr.length;
		int h = 1;
		while (h < N/3)
			h = 3*h + 1;
		while (h >= 1) {
			for (int i=h; i<N; i++) {
				for (int j=i; j>=h && Sort.less(arr[j], arr[j-h]); j-=h)
					Sort.exch(arr, j, j-h);
			}
			h = h/3;
		}
	}

}
