package com.leetcode.jianoffer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        char[] charArray = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = "We are happy.";
        System.out.println(replaceSpace.replaceSpace(s));
    }
}
