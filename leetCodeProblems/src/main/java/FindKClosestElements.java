package main.java;//        658. Find K Closest Elements
//        Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
//        An integer a is closer to x than an integer b if:
//
//        |a - x| < |b - x|, or
//        |a - x| == |b - x| and a < b
//-------------------------------------------
//        Example 1:
//        Input: arr = [1,2,3,4,5], k = 4, x = 3
//        Output: [1,2,3,4]
//--------------------------------------
//        Example 2:
//        Input: arr = [1,2,3,4,5], k = 4, x = -1
//        Output: [1,2,3,4]
import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        int x = 3;

        System.out.println(findClosestElements(arr, k, x));
    }

    private static List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> list = new ArrayList<>();

        int start = 0;
        int end = arr.length-1;

        while(start < end && (end - start + 1) > k)
        {
            int sDiff = Math.abs(arr[start] - x);
            int eDiff =  Math.abs(arr[end] - x);

            if(eDiff >= sDiff)
                end--;
            else
                start++;
        }


        for(int i=start; i<=end; i++)
            list.add(arr[i]);

        return list;
    }
}
