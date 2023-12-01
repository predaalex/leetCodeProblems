package main.java;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 4, 5, 7};

        System.out.println(summaryRanges(nums1));
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int a, b, counter;
        for(int i = 0; i < nums.length; i++) {
            a = i;
            b = i + 1;
            counter = 0;
            while(b < nums.length && nums[a] == nums[b] - counter - 1) {
                counter += 1;
                b += 1;
            }
            if (counter == 0) {
                result.add(String.valueOf(nums[a]));
            } else {
                result.add(nums[a] + "->" + nums[b - 1]);
                i += counter;
            }
        }

        return result;
    }
}
