package main.java;

import java.util.ArrayList;
import java.util.Arrays;

//151. Reverse Words in a String
//Medium
//
//Given an input string s, reverse the order of the words.
//
//A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
//
//Return a string of the words in reverse order concatenated by a single space.
//
//Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
//
//------------------------------------------------------------------
//Example 1:
//
//Input: s = "the sky is blue"
//Output: "blue is sky the"
//------------------------------------------------------------------
//Example 2:
//
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing spaces.
//------------------------------------------------------------------
//Example 3:
//
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
public class ReverseWordsInString {
    public static void main(String[] args) {
        String s1 = "the sky is blue";
        String s2 = "  hello world  ";
        String s3 = "a good   example";

        System.out.println(reverseWrods(s1));
        System.out.println(reverseWrods(s2));
        System.out.println(reverseWrods(s3));

    }

    private static String reverseWrods(String s) {
        int size = s.length();
        ArrayList<StringBuilder> words = new ArrayList<>();

        int i = 0;

        while(i < size) {
            StringBuilder stringBuilder = new StringBuilder();
            while(i < size && s.charAt(i) != ' ') {
                stringBuilder.append(s.charAt(i));
                i++;
            }
            if (!stringBuilder.isEmpty())
                words.add(stringBuilder);

            if (i < size && s.charAt(i) == ' ')
                i++;
        }

        StringBuilder result = new StringBuilder();

        for(i = words.size() - 1; i >= 0; i--){
            result.append(words.get(i) + " ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
