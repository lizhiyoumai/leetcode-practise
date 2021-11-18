package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 *
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {
    //滑动窗口的解法
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        int max = 0;
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < length) {
            char c1 = s.charAt(right);//即将进入窗口的元素
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            right ++;//右移窗口
            while (window.get(c1) > 1) {
                char c2 = s.charAt(left);//即将移出窗口的元素
                window.put(c2, window.get(c2) - 1);
                left ++;//左移窗口
            }
            if (right - left > max) {
                max = right - left;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "ab";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
