package com.gakki.hk.artistic_exploration_android.algorithm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gakki.hk.artistic_exploration_android.R;

import java.util.Arrays;

/**
 *
 */
public class AlgorithmFragment extends Fragment {


    public static AlgorithmFragment newInstance() {
        return new AlgorithmFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_algorithm, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button btn_search = (Button) view.findViewById(R.id.btn_search);
        Button btn_sort = (Button) view.findViewById(R.id.btn_sort);
        Button string = (Button) view.findViewById(R.id.btn_string);
        Button array = (Button) view.findViewById(R.id.btn_array);
        btn_search.setOnClickListener(v -> searchTest());
        btn_sort.setOnClickListener(v -> sortTest());
        string.setOnClickListener(v -> stringTest());
        array.setOnClickListener(v -> arrayTest());
    }

    /*
    * 查找
    * */
    private void searchTest() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        Log.i("binarySearch:1", binarySearch(a, 1) + "");
        Log.i("binarySearch:8", binarySearch(a, 8) + "");
        Log.i("binarySearch:10", binarySearch(a, 10) + "");
    }

    private int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (high + low) >>> 1;

            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /*
    * 排序
    * */
    private void sortTest() {
        Log.i("bubble sort:", Arrays.toString(bubbleSort(new int[]{5, 4, 10, 1, 7, 2, 6, 3, 9, 8})));
        Log.i("insert sort:", Arrays.toString(insertSort(new int[]{5, 4, 10, 1, 7, 2, 6, 3, 9, 8})));
        Log.i("quick sort:", Arrays.toString(quickSort(new int[]{5, 4, 10, 1, 7, 2, 6, 3, 9, 8}, 0, 9)));
    }

    private int[] bubbleSort(int[] a) {
        boolean flag = true;
        for (int i = 0; i < a.length && flag; i++) {
            flag = false;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }
        }
        return a;
    }

    private int[] insertSort(int[] a) {
        int i, j;
        for (i = 1; i < a.length; i++) {
            int temp = a[i];
            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp; //合适位置插入
        }
        return a;
    }

    private int[] quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
        return a;
    }

    private int partition(int[] a, int low, int high) {
        int pivotKey = a[low];    //第一个数作为基准值
        while (low < high) {
            while (low < high && a[high] >= pivotKey)
                high--;
            a[low] = a[high];
            Log.i("replace", Arrays.toString(a));

            while (low < high && a[low] <= pivotKey)
                low++;
            a[high] = a[low];
            Log.i("replace", Arrays.toString(a));
        }

        a[low] = pivotKey;        //替换基准值
        Log.i("partition", Arrays.toString(a));
        return low;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        Log.i("swap:", "low：" + i + " high: " + j);
    }

    /*
    * 字符串
    * */
    private void stringTest() {

    }

    /*
    * 数组
    * */
    private void arrayTest() {

    }
}
