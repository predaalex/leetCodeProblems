        /*967. Numbers With Same Consecutive Differences

        Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

        Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

        You may return the answer in any order.
        -----------------------------------------------------------------------------------
        Example 1:
        Input: n = 3, k = 7
        Output: [181,292,707,818,929]
        Explanation: Note that 070 is not a valid number, because it has leading zeroes.
        Example 2:
        Input: n = 2, k = 1
        Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumbersWithSameConsecDiff {
    public static void main(String[] args) {

        int n = 2;
        int k = 0;
        System.out.println(Arrays.toString(numsSameConsecDiff(n, k)));
    }

    private static int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> set = new HashSet<>();

        nrCreate(set, n, k, 0, 0);

        int[] arr = new int[set.size()];

        int j = 0;
        for(Integer i : set)
            arr[j++] = i;

        return arr;
    }

    private static void nrCreate(Set<Integer> set, int n, int k, int len, int num) {
        if(len == n){
            set.add(num);
            return;
        }

        if(num == 0){
            for(int i = 1; i < 10; i++) {
                nrCreate(set, n, k , len + 1, i);
            }
        } else {
            int lastDigit = num % 10;
            int after = lastDigit + k;
            int before = lastDigit - k;
            if(after >= 0 && after <= 9)
                nrCreate(set, n, k, len + 1, num * 10 + after);
            if(before >= 0 && before <= 9)
                nrCreate(set, n, k, len + 1, num * 10 + before);
        }
    }


}
