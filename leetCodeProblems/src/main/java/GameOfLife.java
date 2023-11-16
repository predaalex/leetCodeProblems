package main.java;

import java.util.Arrays;
//289. Game of Life
//Medium
//According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
//
//The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
//Any live cell with fewer than two live neighbors dies as if caused by under-population.
//Any live cell with two or three live neighbors lives on to the next generation.
//Any live cell with more than three live neighbors dies, as if by over-population.
//Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
//====================================================================
//Example 1:
//
//Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
//Example 2:
//-------------------------------------------------------------------
//Input: board = [[1,1],[1,0]]
//Output: [[1,1],[1,1]]
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board1 = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] board2 = {{0, 0}};

        gameOfLife(board2);

    }

    private static void gameOfLife(int[][] board) {

        int[][] copy = deepCopy(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int nrNeightbors = getNrNeightbors(board, i, j);
                if (board[i][j] == 1) {
                    if(nrNeightbors < 2){
                        copy[i][j] = 0;
                    } else if (nrNeightbors > 3) {
                        copy[i][j] = 0;
                    } else {
                        copy[i][j] = 1;
                    }
                } else if (nrNeightbors == 3) {
                    copy[i][j] = 1;
                }
            }
        }

        board = deepCopy(copy);
        System.out.println(Arrays.deepToString(board));
    }

    private static int[][] deepCopy(int[][] original) {
        if (original == null) return null;

        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = new int[original[i].length];
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }

    private static int getNrNeightbors(int[][] board, int i, int j) {
        int counter = 0;
        // stanga sus
        if (i > 0 && j > 0 && board[i - 1][j - 1] == 1)
            counter += 1;
        // sus
        if (i > 0 && board[i - 1][j] == 1)
            counter += 1;
        // dreapta sus
        if (i > 0 && j + 1 < board[0].length && board[i - 1][j + 1] == 1)
            counter += 1;
        // stanga
        if (j > 0 && board[i][j - 1] == 1)
            counter += 1;
        // dreapta
        if (j + 1 < board[0].length && board[i][j + 1] == 1)
            counter += 1;
        // stanga jos
        if (j > 0 && i + 1 < board.length && board[i + 1][j - 1] == 1)
            counter += 1;
        // jos
        if (i < board.length - 1 && board[i + 1][j] == 1)
            counter += 1;
        // dreapta jos
        if (i < board.length - 1 && j < board[0].length - 1 && board[i + 1][j + 1] == 1)
            counter += 1;
        return counter;
    }

    record Pair<A, B> (A first, B second) {
    }
}
