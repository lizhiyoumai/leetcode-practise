package com.leetcode;

import java.util.*;

/**
 * 两数之和
 * 采用查找表法---哈希表
 * 时间复杂度为O(n),空间复杂度为O(n)
 */
public class TwoSums {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 13)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length-1);
        map.put(nums[0], 0);
        for(int i=1; i<length; i++) {
            int annother = target - nums[i];
            if (map.containsKey(annother)) {
                return new int[]{i, map.get(annother)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}
