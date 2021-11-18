package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
    //分别记录左括号和右括号用过的次数
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }

    private static void generate(int left, int rirht, int n, String result, List<String> list) {
        if (left == n && rirht == n) {
            list.add(result);
            return;
        }
        if (left < n) {
            generate(left + 1, rirht, n, result + "(", list);
        }
        if (rirht < n && rirht < left) {
            generate(left, rirht + 1, n, result + ")", list);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
