package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {
    private List<List<Integer>> res;
    private LinkedList<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        traceback(nums, 0);
        return res;
    }

    private void traceback(int[] nums, int start) {
        res.add(new LinkedList<>(path));
        //选择列表
        for (int i = start; i < nums.length; i++) {
            //做选择
            path.add(nums[i]);
            //回溯
            traceback(nums, i + 1);
            //撤销选择
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = new int[] {1,2,3};
        System.out.println(s.subsets(nums));
    }
}
