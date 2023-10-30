package main.java;

import java.util.HashMap;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        String[] words = {"bb", "bb"};

        System.out.println(longestPalindrome(words));
    }

    private static int longestPalindrome(String[] words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int len = 0;

        for(String word : words){

            String wordPair = String.valueOf(word.charAt(1)) +
                    word.charAt(0);
            if(hashMap.containsKey(wordPair) && hashMap.get(wordPair) > 0){
                len += 4;
                hashMap.put(wordPair, hashMap.get(wordPair) - 1);
            } else {
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
            }
        }

        for(String word : hashMap.keySet()){
            if(word.charAt(0) == word.charAt(1) && hashMap.get(word) % 2 == 1){
                len += 2;
                break;
            }
        }

        return len;
    }
}
