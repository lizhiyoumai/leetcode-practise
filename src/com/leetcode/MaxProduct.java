package com.leetcode;

/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        //定义一个二维数组，第一维存0到i的乘积最大值，第二维存正/负(0表示正，1表示负)
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            //要注意的是，每次不一定要用到前边的数，则每次选与不选还要比对一下。
            dp[i][0] = nums[i] >= 0 ? Math.max(dp[i-1][0] * nums[i], nums[i]) : Math.max(dp[i-1][1] * nums[i], nums[i]);
            dp[i][1] = nums[i] >= 0 ? Math.min(dp[i-1][1] * nums[i], nums[i]) : Math.min(dp[i-1][0] * nums[i], nums[i]);
        }
        int max = dp[0][0];
        for (int i = 0; i < n; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 3, -4};
        System.out.println(maxProduct(nums));
    }
}
