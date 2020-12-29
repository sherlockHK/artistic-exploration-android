package com.gakki.hk.artistic_exploration_android.data_structure;

/**
 * @author : hukai50
 * @date : 2020/12/22 下午9:43
 * @desc :
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
