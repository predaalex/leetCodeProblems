package main.java;

//        392. Is Subsequence
//
//        Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//
//        A subsequence of a string is a new string that is formed from the original string by deleting some
//        (can be none) of the characters without disturbing the relative positions of the remaining characters.
//        (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {

        if (s.length() == 0)
            return true;

        int letters = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(letters) == t.charAt(i))
                letters++;
            if (letters == s.length())
                return true;
        }

        return false;
    }

}
