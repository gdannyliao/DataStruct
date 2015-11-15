package com.danny.datastruct.sort;


public class MergeSort extends Sort {
	private static Comparable[] aux;
	
	public static void mergeSort(Comparable[] arr) {
		aux = new Comparable[arr.length];
		sort(arr,0,arr.length -1);
	}
	
	public static void sort(Comparable[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo+hi) / 2;
		sort(arr, lo, mid);
		sort(arr, mid+1, hi);
		merge(arr, lo, mid, hi);
	}
	
	/*      i     m j      
	 *      4 2 5 5 7 3 8 6 
	 *  s1: a[j] > a[i], i++
	 * 		4--------------
	 *  s2: a[j] > a[i], i++
	 *  	4 2------------
	 *  s3: a[j] > a[i], i++
	 *  	4 2 5----------
	 *  s4: a[j] > a[i], i++
	 *  	4 2 5 5--------
	 *  s5: i=7 i>mid j++
	 *  	4 2 5 5 7------
	 *  s6: i=7 i>mid j++
	 *  	4 2 5 5 7 3----
	 *  s7: i=7
	 *      4 2 5 5 7 3 8--
	 *  s8:
	 *      4 2 5 5 7 3 8 6
	 */
	public static void merge(Comparable[] arr, int min, int mid, int max) {
		int i = min;
		int j = mid + 1;
		
		for (int k=min; k<=max; k++) {
			aux[k] = arr[k];
		}
		
		for (int k=min; k<=max; k++) {
			if (i>mid)
				arr[k] = aux[j++];
			else if (j>max)
				arr[k] = aux[i++];
			else if (Sort.less(aux[j], aux[i]))
				arr[k] = aux[j++];
			else arr[k] = aux[i++];
		}
	}

	@Override
	public void sort(Comparable[] arr) {
		//1申请一个待排序串长度的空间，用来临时存放合并串
		aux = new Comparable[arr.length];
		sortS(arr, 0, arr.length -1);
	}
	
	public void sortS(Comparable[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (left + right) / 2;
			sort(arr, left, mid);
			sort(arr, mid+1, right);
			mergeS(arr, left, mid, right);
		}
			
	}
	public void mergeS(Comparable[] arr, int left, int mid, int right) {
		int i=left, j = mid+1;
		int k=0;
		for (int l=0;l<=right;l++)
			aux[l] = arr[l];
		
		while (i<=mid && j<=right) {
			if (aux[i].compareTo(aux[j]) < 0)
				arr[k++] = aux[i++];
			else arr[k++] = aux[j++];
		}
		while (i<=mid)
			arr[k++] = aux[i++];
		while (j<=right)
			arr[k++] = aux[j++];
		
	}

}
