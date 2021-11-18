package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字节二面算法
 * 给你一个蒸熟数组nums，数组中多元素互不相同。返回该数组所有可能多子集(幂集)
 * 解集不能包含重复多子集，你可以按任何顺序返回解集。
 *
 * 示例：
 * 输入 nums = {1, 2, 3}
 * 返回 [], [1], [2], [3], [1, 2], [1, 3],[2, 3], [1, 2, 3]
 *
 * 附回溯算法模板：
 *  result = []
 *  def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 */
public class AllSubSet {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> track) {
        res.add(new ArrayList<>(track));
        //选择列表
        for (int i = start; i < nums.length; i++) {
            //做选择
            track.add(nums[i]);
            //回溯
            backtrack(nums, i + 1, track);
            //撤销选择
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        AllSubSet ass = new AllSubSet();
        System.out.println(ass.subsets(nums));
    }
}
