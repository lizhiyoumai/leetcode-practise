package com.leetcode;

public class Pow {
    public static double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n < 0) {
            return 1/myPowHepler(x, Math.abs((long)n));
        } else {
            return myPowHepler(x, n);
        }
    }

    private static double myPowHepler(double x, long n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 != 0) {
            double half = myPowHepler(x, n/2);
            return half * half * x;
        } else {
            double half = myPowHepler(x, n/2);
            return half * half;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -2147483648));
    }
}
