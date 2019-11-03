package qinz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakIISolution {
    /*public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        wordBreak(s, wordDict, str, res);
        return res;
    }

    private static void wordBreak(String s, List<String> wordDict, StringBuilder cur, List<String> res) {
        if (s.equals("")) {
            cur.deleteCharAt(cur.length() - 1);
            res.add(cur.toString());
            return;
        }
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            word.append(s.charAt(i));
            if (wordDict.contains(word.toString())) {
                String strSep = s.substring(i + 1);
                cur.append(word + " ");
                //word.append(" ");
                //cur.append(word);
                StringBuilder sep = new StringBuilder(cur.toString());
                wordBreak(strSep, wordDict, sep, res);
                int wordLength = word.length() + 1;
                int curLength = cur.length();
                cur.delete(curLength - wordLength, curLength);
            }
        }
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        *//*wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");*//*
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        System.out.println(wordBreak("pineapplepenapple", wordDict));
    }*/

    static Map<String, List<String>> map = new HashMap<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict);
    }

    public static List<String> wordBreakHelper(String s, List<String> wordDict) {
        if (s.equals("")) {
            return new ArrayList<>();
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> waysOfBreak = new ArrayList<>();
        StringBuilder possible = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            possible.append(s.charAt(i));
            if (wordDict.contains(possible.toString())) {
                String subStr = s.substring(i + 1);
                List<String> ways = wordBreakHelper(subStr, wordDict);
                if (subStr.equals("") && ways.size() == 0) {
                    waysOfBreak.add(possible.toString());
                } else if (!subStr.equals("") && ways.size() == 0) {
                    //return waysOfBreak;
                } else {
                    for (int j = 0; j < ways.size(); j++) {
                        waysOfBreak.add(possible.toString() + " " + ways.get(j));
                    }
                }
                map.put(subStr, ways);
            }
        }
        return waysOfBreak;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        /*wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");*/
        /*wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");*/
        wordDict.add("aaaa");
        wordDict.add("aaa");
        System.out.println(wordBreak("aaaaaaa", wordDict));
    }
}
