//        523. Continuous Subarray Sum
//
//        Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
//
//        An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
//=================================================================================================
//        Example 1:
//        Input: nums = [23,2,4,6,7], k = 6
//        Output: true
//        Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
//-------------------------------------------------------------------------------------------------
//        Example 2:
//        Input: nums = [23,2,6,4,7], k = 6
//        Output: true
//        Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
//        42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
//-------------------------------------------------------------------------------------------------
//        Example 3:
//        Input: nums = [23,2,6,4,7], k = 13
//        Output: false

import java.util.HashMap;

public class ContinousSubarraySum {
    public static void main(String[] args) {
        int[] nums = {5, 0, 0, 0};
        int k = 3;

        System.out.println(checkSubarraySum(nums, k));
    }

    private static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // key is runningSum and value is pos of runningSum
        // if map contains 2 similar values it means that there is a multiple of that number
        map.put(0, -1);
        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];

            if (k != 0)
                runningSum %= k;

            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - Math.abs(prev) > 1)
                    return true;
            } else
                map.put(runningSum, i);
        }
        return false;
    }
}
