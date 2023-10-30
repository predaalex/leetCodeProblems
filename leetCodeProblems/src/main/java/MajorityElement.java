package main.java;
//169. Majority Element
//
//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//
//-------------------------------------------
//Example 1:
//
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//
//-------------------------------------------
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2,2,1,1,1,2,2,3};

        System.out.println(majorityElement(nums2));
    }

    private static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for(int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count += 1;
            }
            if (candidate != num) {
                count -= 1;
            }
        }

        return candidate;
    }
}
