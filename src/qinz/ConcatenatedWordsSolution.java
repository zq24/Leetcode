package qinz;

import java.util.*;

public class ConcatenatedWordsSolution {

    // "word break problem"
    // try to break each word to see if it can be formed by using other word
    // NOTE: a word can only be formed using words that shorter than it.
    // The Array.sort method can be passed a Comparator in it.

    // using DFS + memoization
    // create a map to record whether the current word could be broke or not
    static Map<String, Boolean> map = new HashMap<>();

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        List<String> results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            List<String> newWwordDict = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                newWwordDict.add(words[j]);
            }
            if (wordBreak(words[i], newWwordDict)) {
                results.add(words[i]);
            }
        }
        return results;
    }

    private static boolean wordBreak(String word, List<String> wordDict) {

        if (word.equals(""))
            return true;

        if (map.containsKey(word))
            return map.get(word);

        for (int i = 0; i < word.length(); i++) {
            String split = word.substring(0, i + 1);
            if (wordDict.contains(split)) {
                String remain = word.substring(i + 1);
                boolean canRemainBreak = wordBreak(remain, wordDict);
                map.put(remain, canRemainBreak);
                if (canRemainBreak) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] test = new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        String[] testTwo = new String[] {""};
        System.out.println(findAllConcatenatedWordsInADict(testTwo));
        System.out.println("Test Two:" + "" + "" + "?");
    }
}
