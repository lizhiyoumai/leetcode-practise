package com.leetcode;

import java.util.Arrays;

/**
 * 给定一个字符串S，返回“反转后的”字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * 
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        if (S.length() == 0 || S.length() == 1) {
            return S;
        }
        char[] s = S.toCharArray();
        int left = 0, right = s.length - 1;
        while (left < right) {
            if (Character.isLetter(s[left]) && Character.isLetter(s[right])) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left ++;
                right --;
            }
            if (!Character.isLetter(s[left])) {
                left ++;
            }
            if (!Character.isLetter(s[right])) {
                right --;
            }
        }
        return String.valueOf(s);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters rol = new ReverseOnlyLetters();
        System.out.println(rol.reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
