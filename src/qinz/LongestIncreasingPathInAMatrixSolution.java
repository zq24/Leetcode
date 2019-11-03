package qinz;

public class LongestIncreasingPathInAMatrixSolution {

    /*int maxLength = Integer.MIN_VALUE;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longestIncreasingPathHelper(matrix, i, j, Integer.MIN_VALUE, 0);
            }
        }
        return maxLength;
    }

    private void longestIncreasingPathHelper(int[][] matrix, int r, int c, int prev, int length) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length
                || matrix[r][c] == Integer.MIN_VALUE || matrix[r][c] <= prev) {
            maxLength = Math.max(maxLength, length);
            return;
        }

        int temp = matrix[r][c];
        int newLength = length + 1;
        longestIncreasingPathHelper(matrix, r, c - 1, matrix[r][c], newLength);
        longestIncreasingPathHelper(matrix, r, c + 1, matrix[r][c], newLength);
        longestIncreasingPathHelper(matrix, r - 1, c, matrix[r][c], newLength);
        longestIncreasingPathHelper(matrix, r + 1, c, matrix[r][c], newLength);
        matrix[r][c] = temp;
    }*/

    int maxPath = Integer.MIN_VALUE;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longestIncreasingPath(matrix, i, j, Integer.MIN_VALUE, dp);
            }
        }
        return maxPath;
    }

    private int longestIncreasingPath(int[][] matrix, int r, int c, int pre, int[][] save) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length ||
                matrix[r][c] == Integer.MIN_VALUE || matrix[r][c] <= pre) {
            return 0;
        }

        if (save[r][c] != 0) {
            return save[r][c];
        }

        int left = 1 + longestIncreasingPath(matrix, r, c - 1, matrix[r][c], save);
        int right = 1 + longestIncreasingPath(matrix, r, c + 1, matrix[r][c], save);
        int up = 1 + longestIncreasingPath(matrix, r - 1, c, matrix[r][c], save);
        int down = 1 + longestIncreasingPath(matrix, r + 1, c, matrix[r][c], save);
        int max = Math.max(left, right);
        max = Math.max(max, up);
        max = Math.max(max, down);
        save[r][c] = max;
        maxPath = Math.max(maxPath, max);
        return max;
    }
}
