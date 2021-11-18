package com.leetcode;

import java.util.Arrays;

/**
 * 给出一个整数数组A和一个查询数组queries。
 *
 * 对于第i次查询，有val =queries[i][0], index= queries[i][1]，我们会把val加到A[index]上。然后，第i次查询的答案是 A 中偶数值的和。
 *
 * （此处给定的index = queries[i][1]是从 0 开始的索引，每次查询都会永久修改数组A。）
 *
 * 返回所有查询的答案。你的答案应当以数组answer给出，answer[i]为第i次查询的答案。
 *
 * 
 *
 * 示例：
 *
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumEvenAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            A[index] += val;
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum += A[j] % 2 == 0 ? A[j] : 0;
            }
            ans[i] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4};
        int[][] queries = {
                {1,0},
                {-3,1},
                {-4,0},
                {2,3}
        };
        SumEvenAfterQueries s = new SumEvenAfterQueries();
        System.out.println(Arrays.toString(s.sumEvenAfterQueries(A, queries)));
    }
}
