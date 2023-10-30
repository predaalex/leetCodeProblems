package main.java;
//55. Jump Game
//Medium
//You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//
//Return true if you can reach the last index, or false otherwise.
//
//-----------------------------------------------------------------
//Example 1:
//
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//-----------------------------------------------------------------
//Example 2:
//
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

public class JumpGame {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {0};

        System.out.println(canJump(nums1));
        System.out.println(canJump(nums2));
        System.out.println(canJump(nums3));

    }

//    public static boolean canJump(int[] nums) {
//        return jump(nums, 0);
//    }
//
//    public static boolean jump(int[] nums, int currIndex) {
//        boolean end = false;
//
//        if (currIndex >= nums.length - 1)
//            return true;
//
//        int jumpLength = nums[currIndex];
//
//        for (int i = 1; i <= jumpLength; i++) {
//            if (end) {
//                return true;
//            }
//            end = end || jump(nums, currIndex + i);
//        }
//
//        return end;
//    }

    private static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for(int i = 0; i < nums.length; i++) {
            int jumpLength = nums[i];

            if(dp[i] == 1) {
                if(i + jumpLength >= nums.length - 1)
                    return true;

                for(int j = 0; j <= jumpLength; j++){
                    if(i + j < nums.length) {
                        dp[i + j] = 1;
                    }
                }
            }

        }

        return false;
    }

}