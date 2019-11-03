package qinz;

public class BattleshipsInABoardSolution {
    public static int countBattleships(char[][] board) {
        int numOfBattleShips = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X') {
                    numOfBattleShips += 1;
                    countBattleships(board, i, j);
                }
            }
        }
        return numOfBattleShips;
    }

    private static void countBattleships(char[][] board, int r, int c) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '.' || board[r][c] == '0') {
            return;
        }

        board[r][c] = '0';
        countBattleships(board, r, c + 1);
        countBattleships(board, r, c - 1);
        countBattleships(board, r + 1, c);
        countBattleships(board, r - 1, c);
    }

    public static void main(String[] args) {
        char[][] test = new char[][] {{'X', '.', '.', 'X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(countBattleships(test));
    }
}
