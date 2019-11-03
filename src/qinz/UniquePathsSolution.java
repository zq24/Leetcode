package qinz;

public class UniquePathsSolution {

    /*static int numOfPaths = 0;

    public static int uniquePaths(int m, int n) {
        uniquePathsHelper(n, m);
        return numOfPaths;
    }

    private static void uniquePathsHelper(int r, int c) {
        if(r == 1 && c == 1) {
            numOfPaths++;
            return;
        }
        if(r < 1 || c < 1) {
            return;
        }
        for(int i = 0; i < 2; i++) {
            if(i == 0) {
                int moveRight = c - 1;
                uniquePathsHelper(r, moveRight);
            }
            if(i == 1) {
                int moveDown = r - 1;
                uniquePathsHelper(moveDown, c);
            }
        }
    }*/

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for(int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}
