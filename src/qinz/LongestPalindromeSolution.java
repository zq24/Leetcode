package qinz;

public class LongestPalindromeSolution {
    public int longestPalindrome(String s) {
        int[] frequencyLower = new int[26];
        int[] frequencyUpper = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <= 25) {
                frequencyLower[s.charAt(i) - 'a']++;
            } else {
                frequencyUpper[s.charAt(i) - 'A']++;
            }

        }

        int maxOdd = 0;
        int length = 0;
        for (int i = 0; i < frequencyLower.length; i++) {
            if (frequencyLower[i] % 2 == 0) {
                length += frequencyLower[i];
            } else {
                maxOdd = Math.max(maxOdd, frequencyLower[i]);
            }
            if (frequencyUpper[i] % 2 == 0) {
                length += frequencyUpper[i];
            } else {
                maxOdd = Math.max(maxOdd, frequencyUpper[i]);
            }
        }
        length += maxOdd;
        return length;
    }
}
