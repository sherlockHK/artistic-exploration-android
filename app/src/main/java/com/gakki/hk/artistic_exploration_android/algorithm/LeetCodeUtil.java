package com.gakki.hk.artistic_exploration_android.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kai on 2020/5/14
 * Email：kaihu1989@gmail.com
 * Feature:
 */
public class LeetCodeUtil {
    public static class Solution {
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

}
