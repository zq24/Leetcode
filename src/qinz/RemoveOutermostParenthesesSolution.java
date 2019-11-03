package qinz;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveOutermostParenthesesSolution {
    public static String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            if(!stack.empty()) {
                if(stack.size() == 1 && S.charAt(i) == ')') {
                } else {
                    res.append(S.charAt(i));
                }
            }
            if(S.charAt(i) == '(') {
                stack.push(S.charAt(i));
            } else {
                stack.pop();
            }
        }
        return res.toString();

        /*String output = "";
        char item;
        int size = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(' && size == 0) {
                stack.push(S.charAt(i));
                size++;
            }else if (S.charAt(i) == '(' && size >= 1) {
                output = output + S.charAt(i);
                stack.push(S.charAt(i));
                size++;
            } else if (S.charAt(i) == ')' && size >= 2) {
                output = output + S.charAt(i);
                item = stack.pop();
                size--;
            } else if (S.charAt(i) == ')' && size == 1) {
                item = stack.pop();
                size = 0;
            }
        }
        return output;*/
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }
}
