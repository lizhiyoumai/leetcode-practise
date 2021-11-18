package com.leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例1:
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 示例 4：
 *
 * 输入：prices = [1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitIII {
    //思路和K次交易的题一样，将K设置为2即可
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //定义一个三维数组
        int[][][] mp = new int[n][2][3];
        for (int k = 0; k <= 2 ; k++) {
            mp[0][0][k] = 0;
            mp[0][1][k] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= 2; k++) {
                mp[i][0][k] = Math.max(mp[i-1][0][k], mp[i-1][1][k] + prices[i]);
                mp[i][1][k] = Math.max(mp[i-1][1][k], mp[i-1][0][k-1] - prices[i]);
            }
        }

        int max = 0;
        for (int k = 0; k <= 2 ; k++) {
            if (mp[n-1][0][k] > max) {
                max = mp[n-1][0][k];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1};
        System.out.println(maxProfit(prices));
    }
}
