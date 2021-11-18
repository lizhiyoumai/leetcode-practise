package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumberII {
    //使用map计数
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int singleNumber1(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //遍历
        int res = nums[0];
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == res) {
                count ++;
            } else {
                //判断上一个数字的count是否为1，是的话则直接返回
                if (count == 1) {
                    return res;
                }
                //否则重新赋值，重新开始计数
                res = nums[j];
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumberII sn = new SingleNumberII();
        int[] nums = new int[] {30000,500,100,30000,100,30000,100};
        System.out.println(sn.singleNumber1(nums));
    }
}
