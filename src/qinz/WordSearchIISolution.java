package qinz;

import java.util.ArrayList;
import java.util.List;

public class WordSearchIISolution {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[0].length; k++) {
                    if (res.contains(word)) {
                        break;
                    }
                    boolean isExisted = findWords(board, j, k, word, 0);
                    if (isExisted) {
                        res.add(word);
                    }
                }
            }
        }
        return res;
    }

    private static boolean findWords(char[][] board, int r, int c, String word, int index) {
        if (index >= word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length ||
                board[r][c] == '0' || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '0';
        boolean left = findWords(board, r, c - 1, word, index + 1);
        boolean right = findWords(board, r, c + 1, word, index + 1);
        boolean up = findWords(board, r - 1, c, word, index + 1);
        boolean down = findWords(board, r + 1, c, word, index + 1);
        board[r][c] = temp;
        return left || right || up || down;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'a', 'a'}};
        String[] words = new String[] {"a"};
        System.out.println(findWords(board, words));
    }
}
