package qinz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAStringSolution {
    public List<Integer> findAnagrams(String s, String p) {
        int lengthOfP = p.length();
        List<Integer> res = new ArrayList<>();
        char[] anagramOfP = reArrange(p);
        for (int i = 0; i <= s.length() - lengthOfP; i++) {
            char[] temp = reArrange(s.substring(i, i + lengthOfP));
            if (Arrays.equals(anagramOfP, temp)) {
                res.add(i);
            }
        }
        return res;
    }

    private char[] reArrange(String anagrams) {
        char[] temp = anagrams.toCharArray();
        Arrays.sort(temp);
        return temp;
    }
}
