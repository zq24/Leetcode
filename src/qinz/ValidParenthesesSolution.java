package qinz;

import java.util.Stack;

public class ValidParenthesesSolution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if(stack.empty()) {
                    return false;
                }
                char item = stack.pop();
                if(item != '(') {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if(stack.empty()) {
                    return false;
                }
                char item = stack.pop();
                if(item != '{') {
                    return false;
                }
            } else {
                if(stack.empty()) {
                    return false;
                }
                char item = stack.pop();
                if(item != '[') {
                    return false;
                }
            }
        }
        if(stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
