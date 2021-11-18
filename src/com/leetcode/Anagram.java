package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean isAnagram(String s, String t) {
        return getStasticMap(s).equals(getStasticMap(t));
    }

    private static Map<Character, Integer> getStasticMap(String s) {
        Map<Character, Integer> map = new HashMap<>(32);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static boolean isAnagram1(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram1("anagram", "nagaram"));
    }
}
