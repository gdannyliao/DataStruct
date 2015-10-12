package com.danny.datastruct.sort;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class HeapSortActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		testBinarySearch();
		test1_1_1();
		test1_1_2();
		test1_1_9();
		test_1_1_11();
	}
	Character[] testExample() {
		Character[] chars = new Character[Sort.chars.length];
		System.arraycopy(Sort.chars, 0, chars, 0, Sort.chars.length);
		HeapSort sort = new HeapSort();
		sort.sort(chars);
		System.out.println("heap sort:");
		for (int i=1; i<chars.length; ++i) {
			System.out.print(chars[i]);
		}
		System.out.println("\nheap sort end");
		return chars;
	}
	
	int testBinarySearch() {
		Character[] chars = testExample();
		int findc = BinarySearch.find(chars, 'c');
		System.out.println("\nfind c:" + findc);
		int findo = BinarySearch.find(chars, 'O');
		System.out.println("find O:" + findo);
		int findx = BinarySearch.find(chars, 'X');
		System.out.println("find X:" + findx);
		int finda = BinarySearch.find(chars, 'A');
		System.out.println("find A:" + finda);
		return findo;
	}
	
	void test1_1_1() {
		double l = 2.0e-6*1000000000.1;
		System.out.println("test_1_1_1(): " + l);
	}
	void test1_1_2() {
		System.out.println((1 + 2.435345) / 2);
		
	}
	
	void test1_1_9() {
		int n = 15;
		String s = "";
		for (; n > 0; n /= 2) {
			s = (n%2) + s;
		}
		
		System.out.println("test 1.1.9  s=:" + s);
	}
	
	//打印二维数组
	void test_1_1_11() {
		int[][] arr = new int[5][];
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j< 5; j++) {
				if (arr[i] == null)
					arr[i] = new int[5];
				arr[i][j] = i+j*2;
			}
		}
		System.out.println("2dimention array initialized");
//		System.out.print("col:  ");
//		for (int i=0; i<arr[0].length; i++) {
//			System.out.print("" + (i+1) + " ");
//		}
//		System.out.println();
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
//				if (j == 0)
//					System.out.print("row " + i + " ");
				System.out.print("" + arr[i][j] + " ");
			}
			System.out.println();
		}
		test1_1_13(arr);
	}
	
	//转置矩阵
	void test1_1_13(int[][] arr) {
//		int rowHalf = arr.length / 2;
//		int colHalf = arr[0].length / 2;
		int rowHalf = arr.length;
		int colHalf = arr[0].length;
		for (int i=1; i<rowHalf; i++) {
			for (int j=i; j<colHalf; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		System.out.println("transpose new arr");
		System.out.println();
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[0].length; j++) {
				System.out.print("" + arr[i][j] + " ");
			}
			System.out.println();
		}
			
	}
}
