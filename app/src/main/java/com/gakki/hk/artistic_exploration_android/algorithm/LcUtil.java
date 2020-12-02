package com.gakki.hk.artistic_exploration_android.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by kai on 2020/5/14
 * Email：kaihu1989@gmail.com
 * Feature:
 */
public class LcUtil {
    public static class Solution1 {
        List<List<Integer>> output = new LinkedList();
        LinkedList<Integer> curr = new LinkedList<>();
        int n;
        int k;

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            backtrack(1);
            return output;
        }

        private void backtrack(int first) {
            // if the combination is done
            if (curr.size() == k){
                output.add(new LinkedList(curr));
                return;
            }
            for (int i = first; i <= n; ++i) {
                // add i into the current combination
                curr.add(i);
                // use next integers to complete the combination
                backtrack(i + 1);
                // backtrack
                curr.removeLast();
            }
        }
    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     * */
    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Boolean> m = new HashMap<>();
        for (int i : nums) {
            if (m.containsKey(i)){
                return i;
            }
            m.put(i, true);
        }
        return -1;
    }

}
