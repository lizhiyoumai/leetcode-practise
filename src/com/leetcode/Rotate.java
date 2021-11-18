package com.leetcode;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k个位置，其中k是非负数。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        //base case
        if (nums.length == 0) {
            return;
        }
        //length special handle
        k %= nums.length;
        //reverse total
        reverse(nums, 0, nums.length - 1);
        //reverse left
        reverse(nums, 0, k - 1);
        //reverse right
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        int k = 2;
        Rotate rotate = new Rotate();
        rotate.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
