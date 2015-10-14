package com.danny.datastruct.sort;

import android.app.Activity;
import android.os.Bundle;

public class QuickSortActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Integer[] a = {8,7,8,4,6,3,5,0,3,4,1,2,6,8};
        QuickSort.sort(a);
        Integer[] b = {3,4,7,8,98,6,45,7,43,44,50,0};
        QuickSort.sort(b);
    }
}
