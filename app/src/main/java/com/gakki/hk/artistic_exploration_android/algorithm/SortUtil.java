package com.gakki.hk.artistic_exploration_android.algorithm;

import java.util.Arrays;

/**
 * Created by kai on 2020/3/11
 * Email：kaihu1989@gmail.com
 * Feature:
 */
public class SortUtil {
    /**
     * 归并排序
     * 利用"归并思想"，采用分治策略，"分"将问题拆分若干小问题，递归求解，"治"将分阶段的结果"修补"在一起，分而治之
     * 拆分复杂度O(log2n)，合并操作复杂度O(n)，时间复杂度O(nlogn)
     * https://www.cnblogs.com/chengxiao/p/6194356.html
     * */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);        //左边归并排序，使左子序列有序
            mergeSort(arr, mid + 1, right, temp);//右边归并排序，使右子序列有序
            merge(arr, left, mid, right, temp);  //合并两个有序子数组
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左边数组指针
        int j = mid +1;//右边数组指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
            System.out.println("i:" + i + " j:"+ j + " | " +temp[t]);
        }

        //将左边剩余元素填充进temp
        while (i <= mid){
            temp[t++] = arr[i++];
        }

        //将右边剩余元素填充进temp
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        //将temp中的元素全部拷贝到原数组中
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
        System.out.println(Arrays.toString(arr));
    }
}
