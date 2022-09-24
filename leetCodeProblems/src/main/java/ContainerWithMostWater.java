//        11. Container With Most Water
//
//        You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//        Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//        Return the maximum amount of water a container can store.
//
//        Notice that you may not slant the container.
//
//-------------------------------------------
//        Example 1:
//        Input: height = [1,8,6,2,5,4,8,3,7]
//        Output: 49
//        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//
//-------------------------------------------
//        Example 2:
//        Input: height = [1,1]
//        Output: 1

public class ContainerWithMostWater {
    public static void main(String[] args) {
//        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] heights = {2,3,4,5,18,17,6};
        System.out.println("max = " + maxArea(heights));
    }

    private static int maxArea(int[] heights) {

        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            //calculate area in right
            int rightArea = rightAreaCalculation(i, heights);

            maxArea = Math.max(rightArea, maxArea);
        }

        return maxArea;
    }

    private static int rightAreaCalculation(int i, int[] heights) {
        int rightArea = 0;
        int aux;
        for(int j = heights.length - 1; j > i; j--){
            aux = (j - i) * Math.min(heights[i], heights[j]);
            rightArea = Math.max(aux, rightArea);
            if(heights[j] >= heights[i])
                break;
        }

        return rightArea;
    }

}
