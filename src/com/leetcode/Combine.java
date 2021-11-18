package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        traceback(n, k, 1);
        return res;
    }

    private void traceback(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            //做选择
            path.add(i);
            //回溯
            traceback(n, k, i + 1);
            //撤销选择
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine c = new Combine();
        System.out.println(c.combine(4, 2));
    }
}
