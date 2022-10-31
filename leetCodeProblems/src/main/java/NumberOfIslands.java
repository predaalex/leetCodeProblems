//        200. Number of Islands
//
//        Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//
//        An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//=======================================================================
//        Example 1:
//        Input: grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//        Output: 1
//-----------------------------------------------------------------------
//        Example 2:
//        Input: grid = [
//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//        Output: 3
public class NumberOfIslands {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        char[][] grid =
                {{'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));
        long endTime = System.nanoTime();
        System.out.println("Runtine:" + (endTime - startTime));
    }

    private static int numIslands(char[][] grid) {
        int counter = 0;

        if (grid.length == 0)
            return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandMark(grid, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void islandMark(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        //sus
        islandMark(grid, i - 1, j);
        //jos
        islandMark(grid, i + 1, j);
        //stanga
        islandMark(grid, i, j - 1);
        //dreapta
        islandMark(grid, i, j + 1);
    }

}
