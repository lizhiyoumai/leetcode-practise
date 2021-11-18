package com.leetcode;

import java.util.*;

/**
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveNQueens {
    List<List<String>> res;
    Set<Integer> cols;
    Set<Integer> pies;
    Set<Integer> nas;

    public SolveNQueens(List<List<String>> res, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas) {
        this.res = res;
        this.cols = cols;
        this.pies = pies;
        this.nas = nas;
    }

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        //用二维数组初始化棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        backTrace(0, board);
        return res;
    }

    private void backTrace(int row, char[][] board) {
        if (row >= board.length) {
            res.add(charArraysToList(board));
        }
        for (int col = 0; col < board.length; col++) {
            if (cols.contains(col) || pies.contains(row + col) || nas.contains(row - col)) {
                continue;
            }
            cols.add(col);
            pies.add(row + col);
            nas.add(row - col);
            board[row][col] = 'Q';
            backTrace(row + 1, board);
            cols.remove(col);
            pies.remove(row + col);
            nas.remove(row - col);
            board[row][col] = '.';
        }

    }

    private List<String> charArraysToList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] c : board) {
            String str = new String(c);
            result.add(str);
        }
        return result;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens(new ArrayList<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());
        System.out.println(solveNQueens.solveNQueens(5));
    }

}
