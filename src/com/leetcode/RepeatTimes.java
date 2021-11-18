package com.leetcode;

/**
 * 【阿里面试笔试题】
 * 求字符串b在字符串a中出现的次数
 * 例如：字符串a='aabbaabb',b='aabb'，则b在a中出现的次数为2
 */
public class RepeatTimes {
    public static int repeatTimes(String a, String b) {
        int count = 0;
        while (a.contains(b)) {
            count ++;
            a = a.substring(a.indexOf(b) + b.length());
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(repeatTimes("aabbaabb", "ab"));
    }
}
