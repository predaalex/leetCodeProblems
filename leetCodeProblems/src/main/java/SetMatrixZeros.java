package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
//73. Set Matrix Zeroes
//Medium
//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//You must do it in place.
// ====================================================================
//Example 1:
//
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
// -------------------------------------------------------------------
//Example 2:
//
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix3 = {{0, 1}};

        setZeros(matrix3);

    }

    private static void setZeros(int[][] matrix) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    list.add(new Pair<>(i, j));
            }
        }

        for(Pair<Integer, Integer> pair : list) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][pair.getSecond()] = 0;
            }
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[pair.getFirst()][j] = 0;
            }
        }

        System.out.println(list);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return first + " " + second;
        }
    }
}
