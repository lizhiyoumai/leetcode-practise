package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        //定义两个map
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] chars = s1.toCharArray();
        for (char c : chars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //定义valid，用来记录窗口中满足need条件的元素的个数
        int valid = 0;
        //定义左右指针
        int left = 0, right = 0;
        while (right < s2.length()) {
            //要进入窗口的元素
            char c = s2.charAt(right);
            //右指针移动
            right ++;
            //更新窗口内的数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid ++;
                }
            }

            //收缩窗口
            while (right - left == s1.length()) {
                //判断结果
                if (valid == need.size()) {
                    return true;
                }
                //要移出窗口的元素
                char c1 = s2.charAt(left);
                //移动左指针
                left ++;
                //更新窗口内的数据
                if (need.containsKey(c1)) {
                    if (need.get(c1).equals(window.get(c1))) {
                        valid --;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion("ab", "eidboaoo"));
    }
}
