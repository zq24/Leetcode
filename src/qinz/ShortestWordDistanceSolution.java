package qinz;

public class ShortestWordDistanceSolution {
    public static int shortestDistance(String[] words, String word1, String word2) {
        int distance = 0;
        int wordOneIndex = 0;
        int wordTwoIndex = 0;
        boolean wordOneFlag = false;
        boolean wordTwoFlag = false;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                wordOneIndex = i;
                wordOneFlag = true;
                if(wordOneFlag && wordTwoFlag) {
                    if(distance == 0) {
                        distance = Math.abs(wordOneIndex - wordTwoIndex);
                    }
                    distance = Math.min(distance, Math.abs(wordOneIndex - wordTwoIndex));
                }
            }
            if(words[i].equals(word2)) {
                wordTwoIndex = i;
                wordTwoFlag = true;
                if(wordOneFlag && wordTwoFlag) {
                    if(distance == 0) {
                        distance = Math.abs(wordOneIndex - wordTwoIndex);
                    }
                    distance = Math.min(distance, Math.abs(wordOneIndex - wordTwoIndex));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String[] test = new String[]{"a", "a", "b", "b"};
        System.out.println(shortestDistance(test, "a", "b"));
    }
}
