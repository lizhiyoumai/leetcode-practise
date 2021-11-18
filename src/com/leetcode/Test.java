package com.leetcode;

public class Test {
    public static void main(String[] args) {
        Student a = new Student();
        a.name = "bbb";
        a.age = 11;
        Student b = a;
        System.out.println(b.name+ "/" + b.age);
    }

    private static class Student {
        private String name;
        private int age;
    }
}
