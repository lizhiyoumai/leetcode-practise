package com.leetcode;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class NumTreesNew {
    public int numTrees(int n) {
        //定义dp数组，表示以1到i为节点的二叉搜索树的种数
        int[] dp = new int[n + 1];
        //初始化
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumTreesNew().numTrees(1));
    }
}
