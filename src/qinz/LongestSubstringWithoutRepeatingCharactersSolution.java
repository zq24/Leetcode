package qinz;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharactersSolution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int longestSubstring = 1;
        int i, j;
        for(i = 0, j = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                longestSubstring = Math.max(longestSubstring, i - j);
                j = Math.max(j, map.get(s.charAt(i)) + 1);
                map.put(s.charAt(i), i);
            }
        }
        longestSubstring = Math.max(longestSubstring, i - j);
        return longestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
