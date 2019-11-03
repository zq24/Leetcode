package qinz;

import java.util.ArrayList;
import java.util.List;

public class FlipGameSolution {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String possible = s.substring(0, i) + "--" +s.substring(i + 2);
                res.add(possible);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generatePossibleNextMoves("++++"));
    }
}
