package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSumNew {
    private List<List<Integer>> res;
    private LinkedList<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res  = new LinkedList<>();
        path = new LinkedList<>();
        if (root == null) {
            return res;
        }
        path.add(root.val);
        backtrace(root, targetSum - root.val);
        return res;
    }

    private void backtrace(TreeNode root, int count) {
        //结束条件
        if (root.left == null && root.right == null) {
            if (count == 0) {
                res.add(new LinkedList<>(path));
                return;
            }
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            count -= root.left.val;
            backtrace(root.left, count);
            //撤销选择
            path.removeLast();
            count += root.left.val;
        }
        if (root.right != null) {
            path.add(root.right.val);
            count -= root.right.val;
            backtrace(root.right, count);
            //撤销选择
            path.removeLast();
            count += root.right.val;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        PathSumNew pathSum = new PathSumNew();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        System.out.println(pathSum.pathSum(root, 22));
    }
}
