//        1909. Remove One Element to Make the Array Strictly Increasing
//
//        Given a 0-indexed integer array nums, return true if it can be made strictly increasing after removing exactly one element, or false otherwise. If the array is already strictly increasing, return true.
//
//        The array nums is strictly increasing if nums[i - 1] < nums[i] for each index (1 <= i < nums.length).
//
//-------------------------------------------------------
//        Example 1:
//        Input: nums = [1,2,10,5,7]
//        Output: true
//        Explanation: By removing 10 at index 2 from nums, it becomes [1,2,5,7].
//        [1,2,5,7] is strictly increasing, so return true.

import java.util.ArrayList;

public class CanBeIncreasing {
    public static void main(String[] args) {
        int[] nums = {1,2,10,5,7};

        System.out.println(canBeIncreasing(nums));
    }

    private static boolean canBeIncreasing(int[] nums) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean strictlyIncreasing = false;

        for(int i : nums)
            arrayList.add(i);

        for(int i = 0; i < arrayList.size(); i++){
            int aux = arrayList.get(i);
            arrayList.remove(i);

            if(arrCheck(arrayList)){
                strictlyIncreasing = true;
                break;
            }

            arrayList.add(i, aux);
        }

        return  strictlyIncreasing;
    }

    private static boolean arrCheck(ArrayList<Integer> arrayList) {

        int aux = Integer.MIN_VALUE;

        for(Integer i : arrayList) {
            if(i <= aux)
                return false;
            aux = i;
        }

        return true;
    }
}
