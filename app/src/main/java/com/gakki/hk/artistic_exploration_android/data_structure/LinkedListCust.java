package com.gakki.hk.artistic_exploration_android.data_structure;

/**
 * Created by HK on 2017/8/25.
 * Email: kaihu1989@gmail.com.
 */

public class LinkedListCust {

    /**
     * 结点定义
     */
    public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 生成链表数据
     */
    public static Node generateNode(int length) {
        if (length <= 0) {
            return null;
        }
        Node first = new Node(1, null);
        //头插法
        for (int i = 0; i < length - 1; i++) {
            Node newNode = new Node(first.data + 1, null);
            newNode.next = first;
            first = newNode;
        }
        return first;
    }

    public static Node get(Node node, int index) {
        if (node == null || index < 0) {
            return null;
        }

        Node res = node;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }

    public static boolean insert(Node node, int index, int data) {
        if (node == null || index < 0) {
            return false;
        }

        Node p = node;
        for (int i = 0; i < index - 1; i++) {
            if (p == null) {
                return false;
            }
            p = p.next;
        }

        p.next = new Node(data, p.next);
        return true;
    }

    public static boolean delete(Node node, int index) {
        if (node == null || index < 0) {
            return false;
        }

        Node p = node;
        for (int i = 0; i < index - 1; i++) {
            if (p == null) {
                return false;
            }
            p = p.next;
        }

        Node n = p.next;
        p.next = n.next;
        return true;
    }

    public static Node reverse(Node node) {
        if (node == null) {
            return null;
        }

        Node p = node;
        Node q = node.next;
        node.next = null;
        Node r;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }

}
