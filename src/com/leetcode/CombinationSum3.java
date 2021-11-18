package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum3 {
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        traceback(k, n, 1, 0);
        return res;
    }

    private void traceback(int k, int n, int start, int sum) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new LinkedList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            sum += i;
            traceback(k, n, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 7));
    }
}
