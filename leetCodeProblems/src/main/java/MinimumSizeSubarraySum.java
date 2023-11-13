package main.java;
//209. Minimum Size Subarray Sum
//Medium
//
//Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
//whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
//===================================================================================================
//Example 1:
//
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//---------------------------------------------------------------------------------------------------
//Example 2:
//
//Input: target = 4, nums = [1,4,4]
//Output: 1
//---------------------------------------------------------------------------------------------------
//Example 3:
//
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;

        int[] nums2 = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
        int target2 = 213;

        System.out.println(minSubArrayLen(target2, nums2));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;

        for (end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
                sum -= nums[start];
                minLength = Math.min(minLength, end - start + 1);
                start++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
