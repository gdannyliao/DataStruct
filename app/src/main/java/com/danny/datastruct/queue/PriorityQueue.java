package com.danny.datastruct.queue;


public class PriorityQueue<T extends Comparable<T>> {
	private T[] arr;
	private int size = 0;
	private int initLength = 10;
	
	public PriorityQueue() {
		arr = (T[]) new Comparable[initLength + 1];
	}
	
	public PriorityQueue(int max) {
		arr = (T[]) new Comparable[max + 1];
	}

	boolean less(int i, int j) {
		return arr[i].compareTo(arr[j]) < 0;
	}
	
	void exch (int i, int j) {
		T t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	public void insert(T obj) {
		++size;
		if (size == arr.length) {
			//增大數組
			increase();
		}
		arr[size] = obj;
		swim(size);
	}

	void increase() {
		T[] newArr = (T[]) new Comparable[arr.length * 2];
		System.arraycopy(arr, 0, newArr, 0, size);
		arr = newArr;
	}

	/*
	 *  找到簡單的計算方法達到同樣的目的
	 */
	public T deleteMax() {
		T max = arr[1];
		arr[1] = arr[size];
		arr[size] = null;
		--size;
		sink(1);
		return max;
	}
	void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	/*
	 * 將複雜的算法分解成若干簡單的算法, 比如把比較分出來. 就像插入時把上浮分出來.
	 * 如果是針對下標的計算, 那就始終使用下標
	 */
	void sink(int k) {
		while (2*k <= size) {
			int j = 2*k;
			//默認為第一個, 當第二個比第一個大時, 下標指向第二個
			if (j < size && less(j, j+1))
				j++;
			//不再小於時, 說明下沉到底了, break退出循環
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
	
}
