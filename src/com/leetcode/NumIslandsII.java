package com.leetcode;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslandsII {
    private int[] roots;
    private int[] rank;
    private int count;

    //并查集实现
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        init(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if ((i-1) >= 0 && grid[i-1][j] == '1') {
                        union(i * n + j, (i - 1) * n + j);
                    }
                    if ((i+1) < m && grid[i+1][j] == '1') {
                        union(i * n + j, (i + 1) * n + j);
                    }
                    if ((j-1) >= 0 && grid[i][j-1] == '1') {
                        union(i * n + j, i * n + (j - 1));
                    }
                    if ((j+1) < n && grid[i][j+1] == '1') {
                        union(i * n + j, i * n + (j + 1));
                    }
                }
            }
        }
        return count;
    }

    private void init(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        count = 0;
        roots = new int[m*n];
        rank = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    roots[i * n + j] = i * n + j;
                    rank[i * n + j] = 0;
                    count ++;
                }
            }
        }
    }

    private void union(int x, int y) {
        int rootx = find(x), rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] < rank[rooty]) {
                roots[rootx] = rooty;
            } else if (rank[rootx] > rank[rooty]) {
                roots[rooty] = rootx;
            } else {
                roots[rooty] = rootx;
                rank[rootx]++;
            }
            count--;
        }
    }

    private int find(int x) {
        if (roots[x] == x) {
            return x;
        }
        roots[x] = find(roots[x]);
        return roots[x];
    }

    public static void main(String[] args) {
        NumIslandsII numIslands = new NumIslandsII();
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands.numIslands(grid));
    }
}
