package qinz;

public class SurroundedRegionsSolution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                solve(board, 0, i, true);
            }
            if (board[board.length - 1][i] == 'O') {
                solve(board, board.length - 1, i, true);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                solve(board, i, 0, true);
            }
            if (board[i][board[0].length - 1] == 'O') {
                solve(board, i, board[0].length - 1, true);
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    solve(board, i, j, false);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void solve(char[][] board, int r, int c, boolean surrounded) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length ||
                board[r][c] == '1' || board[r][c] == 'X') {
            return;
        }

        // mark as visited
        if (surrounded) {
            board[r][c] = '1';
        } else {
            board[r][c] = 'X';
        }

        solve(board, r + 1, c, surrounded);
        solve(board, r - 1, c, surrounded);
        solve(board, r, c + 1, surrounded);
        solve(board, r, c - 1, surrounded);
    }
}
