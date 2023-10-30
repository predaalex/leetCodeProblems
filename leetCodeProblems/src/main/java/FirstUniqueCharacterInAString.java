package main.java;//        387. First Unique Character in a String
//
//        Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
//===========================================================
//        Example 1:
//        Input: s = "leetcode"
//        Output: 0
//-----------------------------------------------------------------------
//        Example 2:
//        Input: s = "loveleetcode"
//        Output: 2
//--------------------------------------------------------------------
//        Example 3:
//        Input: s = "aabb"
//        Output: -1
import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println(firstUniqChar(s));
    }

    private static int firstUniqChar(String s) {

        HashMap<Character, Integer> chars = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            chars.put(s.charAt(i), chars.getOrDefault(s.charAt(i), 0) + 1);
        }

        System.out.println(chars);

        for (int i = 0; i < s.length(); i++) {
            if (chars.get(s.charAt(i)) == 1) {
                return i;
            }
        }


        return -1;
    }
}
