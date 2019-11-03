package qinz;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrixSolution {
    /*static int shortest = Integer.MAX_VALUE;

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return -1;
        shortestPathBinaryMatrix(grid, 0, 0, 0);
        return (shortest == Integer.MAX_VALUE) ? -1 : shortest;
    }

    private static void shortestPathBinaryMatrix(int[][] grid, int r, int c, int currentLength) {
        if ((r == grid.length - 1) && (c == grid[0].length - 1)) {
            shortest = Math.min(shortest, currentLength + 1);
            return;
        }

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
                || grid[r][c] == 1 || grid[r][c] == 2) {
            return;
        }

        int temp = grid[r][c];
        grid[r][c] = 2;
        int newLength = currentLength + 1;

        shortestPathBinaryMatrix(grid, r, c - 1, newLength);
        shortestPathBinaryMatrix(grid, r, c + 1, newLength);
        shortestPathBinaryMatrix(grid, r - 1, c, newLength);
        shortestPathBinaryMatrix(grid, r + 1, c, newLength);
        shortestPathBinaryMatrix(grid, r - 1, c - 1, newLength);
        shortestPathBinaryMatrix(grid, r - 1, c + 1, newLength);
        shortestPathBinaryMatrix(grid, r + 1, c - 1, newLength);
        shortestPathBinaryMatrix(grid, r + 1, c + 1, newLength);

        grid[r][c] = temp;
    }*/

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return -1;
        //initialize the queue
        Queue<int[]> neigh = new LinkedList<>();
        neigh.offer(new int[] {0, 0});
        shortestPathBinaryMatrix(neigh, grid);
        return (grid[grid.length - 1][grid[0].length - 1] == 0) ? -1 : grid[grid.length - 1][grid[0].length - 1] + 1;
    }

    private void shortestPathBinaryMatrix(Queue<int[]> neigh, int[][] grid) {
        while (!neigh.isEmpty()) {
            //pop the current node
            int[] current = neigh.poll();
            int r = current[0];
            int c = current[1];

            //Loop and check all the neighbors of this current node
            if (checkValid(grid, r, c - 1)) {
                neigh.offer(new int[] {r, c - 1});
                grid[r][c - 1] = grid[r][c] + 1;
            }

            if (checkValid(grid, r, c + 1)) {
                neigh.offer(new int[] {r, c + 1});
                grid[r][c + 1] = grid[r][c] + 1;
            }

            if (checkValid(grid, r - 1, c)) {
                neigh.offer(new int[] {r - 1, c});
                grid[r - 1][c] = grid[r][c] + 1;
            }

            if (checkValid(grid, r + 1, c)) {
                neigh.offer(new int[] {r + 1, c});
                grid[r + 1][c] = grid[r][c] + 1;
            }

            if (checkValid(grid, r - 1, c - 1)) {
                neigh.offer(new int[] {r - 1, c - 1});
                grid[r - 1][c - 1] = grid[r][c] + 1;
            }
            if (checkValid(grid, r - 1, c + 1)) {
                neigh.offer(new int[] {r - 1, c + 1});
                grid[r - 1][c + 1] = grid[r][c] + 1;
            }
            if (checkValid(grid, r + 1, c - 1)) {
                neigh.offer(new int[] {r + 1, c - 1});
                grid[r + 1][c - 1] = grid[r][c] + 1;
            }
            if (checkValid(grid, r + 1, c + 1)) {
                neigh.offer(new int[] {r + 1, c + 1});
                grid[r + 1][c + 1] = grid[r][c] + 1;
            }
        }
    }

    private boolean checkValid(int[][] grid, int r, int c) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length) && grid[r][c] == 0;
    }
}
