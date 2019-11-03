package qinz;

import java.util.*;

public class FindAndReplacePatternSolution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int[] compare = convertPattern(pattern);
        for(int i = 0; i < words.length; i++) {
            if(Arrays.equals(convertPattern(words[i]), compare))
                res.add(words[i]);
        }
        return res;
    }

    private int[] convertPattern(String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        int[] res = new int[pattern.length()];
        for (int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), map.size());
            }
        }
        for(int i = 0; i < pattern.length(); i++) {
            res[i] = map.get(pattern.charAt(i));
        }
        return res;
    }
}
