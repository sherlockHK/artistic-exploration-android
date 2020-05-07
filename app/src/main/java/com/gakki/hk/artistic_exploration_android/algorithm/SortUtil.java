package com.gakki.hk.artistic_exploration_android.algorithm;

import java.util.Arrays;

/**
 * Created by kai on 2020/3/11
 * Email：kaihu1989@gmail.com
 * <p>
 * 参考文章：https://www.runoob.com/w3cnote/ten-sorting-algorithm.html
 */
public class SortUtil {
    /**
     * 冒泡排序（传统）
     * 比较相邻的两个数，左边比右边大，则交换位置，找出最大数，放在最右边
     */
    public static void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //注意 j < arr.length - i - 1，避免数组越界
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序（改进）
     */
    public static void bubbleSort2(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            //注意 j < arr.length - i - 1，避免数组越界
            flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
        }
    }

    /**
     * 选择排序：从第一个位置开始，选择最小的元素替换，依次类推
     * 时间复杂度: O(n^2)
     * 不稳定的排序
     */
    public static void selectSort(int[] arr) {
        //一共经过n-1轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            //找出最小数
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            //替换最小数
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    /**
     * 直接插入排序：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;

            //在已排序的序列中，从后向前遍历，找到比tmp大的数，向后挪
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (j != i) {
                arr[j] = tmp;
            }
        }
    }

    /**
     * 希尔排序（优化的插入排序）:希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
     * https://www.cnblogs.com/chengxiao/p/6104371.html
     */
    public static void shellSort(int[] arr) {
        //增量gap, 每次除以2,直到为1
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始，对每组直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int preIndex = j - gap;
                //对单组元素，直接插入排序
                while (preIndex >= 0 && arr[j] < arr[preIndex]) {
                    int tmp = arr[preIndex];
                    arr[preIndex] = arr[j];
                    arr[j] = tmp;
                    j = preIndex;
                }
            }
        }
    }

    /**
     * 归并排序
     * 利用"归并思想"，采用分治策略，"分"将问题拆分若干小问题，递归求解，"治"将分阶段的结果"修补"在一起，分而治之
     * 拆分复杂度O(log2n)，合并操作复杂度O(n)，时间复杂度O(nlogn)
     * https://www.cnblogs.com/chengxiao/p/6194356.html
     */
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
        int j = mid + 1;//右边数组指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
            System.out.println("i:" + i + " j:" + j + " | " + temp[t]);
        }

        //将左边剩余元素填充进temp
        while (i <= mid) {
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

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int partitionIndex = partition(arr, l, r);
            quickSort(arr, l, partitionIndex -1);
            quickSort(arr, partitionIndex + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        //取一个值为参考值
        int tmp = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= tmp) {
                r--;
            }
            swap(arr, l ,r);

            while (l < r && arr[l] <= tmp) {
                l++;
            }
            swap(arr, l ,r);
        }
        return l;
    }

    private static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {

    }

    /**
     * 计数排序
     */
    public static void countingSort(int[] arr) {

    }

    /**
     * 桶排序
     */
    public static void bucketSort(int[] arr) {

    }

    /**
     * 基数排序
     */
    public static void radixSort(int[] arr) {

    }
}
