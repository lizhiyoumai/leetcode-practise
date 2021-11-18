package com.leetcode;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字1和0。
 *
 * 
 *
 * 示例1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int lena  = a.length();
        int lenb = b.length();
        while (lena < lenb) {
            a = "0" + a;
            lena ++;
        }
        while (lena > lenb) {
            b = "0" + b;
            lenb ++;
        }

        char[] attra = a.toCharArray();
        int[] inta = new int[attra.length];
        for (int i = 0; i < attra.length; i++) {
            inta[i] = attra[i] == '0' ? 0 : 1;
        }
        char[] attrb = b.toCharArray();
        int[] intb = new int[attrb.length];
        for (int i = 0; i < attrb.length; i++) {
            intb[i] = attrb[i] == '0' ? 0 : 1;
        }
        int carry = 0;
        for (int i = inta.length - 1; i >= 0; i--) {
            int val = inta[i] + intb[i] + carry;
            inta[i] = val % 2;
            carry = val / 2;
        }
        if (carry == 1) {
            int[] res = new int[inta.length + 1];
            res[0] = 1;
            System.arraycopy(inta, 0, res, 1, inta.length);
            return intArrayToString(res);
        }
        return intArrayToString(inta);
    }

    private String intArrayToString(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("1010", "1011"));
    }
}
