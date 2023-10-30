package main.java;/*
        1504. Count Submatrices With All Ones
        Given an m x n binary matrix mat, return the number of submatrices that have all ones.

        Example 1:

        Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
        Output: 13
        Explanation:
        There are 6 rectangles of side 1x1.
        There are 2 rectangles of side 1x2.
        There are 3 rectangles of side 2x1.
        There is 1 rectangle of side 2x2.
        There is 1 rectangle of side 3x1.
        Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.

        ---------------------------------------------------------
        Example 2:

        Input: mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
        Output: 24
        Explanation:
        There are 8 rectangles of side 1x1.
        There are 5 rectangles of side 1x2.
        There are 2 rectangles of side 1x3.
        There are 4 rectangles of side 2x1.
        There are 2 rectangles of side 2x2.
        There are 2 rectangles of side 3x1.
        There is 1 rectangle of side 3x2.
        Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.*/

public class SubmatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] mat = {{0,1,1,0},{0,1,1,1},{1,1,1,0}};

//        int[][] mat = {{1,0,1},{1,1,0},{1,1,0}};
        System.out.println(submatricesWithAllOnes(mat));
    }

    private static int submatricesWithAllOnes(int[][] mat) {
        int count = 0;

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++ ) {

                if(mat[i][j] == 1) {

                    int iLength = mat.length;
                    int jLength = mat[i].length;

                    for(int k = i; k < iLength; k++) {
                        if(mat[k][j] == 0)
                            break;

                        for(int q = j; q < jLength; q++) {
                            if(mat[k][q] == 0){
                                jLength = q;
                                break;
                            } else
                                count++;
                        }
                    }
                    System.out.println(i + " " + j + " -> " + count);
                }
            }
        }


        return count;
    }
}
