package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallest {
    //二叉搜索树，中序遍历的结果就是升序排列
    List<Integer> res;
    public int kthSmallest(TreeNode root, int k) {
        res = new ArrayList<>();
        inorder(root);
        return res.size() >= k -1 ? res.get(k-1) : -1;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
