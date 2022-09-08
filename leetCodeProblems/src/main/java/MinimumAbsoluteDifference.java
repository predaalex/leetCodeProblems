/*
        1200. Minimum Absolute Difference
        Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

        Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

        a, b are from arr
        a < b
        b - a equals to the minimum absolute difference of any two elements in arr

        Example 1:
        Input: arr = [4,2,1,3]
        Output: [[1,2],[2,3],[3,4]]
        Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.

        Example 2:
        Input: arr = [1,3,6,10,15]
        Output: [[1,3]]

        Example 3:
        Input: arr = [3,8,-10,23,19,-4,-14,27]
        Output: [[-14,-10],[19,23],[23,27]]*/

import java.util.*;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {

        int[] input = {1,3,6,10,15};

        System.out.println(minimumAbsoluteDifference(input));
    }

    private static List<List<Integer>> minimumAbsoluteDifference(int[] arr) {

        List<List<Integer>> listReturn = new ArrayList<>();

        Arrays.sort(arr);

        int minDif = arr[1] - arr[0];

        for(int i = 0; i < arr.length - 1; i++) {
            if( arr[i + 1] - arr[i] < minDif ) {
                minDif = arr[i + 1] - arr[i];
                listReturn.clear();
            }

            if(arr[i + 1] - arr[i] == minDif) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                listReturn.add(list);
            }
        }

        return listReturn;
    }
}
