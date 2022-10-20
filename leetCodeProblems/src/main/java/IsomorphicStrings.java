//        205. Isomorphic Strings
//        Given two strings s and t, determine if they are isomorphic.
//
//        Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//===========================================================================
//        Example 1:
//        Input: s = "egg", t = "add"
//        Output: true
//---------------------------------------------------------------------------
//        Example 2:
//        Input: s = "foo", t = "bar"
//        Output: false
//----------------------------------------------------------------------------
//        Example 3:
//        Input: s = "paper", t = "title"
//        Output: true
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        System.out.println(isIsomorphic(s, t));
    }

    private static boolean isIsomorphic(String s, String t) {

        System.out.println(transformString(s));
        System.out.println(transformString(t));

        return transformString(s).equals(transformString(t));
    }

    private static String transformString(String s) {

        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (!indexMapping.containsKey(c)) {
                indexMapping.put(c, i);
            }

            builder.append(indexMapping.get(c));
            builder.append(" ");
        }

        return builder.toString();
    }
}
