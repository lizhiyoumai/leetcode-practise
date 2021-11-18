package com.leetcode;

/**
 * 并查集的简单实现【路径压缩+按秩排序】
 */
public class MergeFind {
    private int[] roots;
    private int[] rank;
    private void init(int n) {
        for (int i = 1; i <= n; i++) {
            roots[i] = i;
            rank[i] = 1;
        }
    }
    
    private int find(int x) {
        if (roots[x] == x) {
            return x;
        } else {
            roots[x] = find(roots[x]);
            return roots[x];
        }
    }
    
    private void merge(int i, int j) {
//        roots[find(x)] = find(y);
        int x = find(i), y = find(j);
        if (rank[x] <= rank[y]) {
            roots[x] = y;
        } else {
            roots[y] = x;
        }
        if (rank[x] == rank[y] && x != y) {
            rank[y]++;
        }
    }
}
