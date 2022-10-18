//        38. Count and Say
//
//        The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
//
//        countAndSay(1) = "1"
//        countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
//        To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
//
//        For example, the saying and conversion for digit string "3322251":
//
//
//        Given a positive integer n, return the nth term of the count-and-say sequence.
//========================================================================================
//        Example 1:
//        Input: n = 1
//        Output: "1"
//        Explanation: This is the base case.
//----------------------------------------------------------------------------------------
//        Example 2:
//        Input: n = 4
//        Output: "1211"
//        Explanation:
//        countAndSay(1) = "1"
//        countAndSay(2) = say "1" = one 1 = "11"
//        countAndSay(3) = say "11" = two 1's = "21"
//        countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
public class CountAndSay {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(countAndSay(n));
    }

    private static String countAndSay(int n) {
        StringBuilder returnable = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            StringBuilder aux = new StringBuilder();
            if(i == 1) {
                aux.append(i);
                returnable = aux;
                System.out.println(returnable);
                continue;
            }
            int counter = 0;
            char counterChar = returnable.charAt(0);
            for(char c : returnable.toString().toCharArray()){
                if(counterChar != c) {
                    aux.append(counter);
                    aux.append(counterChar);
                    counter = 1;
                    counterChar = c;
                } else {
                    counter ++;
                }
            }
            aux.append(counter);
            aux.append(counterChar);

            returnable = aux;
        }

        return returnable.toString();
    }
}
