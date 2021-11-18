package com.leetcode;

/**
 * K次交易
 * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitIV {
    public static int maxProfit(int K, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //定义一个三维数组，第一维表示到第i天的最大利润值，第二维度表示到第i天最多完成的交易数(买入的次数)，第三维度表示第i天是否持有股票
        int[][][] mp = new int[n][2][K+1];
        for (int k = 0; k <= K; k++) {
            mp[0][0][k] = 0;
            mp[0][1][k] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                mp[i][0][k] = Math.max(mp[i-1][0][k], mp[i-1][1][k] + prices[i]);
                mp[i][1][k] = Math.max(mp[i-1][1][k], mp[i-1][0][k-1] - prices[i]);
            }
        }
        int max = 0;
        for (int k = 0; k <= K; k++) {
            if (mp[n-1][0][k] > max) {
                max = mp[n-1][0][k];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }
}
