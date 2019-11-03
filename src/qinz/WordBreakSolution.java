package qinz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakSolution {
    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict);
    }

    public boolean wordBreakHelper(String s, List<String> wordDict) {
        if (s.equals("")) {
            return true;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        boolean breakWord = false;
        StringBuilder possible = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            possible.append(s.charAt(i));
            if (wordDict.contains(possible.toString())) {
                String subStr = s.substring(i + 1);
                boolean canBreak = wordBreakHelper(subStr, wordDict);
                breakWord = breakWord || canBreak;
                map.put(subStr, canBreak);
            }
        }
        return breakWord;
    }
}
