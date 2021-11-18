package com.leetcode;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartition {
    //转化为背包问题：
    // 给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。
    // 现在让你装物品，是否存在一种装法，能够恰好将背包装满？
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int W = 0;
        for (int num : nums) {
            W += num;
        }
        if (W % 2 != 0) {
            return false;
        }
        W /= 2;
        //定义dp数组，表示前i个物品，能否恰好装满重量为j的背包
        boolean[][] dp = new boolean[N + 1][W + 1];
        //初始化
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= W; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                // 背包容量不足，不能装入第 i 个物品
                if (nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
            }
        }

        return dp[N][W];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,5};
        System.out.println(new CanPartition().canPartition(nums));
    }
}
