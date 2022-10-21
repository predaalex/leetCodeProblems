//        219. Contains Duplicate II
//
//        Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
//==================================================================================
//        Example 1:
//        Input: nums = [1,2,3,1], k = 3
//        Output: true
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (Math.abs(i - j) > k)
                    break;

                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}
