package main.java;

//        Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//        Each letter in magazine can only be used once in ransomNote.
//
//        Example 1:
//
//        Input: ransomNote = "a", magazine = "b"
//        Output: false
//        Example 2:
//
//        Input: ransomNote = "aa", magazine = "ab"
//        Output: false
//        Example 3:
//
//        Input: ransomNote = "aa", magazine = "aab"
//        Output: true
public class RansomNote {
    static boolean canConstruct(String ransomNote, String magazine) {
        for(int i = 0; i < magazine.length(); i++) {
            ransomNote = ransomNote.replaceFirst( String.valueOf(magazine.charAt(i)), "");
        }

        return ransomNote.length() == 0;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }
}
