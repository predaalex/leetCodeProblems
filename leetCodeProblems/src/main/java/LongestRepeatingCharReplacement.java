package main.java;

public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {
        String s = "ABBB";
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }

    private static int characterReplacement(String s, int k) {
        int longest = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            int aux = k;
            int counter = 0;
            while(i + counter < s.length()){
                if(s.charAt(i + counter) != c)
                    aux--;
                if(aux < 0)
                    break;
                counter++;
            }

            if (counter == s.length())
                return counter;

            if(longest < counter)
                longest = counter;
        }

        return longest;
    }
}
