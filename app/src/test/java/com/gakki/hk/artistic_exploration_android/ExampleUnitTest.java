package com.gakki.hk.artistic_exploration_android;

import android.util.Log;

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
    @Before
    public void init(){
    }

    @Test
    public void test_merge_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        SortUtil.mergeSort(arr, 0, arr.length -1 ,temp);
        System.out.println(Arrays.toString(arr));
    }
}