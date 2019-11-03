package qinz;

public class MinimumAddToMakeParenthesesValidSolution {
    public static int minAddToMakeValid(String S) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                left += 1;
            } else if (S.charAt(i) == ')' && left != 0) {
                left -= 1;
            } else if (S.charAt(i) == ')' && left == 0) {
                right += 1;
            }
        }
        return right + left;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))(("));
    }
}
