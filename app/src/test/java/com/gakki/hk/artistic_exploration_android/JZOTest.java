package com.gakki.hk.artistic_exploration_android;

import com.gakki.hk.artistic_exploration_android.algorithm.JZO;
import com.gakki.hk.artistic_exploration_android.data_structure.ListNode;
import com.gakki.hk.artistic_exploration_android.data_structure.TreeNode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author : hukai50
 * @date : 2020/12/1 上午9:42
 * @desc :
 */
public class JZOTest {
    @Test
    public void test_3() {
        int repeatNumber = JZO.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
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
        boolean re1 = JZO.findNumberIn2DArray(matrix, 5);
        boolean re2 = JZO.findNumberIn2DArray(matrix, 20);
        Assert.assertTrue(re1);
        Assert.assertFalse(re2);
    }

    @Test
    public void test_5() {
        String replaceStr5 = JZO.replaceStr("We are happy.");
        Assert.assertEquals(replaceStr5, "We%20are%20happy.");
    }

    @Test
    public void test_6() {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        int[] ints = JZO.reversePrint(n1);
        Assert.assertEquals(ints[0], 5);
        Assert.assertEquals(ints[1], 4);
        Assert.assertEquals(ints[2], 3);
    }

    @Test
    public void test_7() {
    }

    @Test
    public void test_9() {
        JZO.CQueue cQueue = new JZO.CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        int re1 = cQueue.deleteHead();
        int re2 = cQueue.deleteHead();
        int re3 = cQueue.deleteHead();
        int re4 = cQueue.deleteHead();
        Assert.assertEquals(re1, 1);
        Assert.assertEquals(re2, 2);
        Assert.assertEquals(re3, 3);
        Assert.assertEquals(re4, -1);
    }

    @Test
    public void test_10_1() {
        int re1 = JZO.fib(0);
        int re2 = JZO.fib(1);
        int re3 = JZO.fib(2);
        int re4 = JZO.fib(5);
        Assert.assertEquals(re1, 0);
        Assert.assertEquals(re2, 1);
        Assert.assertEquals(re3, 1);
        Assert.assertEquals(re4, 5);
    }

    @Test
    public void test_10_2() {
        int re1 = JZO.numWays(0);
        int re2 = JZO.numWays(2);
        int re3 = JZO.numWays(7);
        Assert.assertEquals(re1, 1);
        Assert.assertEquals(re2, 2);
        Assert.assertEquals(re3, 21);
    }

    @Test
    public void test_11() {
        int re1 = JZO.minArray1(new int[]{3, 4, 5, 1, 2});
        int re2 = JZO.minArray1(new int[]{2, 2, 2, 0, 1});
        int re3 = JZO.minArray1(new int[]{1, 0, 1, 1, 1});
        Assert.assertEquals(re1, 1);
        Assert.assertEquals(re2, 0);
        Assert.assertEquals(re3, 0);

        int re4 = JZO.minArray2(new int[]{3, 4, 5, 1, 2});
        int re5 = JZO.minArray2(new int[]{2, 2, 2, 0, 1});
        int re6 = JZO.minArray2(new int[]{1, 0, 1, 1, 1});
        Assert.assertEquals(re4, 1);
        Assert.assertEquals(re5, 0);
        Assert.assertEquals(re6, 0);
    }

    @Test
    public void test_12() {
        char[][] matrix = new char[][]{
                new char[]{'a', 'b', 'c', 'e'},
                new char[]{'s', 'f', 'c', 's'},
                new char[]{'a', 'd', 'e', 'e'}};
        boolean re1 = JZO.exist(matrix, "abce");
        boolean re2 = JZO.exist(matrix, "sfcs");
        boolean re3 = JZO.exist(matrix, "bfce");
        boolean re4 = JZO.exist(matrix, "bfcf");
        boolean re5 = JZO.exist(matrix, "bfcd");
        Assert.assertTrue(re1);
        Assert.assertTrue(re2);
        Assert.assertTrue(re3);
        Assert.assertFalse(re4);
        Assert.assertFalse(re5);
    }

    @Test
    public void test_13() {
        int re1 = JZO.movingCount(2, 3, 1);
        int re2 = JZO.movingCount(3, 1, 0);
        Assert.assertEquals(re1, 3);
        Assert.assertEquals(re2, 1);
    }

    @Test
    public void test_14_1() {
        int re1 = JZO.cuttingRope1(2);
        int re2 = JZO.cuttingRope1(10);
        Assert.assertEquals(re1, 1);
        Assert.assertEquals(re2, 36);
    }

    @Test
    public void test_14_2() {
        int re1 = JZO.cuttingRope2(2);
        int re2 = JZO.cuttingRope2(5);
        int re3 = JZO.cuttingRope2(10);
        Assert.assertEquals(re1, 1);
        Assert.assertEquals(re2, 6);
        Assert.assertEquals(re3, 36);
    }

    @Test
    public void test_15() {
        int re1 = JZO.hammingWeight(9);
        int re2 = JZO.hammingWeight(7);
        Assert.assertEquals(re1, 2);
        Assert.assertEquals(re2, 3);
    }

    @Test
    public void test_16() {
        double re1 = JZO.myPow(2.0, 10);
        double re2 = JZO.myPow(2.1, 3);
        double re3 = JZO.myPow(2.0, -2);
        Assert.assertEquals(String.valueOf(re1), "1024.0");
        Assert.assertEquals(String.valueOf(re2), "9.261000000000001");
        Assert.assertEquals(String.valueOf(re3), "0.25");
    }

    @Test
    public void test_17() {
        int[] re1 = JZO.printNumbers(1);
        int[] re2 = JZO.printNumbers(2);
        int[] re3 = JZO.printNumbers(3);
        Assert.assertEquals(re1.length, 9);
        Assert.assertEquals(re2.length, 99);
        Assert.assertEquals(re2[re2.length - 1], 99);
        Assert.assertEquals(re3.length, 999);
        Assert.assertEquals(re3[re3.length - 1], 999);
    }

    @Test
    public void test_18() {
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode re1 = JZO.deleteNode(head, 5);
        Assert.assertEquals(re1.val, 4);
        Assert.assertEquals(re1.next.val, 1);
        ListNode re2 = JZO.deleteNode(head, 4);
        Assert.assertEquals(re2.val, 1);
        Assert.assertEquals(re2.next.val, 9);
    }

    @Test
    public void test_20() {
    }

    @Test
    public void test_21() {
        int[] nums1 = {1, 2, 3, 4};
        int[] re1 = JZO.exchange(nums1);
        Assert.assertEquals(re1[0], 3);
        Assert.assertEquals(re1[1], 1);
        Assert.assertEquals(re1[2], 2);
        Assert.assertEquals(re1[3], 4);

        int[] nums2 = {2, 2, 3, 5, 6, 1, 8, 10};
        int[] re2 = JZO.exchange(nums2);
        Assert.assertEquals(re2[0] % 2, 1);
        Assert.assertEquals(re2[1] % 2, 1);
        Assert.assertEquals(re2[2] % 2, 1);
        Assert.assertEquals(re2[3] % 2, 0);
        Assert.assertEquals(re2[4] % 2, 0);
        Assert.assertEquals(re2[5] % 2, 0);
        Assert.assertEquals(re2[6] % 2, 0);
        Assert.assertEquals(re2[7] % 2, 0);
    }

    @Test
    public void test_22() {
        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head1 = n1;
        ListNode re1 = JZO.getKthFromEnd(head1, 2);
        Assert.assertEquals(re1.val, 4);
        ListNode head2 = n1;
        ListNode re2 = JZO.getKthFromEnd(head2, 1);
        Assert.assertEquals(re2.val, 5);

    }

    @Test
    public void test_24() {
        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode re1 = JZO.reverseList(n1);
        Assert.assertEquals(re1.val, 4);
        Assert.assertEquals(re1.next.val, 3);
        Assert.assertEquals(re1.next.next.val, 2);
        Assert.assertEquals(re1.next.next.next.val, 1);
    }

    @Test
    public void test_25() {
        ListNode n1 = new ListNode(1, new ListNode(3, new ListNode(6, new ListNode(8))));
        ListNode a1 = new ListNode(2, new ListNode(5, new ListNode(8)));
        ListNode re = JZO.mergeTwoLists(n1, a1);
        Assert.assertEquals(re.val, 1);
        Assert.assertEquals(re.next.val, 2);
        Assert.assertEquals(re.next.next.val, 3);
        Assert.assertEquals(re.next.next.next.val, 5);
        Assert.assertEquals(re.next.next.next.next.val, 6);
        Assert.assertEquals(re.next.next.next.next.next.val, 8);
        Assert.assertEquals(re.next.next.next.next.next.next.val, 8);
    }

    @Test
    public void test_26() {
        TreeNode A = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode B = new TreeNode(4, new TreeNode(1), null);
        boolean re = JZO.isSubStructure(A, B);
        Assert.assertTrue(re);
    }

    @Test
    public void test_27() {
        TreeNode root = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(9);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        JZO.mirrorTree(root);
        Assert.assertEquals(root.left.val, 7);
        Assert.assertEquals(root.right.val, 2);
        Assert.assertEquals(root.left.left.val, 9);
        Assert.assertEquals(root.left.right.val, 6);
        Assert.assertEquals(root.right.left.val, 3);
        Assert.assertEquals(root.right.right.val, 1);
    }

    @Test
    public void test_28() {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(3);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        boolean re = JZO.isSymmetric(root);
        Assert.assertTrue(re);
    }

    @Test
    public void test_29() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{12, 13, 14, 5},
                new int[]{11, 16, 15, 6},
                new int[]{10, 9, 8, 7}};
        int[] re = JZO.spiralOrder(matrix);
        Assert.assertEquals(re[0], 1);
        Assert.assertEquals(re[3], 4);
        Assert.assertEquals(re[8], 9);
        Assert.assertEquals(re[12], 13);
        Assert.assertEquals(re[15], 16);
    }

    @Test
    public void test_30() {
        JZO.MinStack minStack = new JZO.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min1 = minStack.min();
        minStack.pop();
        int top = minStack.top();
        int min2 = minStack.min();
        Assert.assertEquals(min1, -3);
        Assert.assertEquals(top, 0);
        Assert.assertEquals(min2, -2);
    }

    @Test
    public void test_31() {
        boolean re1 = JZO.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        boolean re2 = JZO.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 3, 5});
        boolean re3 = JZO.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2});
        Assert.assertTrue(re1);
        Assert.assertTrue(re2);
        Assert.assertFalse(re3);
    }

    @Test
    public void test_32_1() {
        TreeNode A = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int[] re = JZO.levelOrder1(A);
        Assert.assertEquals(re[0], 3);
        Assert.assertEquals(re[1], 9);
        Assert.assertEquals(re[2], 20);
        Assert.assertEquals(re[3], 15);
        Assert.assertEquals(re[4], 7);
    }

    @Test
    public void test_32_2() {
        TreeNode A = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> re = JZO.levelOrder2(A);
        int re1 = re.get(0).get(0);
        int re2 = re.get(1).get(0);
        int re3 = re.get(1).get(1);
        int re4 = re.get(2).get(0);
        int re5 = re.get(2).get(1);
        Assert.assertEquals(re1, 3);
        Assert.assertEquals(re2, 9);
        Assert.assertEquals(re3, 20);
        Assert.assertEquals(re4, 15);
        Assert.assertEquals(re5, 7);
    }

    @Test
    public void test_32_3() {
        TreeNode A = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> re = JZO.levelOrder3(A);
        int re1 = re.get(0).get(0);
        int re2 = re.get(1).get(0);
        int re3 = re.get(1).get(1);
        int re4 = re.get(2).get(0);
        int re5 = re.get(2).get(1);
        Assert.assertEquals(re1, 3);
        Assert.assertEquals(re2, 20);
        Assert.assertEquals(re3, 9);
        Assert.assertEquals(re4, 15);
        Assert.assertEquals(re5, 7);
    }

    @Test
    public void test_33() {
    }

    @Test
    public void test_34() {
        TreeNode A = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        List<List<Integer>> lists = JZO.pathSum(A, 22);
        Assert.assertEquals(lists.size(), 2);
        int re1 = lists.get(0).get(0);
        int re2 = lists.get(0).get(1);
        int re3 = lists.get(0).get(2);
        int re4 = lists.get(0).get(3);
        int re5 = lists.get(1).get(0);
        int re6 = lists.get(1).get(1);
        int re7 = lists.get(1).get(2);
        int re8 = lists.get(1).get(3);
        Assert.assertEquals(lists.size(), 2);
        Assert.assertEquals(re1, 5);
        Assert.assertEquals(re2, 4);
        Assert.assertEquals(re3, 11);
        Assert.assertEquals(re4, 2);
        Assert.assertEquals(re5, 5);
        Assert.assertEquals(re6, 8);
        Assert.assertEquals(re7, 4);
        Assert.assertEquals(re8, 5);
    }

    @Test
    public void test_35() {
    }

    @Test
    public void test_36() {
        TreeNode tree = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)), new TreeNode(8, new TreeNode(6), new TreeNode(9)));
        TreeNode re = JZO.treeToDoublyList(tree);
        Assert.assertEquals(re.val, 1);
        Assert.assertEquals(re.left.val, 9);
        Assert.assertEquals(re.right.val, 3);
        Assert.assertEquals(re.right.right.val, 4);
    }

    @Test
    public void test_38() {
        String[] re = JZO.permutation("abc");
        Assert.assertEquals(re.length, 6);
        Assert.assertEquals(re[0], "abc");
        Assert.assertEquals(re[1], "acb");
        Assert.assertEquals(re[2], "bac");
        Assert.assertEquals(re[3], "bca");
        Assert.assertEquals(re[4], "cba");
        Assert.assertEquals(re[5], "cab");
    }

    @Test
    public void test_39() {
        int re1 = JZO.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        int re2 = JZO.majorityElement(new int[]{2});
        int re3 = JZO.majorityElement(new int[]{1, 1, 1, 2, 2});
        Assert.assertEquals(re1, 2);
        Assert.assertEquals(re2, 2);
        Assert.assertEquals(re3, 1);
    }

    @Test
    public void test_40() {
        int[] re = JZO.getLeastNumbers(new int[]{5, 3, 1, 7, 8, 2, 10, 4, 5}, 4);
        Assert.assertTrue(re[0] <= 4);
        Assert.assertTrue(re[1] <= 4);
        Assert.assertTrue(re[2] <= 4);
        Assert.assertTrue(re[3] <= 4);

        int[] re1 = JZO.getLeastNumbers(new int[]{1, 3, 2, 1, 3, 2, 1, 3, 2}, 4);
        Assert.assertTrue(re1[0] <= 2);
        Assert.assertTrue(re1[1] <= 2);
        Assert.assertTrue(re1[2] <= 2);
        Assert.assertTrue(re1[3] <= 2);
    }

    @Test
    public void test_42() {
        int re = JZO.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        Assert.assertEquals(re, 6);
    }

    @Test
    public void test_47() {
        int[][] matrix = new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}};
        int re = JZO.maxValue(matrix);
        Assert.assertEquals(re, 12);
    }

    @Test
    public void test_48() {
        int re1 = JZO.lengthOfLongestSubstring("abcabcbb");
        int re2 = JZO.lengthOfLongestSubstring("bbbbb");
        int re3 = JZO.lengthOfLongestSubstring("abba");
        int re4 = JZO.lengthOfLongestSubstring("abc");
        Assert.assertEquals(re1, 3);
        Assert.assertEquals(re2, 1);
        Assert.assertEquals(re3, 2);
        Assert.assertEquals(re4, 3);
    }

    @Test
    public void test_50() {
        char re1 = JZO.firstUniqChar("abaccdeff");
        char re2 = JZO.firstUniqChar("aadadaad");
        char re3 = JZO.firstUniqChar("cc");
        Assert.assertEquals(re1, 'b');
        Assert.assertEquals(re2, ' ');
        Assert.assertEquals(re3, ' ');
    }

    @Test
    public void test_52() {
        ListNode sameNode = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, sameNode));
        ListNode headB = new ListNode(5, new ListNode(0, new ListNode(1, sameNode)));
        ListNode re = JZO.getIntersectionNode(headA, headB);
        Assert.assertEquals(re, sameNode);
    }

    @Test
    public void test_53_1() {
        int re1 = JZO.search_53(new int[]{5, 7, 7, 8, 8, 10}, 7);
        int re2 = JZO.search_53(new int[]{5, 7, 7, 8, 8, 10}, 8);
        int re3 = JZO.search_53(new int[]{5, 7, 7, 8, 8, 10}, 10);
        int re4 = JZO.search_53(new int[]{5, 7, 7, 8, 8, 10}, 6);
        Assert.assertEquals(re1, 2);
        Assert.assertEquals(re2, 2);
        Assert.assertEquals(re3, 1);
        Assert.assertEquals(re4, 0);
    }

    @Test
    public void test_53_2() {
    }

    @Test
    public void test_54() {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        int re1 = JZO.kthLargest(root, 1);
        int re2 = JZO.kthLargest(root, 2);
        int re3 = JZO.kthLargest(root, 3);
        Assert.assertEquals(re1, 6);
        Assert.assertEquals(re2, 5);
        Assert.assertEquals(re3, 4);
    }

    @Test
    public void test_55_1() {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        int re = JZO.maxDepth(root);
        Assert.assertEquals(re, 4);
    }

    @Test
    public void test_55_2() {
        TreeNode t1 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        TreeNode t2 = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6));
        boolean re1 = JZO.isBalanced(t1);
        boolean re2 = JZO.isBalanced(t2);
        Assert.assertFalse(re1);
        Assert.assertTrue(re2);
    }

    @Test
    public void test_56_1() {}

    @Test
    public void test_56_2() {}

    @Test
    public void test_57_1() {
        int[] re1 = JZO.twoSum1(new int[]{2,7,11,15}, 9);
        int[] re2 = JZO.twoSum1(new int[]{10, 26, 30, 31, 47, 60}, 40);
        Assert.assertEquals(re1[0], 2);
        Assert.assertEquals(re1[1], 7);
        Assert.assertEquals(re2[0], 10);
        Assert.assertEquals(re2[1], 30);

        int[] re3 = JZO.twoSum2(new int[]{2,7,11,15}, 9);
        int[] re4 = JZO.twoSum2(new int[]{10, 26, 30, 31, 47, 60}, 40);
        Assert.assertEquals(re3[0], 2);
        Assert.assertEquals(re3[1], 7);
        Assert.assertEquals(re4[0], 10);
        Assert.assertEquals(re4[1], 30);
    }

    @Test
    public void test_57_2() {
        int[][] re1 = JZO.findContinuousSequence(15);
        Assert.assertEquals(re1[0][0], 1);
        Assert.assertEquals(re1[0][4], 5);
        Assert.assertEquals(re1[1][0], 4);
        Assert.assertEquals(re1[1][2], 6);
        Assert.assertEquals(re1[2][0], 7);
        Assert.assertEquals(re1[2][1], 8);
    }

    @Test
    public void test_58_1() {
        String re1 = JZO.reverseWords("the sky is blue");
        String re2 = JZO.reverseWords("  hello world!  ");
        String re3 = JZO.reverseWords("a good  example");
        Assert.assertEquals(re1, "blue is sky the");
        Assert.assertEquals(re2, "world! hello");
        Assert.assertEquals(re3, "example good a");
    }

    @Test
    public void test_58_2() {
        String re1 = JZO.reverseLeftWords("abcdefg", 2);
        String re2 = JZO.reverseLeftWords("lrloseumgh", 6);
        Assert.assertEquals(re1, "cdefgab");
        Assert.assertEquals(re2, "umghlrlose");
    }

    @Test
    public void test_59_1() {
        int[] re = JZO.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        Assert.assertEquals(re[0], 3);
        Assert.assertEquals(re[1], 3);
        Assert.assertEquals(re[2], 5);
        Assert.assertEquals(re[3], 5);
        Assert.assertEquals(re[4], 6);
        Assert.assertEquals(re[5], 7);
    }

    @Test
    public void test_59_2() {}

    @Test
    public void test_61() {}

    @Test
    public void test_62() {}

    @Test
    public void test_63() {
        int re1 = JZO.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        int re2 = JZO.maxProfit(new int[]{7,6,4,3,1});
        Assert.assertEquals(re1, 5);
        Assert.assertEquals(re2, 0);
    }

    @Test
    public void test_64() {
        int re1 = JZO.sumNums(3);
        int re2 = JZO.sumNums(9);
        Assert.assertEquals(re1, 6);
        Assert.assertEquals(re2, 45);
    }

}
