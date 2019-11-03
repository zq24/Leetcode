package qinz;

public class WordSearchSolution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(exist(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int index, int i, int j) {

        boolean exist;

        if (index == word.length() - 1)
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(index) || board[i][j] == '0') {
            return false;
        }

        //Mark as visited
        char temp = board[i][j];
        board[i][j] = '0';
        int nextIndex = index + 1;

        //Any path would be fine; hence using OR
        exist = exist(board, word, nextIndex, i, j + 1) || exist(board, word, nextIndex, i, j - 1)
                || exist(board, word, nextIndex, i + 1, j) || exist(board, word, nextIndex, i - 1, j);

        board[i][j] = temp;

        return exist;
    }

}
