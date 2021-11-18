package com.leetcode;

/**
 * 一个长字符串中含多个连续和不连续的空格，求不含空格的最长字符串长度，要求算法尽可能最优。
 * 例如输入："a1 123# abc"，结果：4
 */
public class MaxStringLength {
    public static int maxLength(String str) {
        //最大长度
        int max = 0;
        //计数器
        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                count ++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxLength("a1 123# abc"));
    }
}
