package qinz;

public class MinesweeperSolution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int column = click[1];
        if (board[row][column] == 'M') {
            board[row][column] = 'X';
            return board;
        }
        updateBoard(board, row, column);
        return board;
    }

    private void updateBoard(char[][] board, int r, int c) {
        int numOfMines;

        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 'B') {
            return;
        }

        numOfMines = checkAdjacent(board, r, c + 1) + checkAdjacent(board, r, c - 1) +
                checkAdjacent(board, r - 1, c) + checkAdjacent(board, r + 1, c) +
                checkAdjacent(board, r - 1, c - 1) + checkAdjacent(board, r - 1, c + 1) +
                checkAdjacent(board, r + 1, c - 1) + checkAdjacent(board, r + 1, c + 1);

        if (numOfMines == 0) {
            board[r][c] = 'B';
            updateBoard(board, r, c + 1);
            updateBoard(board, r, c - 1);
            updateBoard(board, r - 1, c);
            updateBoard(board, r + 1, c);
            updateBoard(board, r - 1, c - 1);
            updateBoard(board, r - 1, c + 1);
            updateBoard(board, r + 1, c - 1);
            updateBoard(board, r + 1, c + 1);
        } else {
            board[r][c] = (char) (numOfMines + 48);
        }
    }

    private int checkAdjacent(char[][] board, int r, int c) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 'E'
                || board[r][c] == 'B' || Character.isDigit(board[r][c])) {
            return 0;
        } else {
            return 1;
        }
    }
}
