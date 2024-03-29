package main.java;//        1876. Substrings of Size Three with Distinct Characters
//
//        A string is good if there are no repeated characters.
//
//        Given a string s, return the number of good substrings of length three in s.
//
//        Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
//
//        A substring is a contiguous sequence of characters in a string.
//
//-----------------------------------------------------------
//        Example 1:
//        Input: s = "xyzzaz"
//        Output: 1
//        Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
//        The only good substring of length 3 is "xyz".
//
//-----------------------------------------------------------
//        Example 2:
//        Input: s = "aababcabc"
//        Output: 4
//        Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
//        The good substrings are "abc", "bca", "cab", and "abc".
import java.util.ArrayList;

public class CountGoodSubstrings {
    public static void main(String[] args) {
        String s = "aababcabc";

        System.out.println(countGoodSubstrrings(s));
    }

    private static int countGoodSubstrrings(String s) {
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i = 0 ; i < s.length() - 2; i++) {
            if(s.charAt(i) != s.charAt(i + 1) && s.charAt(i + 1) != s.charAt(i + 2) && s.charAt(i) != s.charAt(i + 2))
                arrayList.add(s.substring(i, i + 3));
        }

        return arrayList.size();
    }
}
