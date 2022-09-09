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

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersWithSameConsecDiff {
    public static void main(String[] args) {

        int n = 7;
        int k = 9;
        System.out.println(Arrays.toString(numsSameConsecDiff(n, k)));

    }

    private static int[] numsSameConsecDiff(int n, int k) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++)
            if(nrValidation(i, k))
                arrayList.add(i);

        int[] arr = new int[arrayList.size()];

        int j = 0;

        for(Integer i : arrayList)
            arr[j++] = i;

        return arr;
    }

    private static boolean nrValidation(int n, int k) {

        //181
        boolean valid = false;
        int i = n;
        int a;

        while(i >= 10){

            a = i % 10;
            i = i / 10;

            if( Math.abs(a - (i % 10)) == k || Math.abs((i % 10) - a) == k){
                valid = true;
            } else {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
