package qinz;

import java.util.*;

public class ShortestDistanceFromAllBuildingsSolution {
    static int searchValue = 0;
    static boolean cannotAccess = false;

    public static int shortestDistance(int[][] grid) {
        List<int[][]> distance = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //This location marks a building
                if (grid[i][j] == 1) {
                    Queue<int[]> neigh = new LinkedList<>();
                    neigh.offer(new int[] {i, j});
                    int[][] shortest = new int[grid.length][grid[0].length];
                    shortestDistance(grid, neigh, shortest);
                    if (cannotAccess)
                        return -1;
                    distance.add(shortest);
                }
            }
        }

        for (int i = 0; i < distance.size(); i++) {
            int[][] temp = distance.get(i);
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < temp[0].length; k++) {
                    System.out.print(temp[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println();

        int result = Integer.MAX_VALUE;
        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < distance.size(); i++) {
            int[][] temp = distance.get(i);
            for (int j = 0; j < res.length; j++) {
                for (int k = 0; k < res[0].length; k++) {
                    res[j][k] += temp[j][k];
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (res[i][j] != 0) {
                    result = Math.min(result, res[i][j]);
                }
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

        return result;
    }

    private static void shortestDistance(int[][] grid, Queue<int[]> neigh, int[][] shortest) {

        int number = 0;

        while (!neigh.isEmpty()) {
            //get the current
            int[] current = neigh.poll();
            int r = current[0];
            int c = current[1];

            if (checkValid(grid, r, c - 1)) {
                if (grid[r][c - 1] == searchValue) {
                    grid[r][c - 1]--;
                    neigh.offer(new int[] {r, c - 1});
                    shortest[r][c - 1] = shortest[r][c] + 1;
                    number++;
                }
            }

            if (checkValid(grid, r, c + 1)) {
                if (grid[r][c + 1] == searchValue) {
                    grid[r][c + 1]--;
                    neigh.offer(new int[] {r, c + 1});
                    shortest[r][c + 1] = shortest[r][c] + 1;
                    number++;
                }
            }

            if (checkValid(grid, r - 1, c)) {
                if (grid[r - 1][c] == searchValue) {
                    grid[r - 1][c]--;
                    neigh.offer(new int[] {r - 1, c});
                    shortest[r - 1][c] = shortest[r][c] + 1;
                    number++;
                }
            }

            if (checkValid(grid, r + 1, c)) {
                if (grid[r + 1][c] == searchValue) {
                    grid[r + 1][c]--;
                    neigh.offer(new int[] {r + 1, c});
                    shortest[r + 1][c] = shortest[r][c] + 1;
                    number++;
                }
            }
        }

        cannotAccess = number == 0;

        searchValue--;
    }

    private static boolean checkValid(int[][] grid, int r, int c) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length);
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {{0,2,0,2,2,0,2,2},{0,2,2,2,1,0,1,2},{0,0,0,1,0,2,0,0},{2,0,0,2,0,2,2,0},{0,0,0,2,0,0,0,0}};
        shortestDistance(test);
    }
}
