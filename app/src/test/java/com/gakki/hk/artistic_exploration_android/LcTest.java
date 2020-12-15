package com.gakki.hk.artistic_exploration_android;

import com.gakki.hk.artistic_exploration_android.algorithm.LcUtil;
import com.gakki.hk.artistic_exploration_android.data_structure.ListNode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author : hukai50
 * @date : 2020/12/1 上午9:42
 * @desc :
 */
public class LcTest {
    @Test
    public void test_get_k_combines_in_n_numbers() {
        LcUtil.Solution1 s = new LcUtil.Solution1();
        List<List<Integer>> combine = s.combine(4, 2);
    }

    @Test
    public void test_3() {
        int repeatNumber = LcUtil.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        Assert.assertEquals(repeatNumber, 2);
    }

    @Test
    public void test_4() {
        int[][] matrix = new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}};
        boolean re1 = LcUtil.findNumberIn2DArray(matrix, 5);
        boolean re2 = LcUtil.findNumberIn2DArray(matrix, 20);
        Assert.assertTrue(re1);
        Assert.assertFalse(re2);
    }

    @Test
    public void test_5() {
        String replaceStr5 = LcUtil.replaceStr("We are happy.");
        Assert.assertEquals(replaceStr5, "We%20are%20happy.");
    }

    @Test
    public void test_6() {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        int[] ints = LcUtil.reversePrint(n1);
        Assert.assertEquals(ints[0], 5);
        Assert.assertEquals(ints[1], 4);
        Assert.assertEquals(ints[2], 3);
    }

    @Test
    public void test_7() {}

    @Test
    public void test_9() {}

    @Test
    public void test_10_1() {}
}
