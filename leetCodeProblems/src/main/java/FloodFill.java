package main.java;//        733. Flood Fill
//
//        An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//
//        You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
//
//        To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
//
//        Return the modified image after performing the flood fill.
//===========================================================================================
//        Example 1:
//        Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//        Output: [[2,2,2],[2,2,0],[2,0,1]]
//        Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
//        Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int startColor = image[sr][sc];
        if (startColor == color)
            return image;
        fill(image, sr, sc, color, startColor);
        return image;
    }

    private static void fill(int[][] image, int sr, int sc, int color, int startColor) {
        if (image[sr][sc] == startColor)
            image[sr][sc] = color;
        //dreapta
        if (image[0].length - 1 > sc && image[sr][sc + 1] == startColor)
            fill(image, sr, sc + 1, color, startColor);
        //stanga
        if (sc > 0 && image[sr][sc - 1] == startColor)
            fill(image, sr, sc - 1, color, startColor);
        //sus
        if (sr > 0 && image[sr - 1][sc] == startColor)
            fill(image, sr - 1, sc, color, startColor);
        //jos
        if (image.length - 1 > sr && image[sr + 1][sc] == startColor)
            fill(image, sr + 1, sc, color, startColor);
    }
}
