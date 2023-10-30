package main.java;//        1408. String Matching in an Array
//
//        Given an array of string words. Return all strings in words which is substring of another word in any order.
//
//        String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
//
//----------------------------------------------------------------
//        Example 1:
//        Input: words = ["mass","as","hero","superhero"]
//        Output: ["as","hero"]
//        Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
//        ["hero","as"] is also a valid answer.
//
//----------------------------------------------------------------
//        Example 2:
//        Input: words = ["leetcode","et","code"]
//        Output: ["et","code"]
//        Explanation: "et", "code" are substring of "leetcode".
//
//----------------------------------------------------------------
//        Example 3:
//        Input: words = ["blue","green","bu"]
//        Output: []

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInArray {
    public static void main(String[] args) {

        String[] words = {"leetcoder","leetcode","od","hamlet","am"};

        stringMatching(words);
    }

    private static List<String> stringMatching(String[] words) {

        List<String> list = new ArrayList<>();

        for(String word1 : words) {
            for(String word2: words) {
                if(word2.equals(word1))
                    continue;
                else
                if(word2.contains(word1)) {
                    list.add(word1);
                    break;
                }
            }
        }

        return list;
    }
}
