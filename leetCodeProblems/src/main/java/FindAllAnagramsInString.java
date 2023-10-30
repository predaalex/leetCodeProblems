package main.java;//        438. Find All Anagrams in a String
//
//        Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//===================================================================================
//        Example 1:
//
//        Input: s = "cbaebabacd", p = "abc"
//        Output: [0,6]
//        Explanation:
//        The substring with start index = 0 is "cba", which is an anagram of "abc".
//        The substring with start index = 6 is "bac", which is an anagram of "abc".
//-----------------------------------------------------------------------------------
//        Example 2:
//        Input: s = "abab", p = "ab"
//        Output: [0,1,2]
//        Explanation:
//        The substring with start index = 0 is "ab", which is an anagram of "ab".
//        The substring with start index = 1 is "ba", which is an anagram of "ab".
//        The substring with start index = 2 is "ab", which is an anagram of "ab".
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "aaaaaaaa";
        String p = "aaaaaaaaaaa";

        System.out.println(findAnagrams(s, p));
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> pos = new ArrayList<>();

        if(p.length() > s.length())
            return pos;

        HashMap<Character, Integer> pHash = new HashMap<>();

        for(int i = 0;i < p.length(); i++) {
            if(pHash.containsKey(p.charAt(i)))
                pHash.replace(p.charAt(i), pHash.get(p.charAt(i)) + 1);
            else
                pHash.put(p.charAt(i), 1);
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i = 0;i < p.length(); i++) {
            if(hashMap.containsKey(s.charAt(i)))
                hashMap.replace(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            else
                hashMap.put(s.charAt(i), 1);
        }
        if(hashMap.equals(pHash))
            pos.add(0);

        for(int i = p.length(); i < s.length(); i++){
            Character c2 = s.charAt(i);

            //bagam urmatorul caracter
            if(hashMap.containsKey(c2))
                hashMap.replace(c2, hashMap.get(c2) + 1);
            else
                hashMap.put(c2, 1);

            //scoatem primul caracter
            Character c1 = s.charAt(i - p.length());
            hashMap.replace(c1, hashMap.get(c1) - 1);
            if (hashMap.get(c1) == 0)
                hashMap.remove(c1);

            if(hashMap.equals(pHash))
                pos.add(i - p.length() + 1);
        }




        return pos;
    }
}
