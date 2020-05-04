package com.gakki.hk.artistic_exploration_android;

import android.util.Log;

import com.gakki.hk.artistic_exploration_android.algorithm.SearchUtil;
import com.gakki.hk.artistic_exploration_android.algorithm.SortUtil;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    /***查找算法***/
    //二分查找
    @Test
    public void test_binary_search() throws Exception {
        int[] arr = {1,3,5,7,9,13};
        int index = SearchUtil.binarySearch(arr, 7);
        System.out.println(index);
    }


    /***排序算法***/
    //归并排序
    @Test
    public void test_merge_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        SortUtil.mergeSort(arr, 0, arr.length -1 ,temp);
        System.out.println(Arrays.toString(arr));
    }
}