package com.danny.datastruct.sort;

public class QuickSort{
	
	private static int adjustArray(Comparable[] arr, int left, int right) {
		//1.取i=下界, j=上界.取a[i]作为中轴,空出a[i]的位置作为坑
		int i = left;
		int j = right;
		Comparable mid = arr[i];
		while (i < j) {
			//2.1 j--, 找到第一个不大于中轴的值
			while (i < j && arr[j].compareTo(mid) >= 0)
				j--;
			//2.2 将该值填入空缺的坑（a[i]所在）
			if (i < j) {
				arr[i++] = arr[j];
			}
			//3.1 i++,找到第一个大于中轴的值
			while (i < j && arr[i].compareTo(mid) < 0)
				i++;
			//3.2 将该值填入空缺的坑（arr[j]所在位置）
			if (i < j) {
				arr[j--] = arr[i];
			}
			//4 重复2、3步
		}
		//5 当i==j时， 将中轴填入最后的坑
		arr[i] = mid;
		return i;
	}

	private static Comparable[] sort(Comparable[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        int mid = adjustArray(arr, left, right);
        //6 对中点左边、右边的数组分别执行以上几步
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
        return arr;
    }

    public static void sort(Comparable[] arr) {
        Comparable[] sort = sort(arr, 0, arr.length - 1);
        System.out.print("result:");
        for (Comparable c : sort) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
