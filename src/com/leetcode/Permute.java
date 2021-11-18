package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        traceBack(nums);
        return res;
    }

    private void traceBack(int[] nums) {
        //结束条件
        if (path.size() == nums.length) {
            //这里要注意，因为curr是引用类型的对象，下面有添加和删除元素的操作，所以必须拷贝一份
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (path.contains(nums[i])) {
                continue;
            }
            //做选择
            path.add(nums[i]);
            //回溯
            traceBack(nums);
            //撤销选择
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Permute p = new Permute();
        System.out.println(p.permute(nums));
    }
}
