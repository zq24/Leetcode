package qinz;

import java.util.*;

public class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsCollection = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String key = String.valueOf(str);
            if (!anagramsCollection.containsKey(key)) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                anagramsCollection.put(key, newList);
            } else {
                List<String> cur = anagramsCollection.get(key);
                cur.add(strs[i]);
            }
        }
        return new ArrayList<>(anagramsCollection.values());
    }

}
