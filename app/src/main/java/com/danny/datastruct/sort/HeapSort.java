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
		//将所有的子树调整为堆有序（忽略叶子节点，所以从range/2开始）
		for (int k=range/2; k>=1; --k) {
			sink(arr, k, range);
		}

        //把最大的放最后，然后把剩余堆调整回有序
		while (range > 1) {
			exch(arr, 1, range--);
			sink(arr, 1, range);
		}
	}
}
