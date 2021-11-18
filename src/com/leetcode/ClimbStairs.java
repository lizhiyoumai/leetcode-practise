package com.leetcode;

/**
 * 【阿里面试笔试题】
 * 爬楼梯
 * 已知爬一级台阶，有一种走法；爬两级台阶，有两种走法；那n级台阶，有多少种走法？
 */
public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
