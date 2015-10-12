package com.danny.datastruct.sort;


public class SelectionSort extends Sort {

	@Override
	public void sort(Comparable[] arr) {
		// TODO Auto-generated method stub
		/*
		 * 1选出数组中最小值
		 * 2使之与第一个交换
		 * 3对于剩下的数组重复上面两步
		 */
		for (int i=1; i<arr.length; i++) {
			int min = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[min].compareTo(arr[j]) > 0) {
					min = j;
				}
			}
			Comparable temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		
	}
}
