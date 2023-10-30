package main.java;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ab";
        String t = "b";

        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        // Transform T into List of chars to have better complexity finding
        // Find first char from t that is in s and find the min size of group
        if(s.compareTo(t) == 0)
            return s;
        String returnable = "";
        int len = Integer.MAX_VALUE;
        int firstIndex;
        int lastIndex;
        List<Character> tList = new ArrayList<>();

        for(int i = 0; i < t.length();i++)
            tList.add(t.charAt(i));

        for(int i = 0; i < s.length() - tList.size() + 1; i++){
            if(tList.contains(s.charAt(i))){
                List<Character> tListAux = new ArrayList<>(tList);
                int lenAux = Integer.MAX_VALUE;
                firstIndex = i;
                lastIndex = s.length();
                tListAux.remove(Character.valueOf(s.charAt(i)));

                if (tListAux.isEmpty()){
                    lenAux = 1;
                    lastIndex = i + 1;
                }

                for(int j = i + 1; j < s.length() - tListAux.size(); j++){
                    if(tListAux.contains(s.charAt(j))){
                        tListAux.remove(Character.valueOf(s.charAt(j)));
                        lastIndex = j + 1;
                    }
                    if (tListAux.isEmpty()){
                        lenAux = lastIndex - firstIndex;
                        break;
                    }
                }
                if(lenAux < len){
                    len = lenAux;
                    returnable = s.substring(firstIndex, lastIndex);
                }

            }
        }

        return returnable;
    }
}
