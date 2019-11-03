package qinz;

public class SingleRowKeyboardSolution {
    public int calculateTime(String keyboard, String word) {
        int[] arr = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            arr[keyboard.charAt(i) - 'a'] = i;
        }
        int curr = 0;
        int time = 0;
        for (int i = 0; i < word.length(); i++) {
            int currentChar = arr[word.charAt(i) - 'a'];
            int moves = Math.abs(currentChar - curr);
            time += moves;
            curr = currentChar;
        }
        return time;
    }
}
