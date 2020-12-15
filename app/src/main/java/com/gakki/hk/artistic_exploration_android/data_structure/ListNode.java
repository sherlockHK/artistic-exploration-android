package com.gakki.hk.artistic_exploration_android.data_structure;

/**
 * @author : hukai50
 * @date : 2020/12/14 下午5:06
 * @desc :
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
