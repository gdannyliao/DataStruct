package com.danny.datastruct.sort;

public class BinarySearch {
	public static int find(Comparable[] arr, Comparable key) {
		if (arr == null || key == null)
			return -1;
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (key.compareTo(arr[mid]) > 0)
				left = mid + 1;
			else if (key.compareTo(arr[mid]) < 0)
				right = mid - 1;
			else return mid;
		}
		return -1;
	}
	
}
