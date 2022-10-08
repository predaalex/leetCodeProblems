//        16. 3Sum Closest
//        Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//        Return the sum of the three integers.
//
//        You may assume that each input would have exactly one solution.
//=====================================================================
//        Example 1:
//
//        Input: nums = [-1,2,1,-4], target = 1
//        Output: 2
//        Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//---------------------------------------------------------------------
//        Example 2:
//
//        Input: nums = [0,0,0], target = 1
//        Output: 0
//        Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        int target = 3;

        System.out.println(threeSumClosest(nums, target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        int start, end, middle;
        int n;

        if(nums.length - 1 == 2)
            return Arrays.stream(nums).sum();

        // -4, -1, 1, 2
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++){
            start = nums[i];
            n = nums.length - 1;
            int j = i + 1;

            while(j < n) {
                end = nums[n];
                middle = nums[j];

                int sum = start + end + middle;

                if(sum == target) {
                    return sum;
                }
                if(sum > target)
                    n -= 1;
                if(sum < target)
                    j += 1;

                if(Math.abs(target - sum) < Math.abs(target - closestSum))
                    closestSum = sum;
            }

        }

        return closestSum;
    }
}
