package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    List<List<String>> res;

    //在n*n的board上防治n个皇后，皇后之间不能互相攻击
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], ".");
        }
        traceBack(board, 0);
        return res;
    }

    private void traceBack(String[][] board, int row) {
        //1.终止条件
        if (row == board.length) {
            res.add(arrayToList(board));
            return;
        }
        //2.for 选择 in 选择列表
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            //排除不合法的选择
            if (!isValid(board, row, col)) {
                continue;
            }
            //做选择
            board[row][col] = "Q";
            //回溯
            traceBack(board, row + 1);
            //撤销选择
            board[row][col] = ".";
        }
    }

    private List<String> arrayToList(String[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    private boolean isValid(String[][] board, int row, int col) {
        int m = board.length, n = board[row].length;
        //判断同一列是否有皇后
        for (int i = 0; i < m; i++) {
            if ("Q".equals(board[i][col])) {
                return false;
            }
        }
        //判断左上方是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        //判断右上方是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }

}
