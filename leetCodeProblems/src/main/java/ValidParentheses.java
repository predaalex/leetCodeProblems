package main.java;

import java.util.Stack;

//20. Valid Parentheses
//Easy
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//
//Example 1:
//
//Input: s = "()"
//Output: true
//Example 2:
//
//Input: s = "()[]{}"
//Output: true
//Example 3:
//
//Input: s = "(]"
//Output: false

public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "()";

        System.out.println(isValid(s1));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c =='{')
                stack.add(c);
            else if(!stack.isEmpty()) {
                char lastC = stack.pop();
                if (lastC == '(' && c != ')') {
                    return false;
                } else if (lastC == '[' && c != ']') {
                    return false;
                } else if (lastC == '{' && c != '}') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
