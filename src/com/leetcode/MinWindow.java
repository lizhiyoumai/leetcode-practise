package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {
    //滑动窗口经典题
    public String minWindow(String s, String t) {
        //定义两个map
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char c : chars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //初始化左右指针到位置
        int left = 0, right = 0;
        //初始化length和start
        int start = 0;
        int len = Integer.MAX_VALUE;
        //定义valid变量，记录window中满足need条件的元素个数
        int valid = 0;
        //扩大窗口
        while (right < s.length()) {
            //要进入窗口的元素
            char c = s.charAt(right);
            //右指针移动
            right ++;
            //更新窗口内的数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }

            //收缩窗口
            while (valid == need.size()) {
                //记录最小字串的开始位置和长度
                if (right - left < len) {
                    start = left;
                    len = right - start;
                }
                //要移出窗口的元素
                char c1 = s.charAt(left);
                //左指针移动
                left ++;
                //更新窗口内的数据
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid --;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
    }
}
