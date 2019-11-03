package qinz;

import java.util.*;

public class TopKFrequentWordsSolution {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return alphabeticalOrder(o1.getKey(), o2.getKey());
                }
            }

            private int alphabeticalOrder(String s1, String s2) {
                int length = (s1.length() <= s2.length()) ? s1.length() : s2.length();
                for (int i = 0; i < length; i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return s1.charAt(i) - s2.charAt(i);
                    }
                }
                return s1.length() - s2.length();
            }
        });
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
        queue.addAll(map.entrySet());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.poll().getKey());
        }
        return res;
    }

    /*private int alphabeticalOrder(String s1, String s2) {
        int length = (s1.length() <= s2.length()) ? s1.length() : s2.length();
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        return s1.length() - s2.length();
    }*/

    public static void main(String[] args) {
        String[] test = new String[] {"a", "aa", "aaa"};
        System.out.println(topKFrequent(test, 1));
    }
}
