package qinz;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesSolution {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, n, n, "");
        return res;
    }

    private static void generateParenthesis(List<String> res, int left, int right, String parentheses) {
        if(left == 0 && right == 0) {
            res.add(parentheses);
            return;
        }

        if(left > right || left < 0 || right < 0) {
            return;
        }

        for(int i = 0; i < 2; i++) {
            if (i == 0) {
                //add "("
                String newString = parentheses + "(";
                int newLeft = left - 1;
                generateParenthesis(res, newLeft, right, newString);
            }
            if (i == 1) {
                //add ")"
                String newString = parentheses + ")";
                int newRight = right - 1;
                generateParenthesis(res, left, newRight, newString);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }
}
