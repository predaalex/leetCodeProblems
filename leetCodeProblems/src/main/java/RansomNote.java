package main.java;

import java.util.HashMap;
//383. Ransom Note
//Easy
//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
//
//Example 1:
//
//Input: ransomNote = "a", magazine = "b"
//Output: false
//Example 2:
//
//Input: ransomNote = "aa", magazine = "ab"
//Output: false
//Example 3:
//
//Input: ransomNote = "aa", magazine = "aab"
//Output: true
public class RansomNote {
    static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        for(char c : ransomNote.toCharArray())
            hashMap1.put(c, hashMap1.getOrDefault(c, 0) + 1);
        for(char c : magazine.toCharArray())
            hashMap2.put(c, hashMap2.getOrDefault(c, 0) + 1);

        for(Character c : hashMap1.keySet()){
            if(!hashMap2.containsKey(c) || hashMap2.get(c) < hashMap1.get(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }
}
