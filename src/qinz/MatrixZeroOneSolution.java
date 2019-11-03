package qinz;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixZeroOneSolution {

    public static int[][] updateMatrix(int[][] matrix) {
        //initialize the queue
        Queue<int[]> neigh = new LinkedList<>();

        //find all the starting points
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    neigh.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = Integer.MIN_VALUE;
                }
            }
        }

        //start updating the rest of the node
        updateMatrix(neigh, matrix);
        return matrix;
    }

    private static void updateMatrix(Queue<int[]> neigh, int[][] matrix) {

        while (!neigh.isEmpty()) {
            //pop the current node
            int[] current = neigh.poll();
            int r = current[0];
            int c = current[1];

            //Loop and check all the neighbors of the current node
            if (checkValid(matrix, r, c - 1)) {
                if (matrix[r][c - 1] == Integer.MIN_VALUE) {
                    neigh.offer(new int[] {r, c - 1});
                    matrix[r][c - 1] = matrix[r][c] + 1;
                }
            }
            if (checkValid(matrix, r, c + 1)) {
                if (matrix[r][c + 1] == Integer.MIN_VALUE) {
                    neigh.offer(new int[] {r, c + 1});
                    matrix[r][c + 1] = matrix[r][c] + 1;
                }
            }
            if (checkValid(matrix, r - 1, c )) {
                if (matrix[r - 1][c] == Integer.MIN_VALUE) {
                    neigh.offer(new int[] {r - 1, c});
                    matrix[r - 1][c] = matrix[r][c] + 1;
                }
            }
            if (checkValid(matrix, r + 1, c)) {
                if (matrix[r + 1][c] == Integer.MIN_VALUE) {
                    neigh.offer(new int[] {r + 1, c});
                    matrix[r + 1][c] = matrix[r][c] + 1;
                }
            }
        }
    }

    private static boolean checkValid(int[][] matrix, int r, int c) {
        return (r >= 0 && r < matrix.length) && (c >= 0 && c < matrix[0].length);
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(updateMatrix(test));
    }
}
