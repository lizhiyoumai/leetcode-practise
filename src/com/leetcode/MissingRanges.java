package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序的整数数组 nums，其中元素的范围在闭区间[lower, upper]当中，返回不包含在数组中的缺失区间。
 *
 * 示例：
 *
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int len = nums.length;
        List<String> res = new ArrayList<>();
        if (len == 0) {
            res.add("0->99");
            return res;
        }
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] + 1 > nums[i + 1] - 1) {

            }else if (nums[i] + 1 == nums[i + 1] - 1) {
                res.add("" + nums[i] + 1);
            } else {
                res.add("" + (nums[i] + 1) + "->" + (nums[i + 1] - 1));
            }
        }
        //处理开头的区间
        if (lower == nums[0]) {

        } else if (lower + 1 > nums[0] - 1) {
            res.add("" + lower);
        } else if (lower + 1 == nums[0] - 1) {
            res.add("" + (lower + 1));
        } else {
            res.add("" + (lower + 1) + "->" + (nums[0] - 1));
        }
        //处理结尾的区间
        if (nums[len - 1] == upper - 1) {

        } else if (nums[len - 1] + 1 > upper - 1) {
            res.add("" + upper);
        } else if (nums[len - 1] + 1 == upper - 1) {
            res.add("" + (upper - 1));
        } else {
            res.add("" + (nums[len - 1] + 1) + "->" + (upper - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        MissingRanges missingRanges = new MissingRanges();
        int[] nums = new int[]{0, 1, 3, 50, 75};
        int lower = 0, upper = 99;
        System.out.println(missingRanges.findMissingRanges(nums, lower, upper));
    }

}
