package com.leetcode;

/**
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitFrozen {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //定义一个二维数组，第一维度表示到第i天第最大利润，第二维度表示：0-持仓，1-空仓(不可买)，2-空仓(可买)
        int[][] mp = new int[n][3];
        mp[0][0] = -prices[0];
        mp[0][1] = 0;
        mp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            mp[i][0] = Math.max(mp[i-1][0], mp[i-1][2] - prices[i]);
            mp[i][1] = mp[i-1][0] + prices[i];
            mp[i][2] = Math.max(mp[i-1][1], mp[i-1][2]);
        }
        return Math.max(mp[n-1][1], mp[n-1][2]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
