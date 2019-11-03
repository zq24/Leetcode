package qinz;

public class MinimumFallingPathSumSolution {

    /*int min = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] A) {
        for (int i = 0; i < A[0].length; i++) {
            minFallingPathSumHelper(A, 0, i, 0);
        }
        return min;
    }

    private void minFallingPathSumHelper(int[][] A, int height, int index, int sum) {
        if (height >= A.length) {
            min = Math.min(min, sum);
            return;
        }

        if (index < 0 || index >= A[0].length) {
            return;
        }

        int sumUpdate = sum + A[height][index];
        minFallingPathSumHelper(A, height + 1, index - 1, sumUpdate);
        minFallingPathSumHelper(A, height + 1, index, sumUpdate);
        minFallingPathSumHelper(A, height + 1, index + 1, sumUpdate);
    }*/

    int[][] map;
    boolean[][] visited;

    public int minFallingPathSum(int[][] A) {
        map = new int[A.length][A[0].length];
        visited = new boolean[A.length][A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            minFallingPathSum(A, 0, i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            min = Math.min(min, map[0][i]);
        }
        return min;
    }

    private int minFallingPathSum(int[][] A, int height, int index) {
        if (height >= A.length) {
            return 0;
        }

        if (index < 0 || index >= A[0].length) {
            return Integer.MAX_VALUE;
        }

        if (visited[height][index]) {
            return map[height][index];
        }

        int fallingPath = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int remainSum;
            if (i == 0) {
                remainSum = minFallingPathSum(A, height + 1, index - 1);
            } else if (i == 1) {
                remainSum = minFallingPathSum(A, height + 1, index);
            } else {
                remainSum = minFallingPathSum(A, height + 1, index + 1);
            }
            fallingPath = Math.min(fallingPath, remainSum);
        }
        map[height][index] = A[height][index] + fallingPath;
        visited[height][index] = true;
        return A[height][index] + fallingPath;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    }
}
