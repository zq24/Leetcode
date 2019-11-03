package qinz;

public class GameOfLifeSolution {
    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int numOfLiveNeighbors = numOfLive(board, i, j);
                if(board[i][j] == 1) {
                    if (numOfLiveNeighbors < 2 || numOfLiveNeighbors > 3) {
                        temp[i][j] = 0;
                    } else {
                        temp[i][j] = 1;
                    }
                } else {
                    if (numOfLiveNeighbors == 3) {
                        temp[i][j] = 1;
                    } else {
                        temp[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }

    private int numOfLive(int[][] board, int r, int c) {
        return checkLive(board, r, c - 1) + checkLive(board, r, c + 1) +
                checkLive(board, r - 1, c) + checkLive(board, r + 1, c) +
                checkLive(board, r - 1, c - 1) + checkLive(board, r - 1, c + 1) +
                checkLive(board, r + 1, c - 1) + checkLive(board, r + 1, c + 1);
    }

    private int checkLive(int[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
