package com.gakki.hk.artistic_exploration_android.data_structure;

import android.util.Log;

import java.util.Queue;

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
    static class BinaryTree {
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

        TreeNode root; //根结点

        BinaryTree() {
            root = new TreeNode("A", null, null);
        }

        void generateBinaryTree() {
            TreeNode bNode = new TreeNode("B", null, null);
            TreeNode cNode = new TreeNode("C", null, null);
            TreeNode dNode = new TreeNode("D", null, null);
            TreeNode eNode = new TreeNode("E", null, null);
            TreeNode fNode = new TreeNode("F", null, null);
            TreeNode gNode = new TreeNode("G", null, null);

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

        //前序遍历
        static void postOrderTraverse(TreeNode node) {
            if (node == null) {
                return;
            }

            postOrderTraverse(node.lChild);
            postOrderTraverse(node.rChild);
            Log.i("postOrderTraverse", node.data);
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
    }
}
