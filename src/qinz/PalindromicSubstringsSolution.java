package qinz;

import java.util.*;

public class PalindromicSubstringsSolution {

    /*static Map<String, Boolean> isPalindromicSubstr = new HashMap<>();

    static Map<String, List<Integer>> palindromicSubstrPosition = new HashMap<>();

    public static int countSubstrings(String s) {
        countSubstringsHelper(s, 0);
        Collection<List<Integer>> list = palindromicSubstrPosition.values();
        Iterator<List<Integer>> itr = list.iterator();
        int numOfPalindromic = 0;
        while (itr.hasNext()) {
            numOfPalindromic += itr.next().size();
        }
        return numOfPalindromic;
    }

    public static void countSubstringsHelper(String s, int start) {
        String newStr = s.substring(start);
        if (newStr.equals("")) {
            return;
        }

        if (isPalindromicSubstr.containsKey(newStr)) {
            if (!isPalindromicSubstr.get(newStr)) {
                return;
            } else {
                if (!palindromicSubstrPosition.get(newStr).contains(start)) {
                    palindromicSubstrPosition.get(newStr).add(start);
                }
            }
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String subStr = s.substring(start, i);
            if (palindromicSubstrPosition.containsKey(subStr)) {
                if (!palindromicSubstrPosition.get(subStr).contains(start)) {
                    palindromicSubstrPosition.get(subStr).add(start);
                }
            } else if (isPalindromic(subStr)) {
                //map.put(subStr, 1);
                List<Integer> position = new ArrayList<>();
                position.add(start);
                palindromicSubstrPosition.put(subStr, position);
                isPalindromicSubstr.put(subStr, true);
            } else {
                isPalindromicSubstr.put(subStr, false);
            }
            countSubstringsHelper(s, i);
        }
    }

    public static boolean isPalindromic(String string) {
        for (int i = 0, j = string.length() - 1; i < string.length() && j >= 0; i++, j--) {
            if (string.charAt(i) != string.charAt(j))
                return false;
        }
        return true;
    }*/

    public static int countSubstrings(String s) {
        int numOfSubStr = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            numOfSubStr += 1;
        }
        for (int i = 0; i < dp.length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                numOfSubStr += 1;
            }
        }

        for (int i = 3; i <= s.length(); i++) {
            for (int j = 0; j + i - 1 < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j + i - 1)) {
                    if (dp[j + 1][j + i - 2]) {
                        dp[j][j + i - 1] = true;
                        numOfSubStr += 1;
                    }
                }
            }
        }
        return numOfSubStr;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaaaa"));
    }
}
