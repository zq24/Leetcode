package qinz;

import java.util.*;

public class WordLadderSolution {

    static Map<String, Integer> map = new HashMap<>();

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //initialize the queue
        Queue<String> neigh = new LinkedList<>();
        map.put(beginWord, 1);
        neigh.offer(beginWord);
        ladderLength(wordList, neigh);
        if (!map.containsKey(endWord)) {
            return 0;
        } else {
            return map.get(endWord);
        }
    }

    private static void ladderLength(List<String> wordList, Queue<String> neigh) {
        while (!neigh.isEmpty()) {
            String current = neigh.poll();
            //find all the neighbors
            for (int i = 0; i < wordList.size(); i++) {
                if (checkNeighbor(current, wordList.get(i))) {
                    if (!map.containsKey(wordList.get(i))) {
                        neigh.offer(wordList.get(i));
                        int currentLength = map.get(current);
                        map.put(wordList.get(i), currentLength + 1);
                        //wordList.remove(i);
                    }
                }
            }
        }
    }

    private static boolean checkNeighbor(String current, String neigh) {
        int numOfDiffer = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != neigh.charAt(i)) {
                numOfDiffer += 1;
            }
            if (numOfDiffer > 1)
                return false;
        }
        return numOfDiffer != 0;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("hot");
        test.add("dot");
        test.add("dog");
        test.add("lot");
        test.add("log");
        test.add("cog");
        System.out.println(ladderLength("hit", "cog", test));
    }
}
