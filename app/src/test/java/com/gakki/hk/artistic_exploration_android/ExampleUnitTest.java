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
    //二分查找目标值
    @Test
    public void test_binary_search() throws Exception {
        int[] arr = {1,3,5,7,9,13};
        int re1 = SearchUtil.binarySearch1(arr, 7);
        int re2 = SearchUtil.binarySearch2(arr, 8);
        System.out.println("re1：" + re1 + " | " + "re2：" + re2);
    }

    //二分查找第一个出现的值，返回下标
    @Test
    public void test_binary_search1() throws Exception {
        int[] arr = {1,3,5,7,7,9,13};
        int re1 = SearchUtil.binarySearch3(arr, 6);
        int re2 = SearchUtil.binarySearch3(arr, 7);
        int re3 = SearchUtil.binarySearch3(arr, 8);
        System.out.println("re1：" + re1 + " | " + "re2：" + re2 + " | " + "re3：" + re3);
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