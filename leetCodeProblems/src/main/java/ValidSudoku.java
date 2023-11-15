package main.java;

import java.util.HashSet;
import java.util.Set;
//36. Valid Sudoku
//Medium
//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//Note:
//
//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.
// ============================================================================
//Example 1:
//
//Input: board =
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: true
// --------------------------------------------------------------------------------
//Example 2:
//
//Input: board =
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(char[][] board) {

        // check columns && lines
        Set<Integer> setColoana;
        Set<Integer> setLinie;
        for (int j = 0; j < board[0].length; j++) {
            setColoana = new HashSet<>();
            setLinie = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                int coloana = Character.getNumericValue(board[i][j]);
                int linie = Character.getNumericValue(board[j][i]);

                if (setColoana.contains(coloana) && coloana != -1)
                    return false;
                else
                    setColoana.add(Character.getNumericValue(board[i][j]));

                if (setLinie.contains(linie) && linie != -1)
                    return false;
                else
                    setLinie.add(linie);
            }
        }

        //check squares
        Set<Integer> setPatrat;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                setPatrat = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int q = 0; q < 3; q++) {
                        int patrat = Character.getNumericValue(board[i + k][j + q]);
                        if (setPatrat.contains(patrat) && patrat != -1)
                            return false;
                        else
                            setPatrat.add(patrat);
                    }
                }

            }
        }

        return true;
    }
}
