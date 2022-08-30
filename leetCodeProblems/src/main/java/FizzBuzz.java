//        Given an integer n, return a string array answer (1-indexed) where:
//
//        answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
//        answer[i] == "Fizz" if i is divisible by 3.
//        answer[i] == "Buzz" if i is divisible by 5.
//        answer[i] == i (as a string) if none of the above conditions are true.
//
//
//        Example 1:
//
//        Input: n = 3
//        Output: ["1","2","Fizz"]
//        Example 2:
//
//        Input: n = 5
//        Output: ["1","2","Fizz","4","Buzz"]
//        Example 3:
//
//        Input: n = 15
//        Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
import java.util.ArrayList;

public class FizzBuzz {

    public static void main(String[] args) {

        int n = 3;

        System.out.println(fizzBuzz(n));
    }

    private static ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");

        for(int i = 1; i <= n; i++) {
            if( i % 15 == 0) {
                arrayList.add("FizzBuzz");
            } else if ( i % 3 == 0) {
                arrayList.add("Fizz");
            } else if ( i % 5 == 0) {
                arrayList.add("Buzz");
            } else {
                arrayList.add(String.valueOf(i));
            }
        }

        arrayList.remove(0);

        return arrayList;
    }
}
