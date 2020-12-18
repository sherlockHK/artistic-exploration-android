package com.gakki.hk.artistic_exploration_android;

import com.gakki.hk.artistic_exploration_android.algorithm.JZO;
import com.gakki.hk.artistic_exploration_android.algorithm.LcHot;

import org.junit.Test;

import java.util.List;

/**
 * @author : hukai50
 * @date : 2020/12/18 上午11:23
 * @desc :
 */
public class LcHotTest {
    @Test
    public void test_get_k_combines_in_n_numbers() {
        LcHot.Solution1 s = new LcHot.Solution1();
        List<List<Integer>> combine = s.combine(4, 2);
    }
}
