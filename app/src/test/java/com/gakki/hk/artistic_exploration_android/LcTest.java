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
    public void test_9() {
        LcUtil.CQueue cQueue = new LcUtil.CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        int re1 = cQueue.deleteHead();
        int re2 = cQueue.deleteHead();
        int re3 = cQueue.deleteHead();
        int re4 = cQueue.deleteHead();
        Assert.assertEquals(re1,1);
        Assert.assertEquals(re2,2);
        Assert.assertEquals(re3,3);
        Assert.assertEquals(re4,-1);
    }

    @Test
    public void test_10_1() {
        int re1 = LcUtil.fib(0);
        int re2 = LcUtil.fib(1);
        int re3 = LcUtil.fib(2);
        int re4 = LcUtil.fib(5);
        Assert.assertEquals(re1,0);
        Assert.assertEquals(re2,1);
        Assert.assertEquals(re3,1);
        Assert.assertEquals(re4,5);
    }

    @Test
    public void test_10_2() {
        int re1 = LcUtil.numWays(0);
        int re2 = LcUtil.numWays(2);
        int re3 = LcUtil.numWays(7);
        Assert.assertEquals(re1,1);
        Assert.assertEquals(re2,2);
        Assert.assertEquals(re3,21);
    }

    @Test
    public void test_11() {
        int re1 = LcUtil.minArray1(new int[]{3, 4, 5, 1, 2});
        int re2 = LcUtil.minArray1(new int[]{2, 2, 2, 0, 1});
        int re3 = LcUtil.minArray1(new int[]{1,0,1,1,1});
        Assert.assertEquals(re1, 1);
        Assert.assertEquals(re2, 0);
        Assert.assertEquals(re3, 0);

        int re4 = LcUtil.minArray2(new int[]{3, 4, 5, 1, 2});
        int re5 = LcUtil.minArray2(new int[]{2, 2, 2, 0, 1});
        int re6 = LcUtil.minArray2(new int[]{1,0,1,1,1});
        Assert.assertEquals(re4, 1);
        Assert.assertEquals(re5, 0);
        Assert.assertEquals(re6, 0);
    }

    @Test
    public void test_12() {
        char[][] matrix = new char[][]{
                new char[]{'a','b','c','e'},
                new char[]{'s','f','c','s'},
                new char[]{'a','d','e','e'}};
        boolean re1 = LcUtil.exist(matrix, "abce");
        boolean re2 = LcUtil.exist(matrix, "sfcs");
        boolean re3 = LcUtil.exist(matrix, "bfce");
        boolean re4 = LcUtil.exist(matrix, "bfcf");
        boolean re5 = LcUtil.exist(matrix, "bfcd");
        Assert.assertTrue(re1);
        Assert.assertTrue(re2);
        Assert.assertTrue(re3);
        Assert.assertFalse(re4);
        Assert.assertFalse(re5);
    }

    @Test
    public void test_13() {}

    @Test
    public void test_14_1() {}

    @Test
    public void test_14_2() {}

    @Test
    public void test_15() {}

    @Test
    public void test_16() {}

    @Test
    public void test_17() {}

}
