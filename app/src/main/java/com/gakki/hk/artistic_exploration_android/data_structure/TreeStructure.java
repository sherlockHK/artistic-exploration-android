package com.gakki.hk.artistic_exploration_android.data_structure;

import android.util.Log;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by HK on 2017/8/28.
 * Email: kaihu1989@gmail.com.
 */

public class TreeStructure {

    /**
     * 普通树的双亲孩子表示法
     */
    static class Tree {
        private RootNode[] tables;

        static class RootNode {
            int data;
            int parent;
            ChildrenNode firstChild;
        }

        static class ChildrenNode {
            int data;
            ChildrenNode next;
        }
    }

    /**
     * 二叉树定义
     */
    public static class BinaryTree {
        //树的结点定义
        static class TreeNode {
            String data;
            TreeNode lChild;
            TreeNode rChild;

            TreeNode(String data, TreeNode lChild, TreeNode rChild) {
                this.data = data;
                this.lChild = lChild;
                this.rChild = rChild;
            }
        }

        public TreeNode root; //根结点

        public BinaryTree() {
            root = new TreeNode("1", null, null);
        }

        public void generateBinaryTree() {
            TreeNode bNode = new TreeNode("2", null, null);
            TreeNode cNode = new TreeNode("3", null, null);
            TreeNode dNode = new TreeNode("4", null, null);
            TreeNode eNode = new TreeNode("5", null, null);
            TreeNode fNode = new TreeNode("6", null, null);
            TreeNode gNode = new TreeNode("7", null, null);

            root.lChild = bNode;
            root.rChild = cNode;

            bNode.lChild = dNode;
            bNode.rChild = eNode;

            cNode.lChild = fNode;
            cNode.rChild = gNode;
        }

        //前序遍历
        static void preOrderTraverse(TreeNode node) {
            if (node == null) {
                return;
            }

            Log.i("preOrderTraverse", node.data);
            preOrderTraverse(node.lChild);
            preOrderTraverse(node.rChild);
        }

        //中序遍历
        static void inOrderTraverse(TreeNode node) {
            if (node == null) {
                return;
            }

            inOrderTraverse(node.lChild);
            Log.i("inOrderTraverse", node.data);
            inOrderTraverse(node.rChild);
        }

        //后序遍历
        static void postOrderTraverse(TreeNode node) {
            if (node == null) {
                return;
            }

            postOrderTraverse(node.lChild);
            postOrderTraverse(node.rChild);
            Log.i("postOrderTraverse", node.data);
        }

        /*
        * 前序遍历的非递归实现
        * */
        static void preOrderTravNoRecur(TreeNode node){
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = node;
            while (p != null || !stack.isEmpty()){
                while (p != null){
                    String data = p.data;
                    stack.push(p);
                    p = p.lChild;
                }
                p = stack.pop();
                p = p.rChild;
            }
        }

        /**
         * 前序遍历的非递归实现
         * 1.p指向根节点
         * 2.若p不为空，遍历p，p入栈，再将p指向p的左孩子，直到左孩子为空
         * 3.堆栈中退出栈顶元素，将p指向它的右孩子
         * 4.重复2，3过程
         * */
        public static List<String> preOrderTravNoRecur(TreeNode node, List<String> list){
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = node;
            while (p != null || !stack.isEmpty()){
                while (p != null){
                    list.add(p.data);
                    stack.push(p);
                    p = p.lChild;
                }
                p = stack.pop();
                p = p.rChild;
            }
            return list;
        }

        /**
         * 中序遍历的非递归实现
         * 1.p指向根节点
         * 2.若p不为空，p入栈，再将p指向p的左孩子，直到左孩子为空
         * 3.堆栈中退出栈顶元素，p指向栈顶元素，遍历p，将p指向它的右孩子
         * 4.重复2，3过程
         * */
        public static List<String> midOrderTravNoRecur(TreeNode node, List<String> list){
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = node;
            while (p != null || !stack.isEmpty()){
                while (p != null){
                    stack.push(p);
                    p = p.lChild;
                }
                p = stack.pop();
                list.add(p.data);
                p = p.rChild;
            }
            return list;
        }

        /**
         * 后序遍历的非递归实现
         * 1.2个栈，1个存储需要遍历的节点，另一个存储节点是否已遍历过右子节点
         * 2.若p不为空，p入栈，再将p指向p的左孩子，直到左孩子为空
         * 3.堆栈1中退出栈顶元素，p指向栈顶元素，堆栈2退出栈顶元素，代表堆栈1栈顶节点是否已遍历过右子节点
         * 4.已遍历，则读取p的值，p指向null
         * 5.未遍历，将p入栈1，且true入栈2，说明p已遍历过右子节点，p指向p的右孩子，重复上述2,3,4,5过程
         * */
        public static List<String> postOrderTravNoRecur(TreeNode node, List<String> list){
            LinkedList<TreeNode> stack = new LinkedList<>();
            LinkedList<Boolean> flagS = new LinkedList<>();
            TreeNode p = node;
            int count = 0;
            while (p != null || !stack.isEmpty()){
                while (p != null){
                    stack.push(p);
                    flagS.push(p.rChild == null);
                    p = p.lChild;
                }
                p = stack.pop();
                System.out.println("遍历次数" + ++count);
                boolean flag = flagS.pop();
                if (flag){
                    list.add(p.data);
                    p = null;
                }else {
                    stack.push(p);
                    flagS.push(true);
                    p = p.rChild;
                }
            }
            return list;
        }

        /*
        * 层序遍历
        * 利用Queue
        * */
        static void levelTraverse(TreeNode node) {
            if (node == null) {return;}

            Queue<TreeNode> queue = new java.util.LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                Log.i("levelTraverse", temp.data);
                if (temp.lChild != null) {
                    queue.add(temp.lChild);
                }
                if (temp.rChild != null) {
                    queue.add(temp.rChild);
                }
            }
        }

        /*
        * 翻转二叉树
        * */
        static void invertBinaryTree(TreeNode node){
            if (node == null){
                return;
            }

            TreeNode left = node.lChild;
            node.lChild = node.rChild;
            node.rChild = left;

            invertBinaryTree(node.lChild);
            invertBinaryTree(node.rChild);
        }
    }
}
