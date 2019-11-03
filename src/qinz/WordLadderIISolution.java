package qinz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderIISolution {

    static int minSize = Integer.MAX_VALUE;

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        // initialize the queue
        Queue<String> queue = new LinkedList<>();

        // add the starting word to the queue
        queue.add(beginWord);

        List<String> path = new ArrayList<>();
        path.add(beginWord);

        findLadders(queue, path, result, wordList, endWord);
        for (int i = 0; i < result.size();) {
            if (result.get(i).size() != minSize) {
                result.remove(i);
            } else {
                i += 1;
            }
        }
        return result;
    }

    private static void findLadders(Queue<String> queue, List<String> path,
                             List<List<String>> result, List<String> listOfWords, String endWord) {
        if (!queue.isEmpty()) {
            // pop the current word
            String word = queue.poll();
            // mark as visited
            listOfWords.remove(word);
            List<String> neigh = neighOfWord(listOfWords, word);
            for (int i = 0; i < neigh.size(); i++) {
                String neighWord = neigh.get(i);
                if (neighWord.equals(endWord)) {
                    path.add(endWord);
                    result.add(path);
                    minSize = (path.size() < minSize) ? path.size() : minSize;
                } else {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighWord);
                    queue.add(neighWord);
                    findLadders(queue, newPath, result, listOfWords, endWord);
                }
            }
            listOfWords.add(word);
        }
    }

    // given a list of words and a particular current word, find all the neighbors of this current word from
    // the given list

    private static List<String> neighOfWord(List<String> wordList, String currWord) {
        List<String> neigh = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            String wordFromList = wordList.get(i);
            int numOfDiffLetter = 0;
            for (int j = 0; j < currWord.length(); j++) {
                numOfDiffLetter = (currWord.charAt(j) != wordFromList.charAt(j)) ? numOfDiffLetter + 1 : numOfDiffLetter;
            }
            if (numOfDiffLetter == 1) {
                neigh.add(wordFromList);
            }
        }
        return neigh;
    }

    public static void main(String[] args) {
        List<String> wordOfList = new ArrayList<>();
        wordOfList.add("hot");
        wordOfList.add("dot");
        wordOfList.add("dog");
        wordOfList.add("lot");
        wordOfList.add("log");
        wordOfList.add("cog");
        System.out.println(findLadders("hit", "cog", wordOfList));
    }
}
