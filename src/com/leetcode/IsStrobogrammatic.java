package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 中心对称数是指一个数字在旋转了180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 *
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 *
 *
 * 示例 1:
 *
 * 输入: num = "69"
 * 输出: true
 * 示例 2:
 *
 * 输入: num = "88"
 * 输出: true
 * 示例 3:
 *
 * 输入: num = "962"
 * 输出: false
 * 示例 4：
 *
 * 输入：num = "1"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsStrobogrammatic {
    public boolean isStrobogrammatic(String num) {
        if (num.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>(8);
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            if (map.containsKey(num.charAt(i))) {
                sb.append(map.get(num.charAt(i)));
            }
        }
        return sb.toString().equals(num);
    }

    public static void main(String[] args) {
        IsStrobogrammatic is = new IsStrobogrammatic();
        System.out.println(is.isStrobogrammatic("18"));
    }
}
