package qinz;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequencySolution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        queue.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> temp = queue.poll();
            char character = temp.getKey();
            int frequency = temp.getValue();
            for(int i = 0; i < frequency; i++) {
                res.append(character);
            }
        }

        return res.toString();
    }
}
