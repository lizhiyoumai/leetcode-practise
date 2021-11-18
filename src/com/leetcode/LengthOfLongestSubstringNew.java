package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
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
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstringNew {
    public int lengthOfLongestSubstring(String s) {
        //定义结果
        int res = 0;
        //定义一个map
        Map<Character, Integer> window = new HashMap<>();
        //定义左右指针
        int left = 0, right = 0;
        while (right < s.length()) {
            //要进入窗口的元素
            char c = s.charAt(right);
            //移动右指针
            right ++;
            //更新窗口内的数据
            window.put(c, window.getOrDefault(c, 0) + 1);

            //收缩窗口
            while (window.get(c) > 1) {
                //要移出的元素
                char c1 = s.charAt(left);
                //移动左指针
                left ++;
                //更新窗口内的数据
                window.put(c1, window.get(c1) - 1);
            }

            //更新结果
            res = Math.max(res, right - left);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstringNew().lengthOfLongestSubstring("abcabcbb"));
    }
}
