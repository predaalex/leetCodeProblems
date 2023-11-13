package main.java;

import java.util.HashSet;
//3. Longest Substring Without Repeating Characters
//Medium
//
//Given a string s, find the length of the longest substring without repeating characters.
//===================================================================================================
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//---------------------------------------------------------------------------------------------------
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//---------------------------------------------------------------------------------------------------
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbb";
        String s3 = "pwwkew";
        String s4 = "dvdf";

        System.out.println(lengthOfLongestSubstring(s3));
    }

    private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int start = 0;
        int end;

        for(end = 0; end < s.length(); end++) {
            if (set.contains(s.charAt(end))) {
                maxLen = Math.max(maxLen, end - start);

                while(s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start));
                    start += 1;
                }
                start += 1;

            } else {
                set.add(s.charAt(end));
            }
        }

        return Math.max(maxLen, end - start);
    }
}
