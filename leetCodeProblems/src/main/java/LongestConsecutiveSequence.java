package main.java;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(nums1));
    }

    private static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(Integer num : nums) {
            int value = map.getOrDefault(num - 1, 0) + 1;
            if (value > max)
                max = value;
            map.put(num, value);
        }
        return max;
    }
}
