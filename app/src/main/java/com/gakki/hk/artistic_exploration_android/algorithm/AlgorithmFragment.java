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
        int high = a.length -1;

        while (low <= high) {
            int mid = (high + low) >>> 1;

            if (key < a[mid]) {
                high = mid -1;
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
