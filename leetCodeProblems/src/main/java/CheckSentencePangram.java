package main.java;//        1832. Check if the Sentence Is Pangram
//
//        A pangram is a sentence where every letter of the English alphabet appears at least once.
//
//        Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
//=================================================================================================================
//        Example 1:
//        Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
//        Output: true
//        Explanation: sentence contains at least one of every letter of the English alphabet.
//-----------------------------------------------------------------------------------------------------------------
//        Example 2:
//        Input: sentence = "leetcode"
//        Output: false
import java.util.HashSet;
import java.util.Set;

public class CheckSentencePangram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";

        System.out.println(checkIfPangram(sentence));
    }

    private static boolean checkIfPangram(String sentence) {
        Set<Character> characters = new HashSet<>();

        for(int i = 0; i < sentence.length(); i++)
            characters.add(sentence.charAt(i));

        return characters.size() == 26;
    }
}
