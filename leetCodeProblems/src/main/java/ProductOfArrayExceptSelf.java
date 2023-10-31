package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//238. Product of Array Except Self
//Medium
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//
//-----------------------------------------------------------------
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//-----------------------------------------------------------------
//Example 2:
//
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {4,3,2,1,2};

        System.out.println(Arrays.toString(productExceptself(nums1)));
        System.out.println(Arrays.toString(productExceptself(nums2)));

    }

    private static int[] productExceptself(int[] nums) {
        int[] answer = new int[nums.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        if (map.get(0) == null || map.get(0) <= 1) {
            Arrays.fill(answer, 1);
        } else {
            Arrays.fill(answer, 0);
            return answer;
        }


        for(int i = 0; i < answer.length; i++){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getKey() != nums[i])
                    answer[i] *= (int) Math.pow(entry.getKey(), entry.getValue());
                if(answer[i] == 0)
                    break;
            }

            if(map.get(nums[i]) != null &&  map.get(nums[i]) - 1 >= 1) {
                answer[i] *= (int) Math.pow(nums[i], map.get(nums[i]) - 1);
            }
        }

        return answer;
    }
}
