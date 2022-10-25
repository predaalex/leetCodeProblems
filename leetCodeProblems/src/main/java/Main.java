//        409. Longest Palindrome
//
//        Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//
//        Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
//===========================================================================================
//        Example 1:
//        Input: s = "abccccdd"
//        Output: 7
//        Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
//-------------------------------------------------------------------------------------------
//        Example 2:
//        Input: s = "a"
//        Output: 1
//        Explanation: The longest palindrome that can be built is "a", whose length is 1.import java.util.TreeSet;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String s = "aaabaaaa";

        System.out.println(longestPalindrome(s));
    }

    private static int longestPalindrome(String s) {
        boolean odd = false;
        int evenCounter = 0;

        TreeSet<Character> treeSet = new TreeSet<>();

        for (char c : s.toCharArray()) {
            if (treeSet.contains(c)) {
                evenCounter += 2;
                treeSet.remove(c);
            } else
                treeSet.add(c);
        }

        if (!treeSet.isEmpty())
            odd = true;

        if (odd)
            return evenCounter + 1;
        else
            return evenCounter;
    }
}
