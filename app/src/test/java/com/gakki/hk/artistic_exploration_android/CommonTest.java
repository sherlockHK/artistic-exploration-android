package com.gakki.hk.artistic_exploration_android;

import com.gakki.hk.artistic_exploration_android.algorithm.SearchUtil;
import com.gakki.hk.artistic_exploration_android.algorithm.SortUtil;
import com.gakki.hk.artistic_exploration_android.data_structure.TreeStructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class CommonTest {

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
    //冒泡排序
    @Test
    public void test_bubble_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] arr1 = {8,4,5,7,1,3,6,2};
        SortUtil.bubbleSort1(arr);
        SortUtil.bubbleSort2(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }

    //选择排序
    @Test
    public void test_select_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        SortUtil.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    @Test
    public void test_insert_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        SortUtil.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //希尔排序
    @Test
    public void test_shell_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        SortUtil.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //归并排序
    @Test
    public void test_merge_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        SortUtil.mergeSort(arr, 0, arr.length -1 ,temp);
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    @Test
    public void test_quick_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        SortUtil.quickSort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    //堆排序
    @Test
    public void test_heap_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        SortUtil.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //计数排序
    @Test
    public void test_counting_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        SortUtil.countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //桶排序
    @Test
    public void test_bucket_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        SortUtil.bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //基数排序
    @Test
    public void test_radix_sort() throws Exception {
        int[] arr = {8,4,5,7,1,3,6,2};
        SortUtil.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //二叉树遍历
    @Test
    public void test_traverse_binary_tree() {
        TreeStructure.BinaryTree binaryTree = new TreeStructure.BinaryTree();
        binaryTree.generateBinaryTree();
        ArrayList<String> list = new ArrayList<>();
        TreeStructure.BinaryTree.preOrderTravNoRecur(binaryTree.root, list);
        System.out.println(list.toString());

        ArrayList<String> list2 = new ArrayList<>();
        TreeStructure.BinaryTree.midOrderTravNoRecur(binaryTree.root, list2);
        System.out.println(list2.toString());

        ArrayList<String> list3 = new ArrayList<>();
        TreeStructure.BinaryTree.postOrderTravNoRecur(binaryTree.root, list3);
        System.out.println(list3.toString());
    }
}