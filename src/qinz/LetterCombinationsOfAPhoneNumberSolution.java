package qinz;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumberSolution {
    //Create a global variable to store the mapping relationship
    static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.equals(""))
            return res;
        letterCombinations(res, digits, 0, "");
        return res;
    }

    private static void letterCombinations(List<String> res, String digits, int position, String combination) {
        if(position >= digits.length()) {
            res.add(combination);
            return;
        }
        char getDigit = digits.charAt(position);
        String getMap = map[getDigit - '2'];
        for(int i = 0; i < getMap.length(); i++) {
            String newCombination = combination.concat(getMap.substring(i, i + 1));
            int newPosition = position + 1;
            letterCombinations(res, digits, newPosition, newCombination);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
