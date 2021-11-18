package com.leetcode;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TitleToNumber {
    //本质是26进制转10进制
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int factor = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            res += factor * (columnTitle.charAt(i) - 'A' + 1);
            factor *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        TitleToNumber t = new TitleToNumber();
        System.out.println(t.titleToNumber("ZY"));
    }
}
