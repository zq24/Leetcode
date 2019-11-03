package qinz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AsFarFromLandAsPossibleSolution {

    public int maxDistance(int[][] grid) {

        int max = Integer.MIN_VALUE;

        // using DFS
        for (int i  = 0; i < grid.length; i++) {
            for (int j = 0 ; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Queue<List<Integer>> queue = new LinkedList<>();
                    // add the starting point into this queue
                    List<Integer> start = new ArrayList<>();
                    start.add(i);
                    start.add(j);
                    queue.add(start);
                    int[][] newRecord = new int[grid.length][grid[0].length];
                    newRecord[i][j] = 1;
                    int dist = maxDistance(queue, grid, newRecord);
                    max = (dist > max) ? dist : max;
                }
            }
        }
        return (max == Integer.MIN_VALUE) ? -1 : max;
    }

    private int maxDistance(Queue<List<Integer>> queue, int[][] grid, int[][] record) {
        // while the queue is not empty
        while (!queue.isEmpty()) {
            List<Integer> location = queue.poll();

            // get this location
            int r = location.get(0);
            int c = location.get(1);

            // mark this location as visited
            // record[r][c] = Integer.MAX_VALUE;

            // check all the neigh of this location
            // check if the neigh's location is within the grid
            if (checkValid(r - 1, c, grid, record)) {
                if (grid[r - 1][c] == 0) {
                    // not a land, need to mark as visited
                    record[r - 1][c] = record[r][c] + 1;

                    // push it into the queue
                    List<Integer> visited = new ArrayList<>();
                    visited.add(r - 1);
                    visited.add(c);
                    queue.add(visited);
                } else {
                    return record[r][c];
                }
            }

            if (checkValid(r + 1, c, grid, record)) {
                if (grid[r + 1][c] == 0) {
                    // not a land, need to mark as visited
                    record[r + 1][c] = record[r][c] + 1;

                    // push it into the queue
                    List<Integer> visited = new ArrayList<>();
                    visited.add(r + 1);
                    visited.add(c);
                    queue.add(visited);
                } else {
                    return record[r][c];
                }
            }

            if (checkValid(r, c - 1, grid, record)) {
                if (grid[r][c - 1] == 0) {
                    // not a land, need to mark as visited
                    record[r][c - 1] = record[r][c] + 1;

                    // push it into the queue
                    List<Integer> visited = new ArrayList<>();
                    visited.add(r);
                    visited.add(c - 1);
                    queue.add(visited);
                } else {
                    return record[r][c];
                }
            }

            if (checkValid(r, c + 1, grid, record)) {
                if (grid[r][c + 1] == 0) {
                    // not a land, need to mark as visited
                    record[r][c + 1] = record[r][c] + 1;

                    // push it into the queue
                    List<Integer> visited = new ArrayList<>();
                    visited.add(r);
                    visited.add(c + 1);
                    queue.add(visited);
                } else {
                    return record[r][c];
                }
            }
        }
        return -1;
    }

    private boolean checkValid(int r, int c, int[][] grid, int[][] neigh) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length) && neigh[r][c] == 0;
    }
}
