package com.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        //base case
        if (nums.length == 0) {
            return;
        }
        int i = 0;
        int k = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            } else {
                k++;
            }
        }
        for (int j = 0; j < k; j++) {
            nums[i+j] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
