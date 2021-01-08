package com.gakki.hk.artistic_exploration_android.algorithm;

/**
 * Created by kai on 2020/5/4
 * Email：kaihu1989@gmail.com
 * Feature:
 */
public class SearchUtil {
    /**
     * 二分查找（开区间）：找到目标值返回下标，否则返回-1
     * 左闭右开区间：[)
     */
    public static int binarySearch1(int[] arr, int target) {
        int l = 0;
        int mid;
        int h = arr.length;
        while (l < h) {
            mid = l + (h - l) / 2;
            if (target < arr[mid]) {
                //左闭右开，所以不需要-1
                h = mid;
            } else if (target > arr[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找（开区间）：找到目标值返回下标，否则返回-1
     * 左闭右闭区间：[]
     */
    public static int binarySearch2(int[] arr, int target) {
        int l = 0;
        int mid;
        int h = arr.length - 1;
        //左闭右闭，需要判断l=h的情况
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (target < arr[mid]) {
                //左闭右闭，所以需要-1
                h = mid - 1;
            } else if (target > arr[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找：从左到右，找到第一个出现的目标值
     *
     * @param target 目标值
     */
    public static int binarySearch3(int[] arr, int target) {
        int l = 0;
        int h = arr.length -1;
        int mid;
        while (l <= h) {
            mid = l + (h-l)/2;
            //中位数比目标值小，左边界移到中位数右1位
            if (arr[mid] < target){
                l = mid + 1;
            }else {
                h = mid -1;
            }
        }
        return l;
    }
}
