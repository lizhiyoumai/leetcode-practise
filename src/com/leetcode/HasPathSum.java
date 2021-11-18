package com.leetcode;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, root.val, targetSum);
    }

    private boolean dfs(TreeNode node, int curr, int targetSum) {
        if (node.left == null && node.right == null) {
            if (curr == targetSum) {
                return true;
            }
            return false;
        }

        return node.left == null ? dfs(node.right, curr + node.right.val, targetSum) : node.right == null ? dfs(node.left, curr + node.left.val, targetSum) : dfs(node.left, curr + node.left.val, targetSum) || dfs(node.right, curr + node.right.val, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(8);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(2);
        n1.left = n3;
        n3.left = n4;
        n3.right = n5;
        TreeNode n6 = new TreeNode(13);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(1);
        n2.left = n6;
        n2.right = n7;
        n7.right = n8;
        int target = 22;
        HasPathSum hps = new HasPathSum();
        System.out.println(hps.hasPathSum(root, target));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
