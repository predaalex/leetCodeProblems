package main.java;

import java.util.HashMap;
//290. Word Pattern
//Easy
//Given a pattern and a string s, find if s follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
//
//
//
//Example 1:
//
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
//Example 2:
//
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
//Example 3:
//
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println(wordPattern(pattern, s));
    }

    private static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();

        String[] words = s.split(" ");

        if(words.length != pattern.length())
            return false;

        for(int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);

            if(map.containsKey(c) && !map.get(c).equals(words[i])) {
                return false;
            } else if (!map.containsKey(c) && map.containsValue(words[i])) {
                return false;
            } else {
                map.put(c, words[i]);
            }
        }
        return true;
    }
}
