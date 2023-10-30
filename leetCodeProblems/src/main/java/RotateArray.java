package main.java;

import java.util.Arrays;

//189. Rotate Array
//
//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//
//
//---------------------------------------------------------
//Example 1:
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//---------------------------------------------------------
//Example 2:
//
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
public class RotateArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7};
        int k1 = 5;
        int[] nums2 = {-1,-100,3,99};
        int k2 = 2;

        System.out.println(Arrays.toString(rotate(nums1, k1)));
    }

    private static int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        System.out.println(k);
        int[] arr = new int[nums.length - k];

        for(int i = 0; i < nums.length - k; i++)
            arr[i] = nums[i];

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < k; i++) {
            nums[i] = nums[nums.length - k + i];
        }

        for(int i = 0; i < arr.length; i++) {
            nums[i + k] = arr[i];
        }

        return nums;
    }
}
