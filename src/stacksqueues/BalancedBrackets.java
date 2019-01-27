package stacksqueues;

import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets
 */
public class BalancedBrackets {
    static String isBalanced(String s) {
        String YES = "YES", NO = "NO";
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.empty()){
                    return NO;
                }
                if(c == ')' && stack.peek() == '(' || c == '}' && stack.peek() == '{' || c == ']' && stack.peek() == '['){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        return stack.empty() ? YES : NO;
    }

    public static void main(String[] args) {
        String s = "{}}}}";
        System.out.println(isBalanced(s));
    }

}
