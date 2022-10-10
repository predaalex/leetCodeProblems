//        1. Two Sum
//
//        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        You can return the answer in any order.
//=====================================================================
//        Example 1:
//
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        int target = 10;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int nr1 = 0, nr2 = 0;

        for (int num : nums) {

            if (hashMap.containsKey(target - num)) {
                nr1 = target - num;
                nr2 = num;
                break;
            }
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int[] index = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nr1 && index[0] == 0){
                index[0] = i;
                continue;
            }
            if(nums[i] == nr2)
                index[1] = i;
        }

        return index;
    }
}
