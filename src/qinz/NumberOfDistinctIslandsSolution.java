package qinz;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDistinctIslandsSolution {

    Map<String, Integer> map = new HashMap<>();

    public int numDistinctIslands(int[][] grid) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numDistinctIslandsHelper(grid, i, j, res);
                    if (!map.containsKey(res.toString())) {
                        map.put(res.toString(), 1);
                    }
                    res.delete(0, res.length());
                }
            }
        }
        return map.size();
    }

    private void numDistinctIslandsHelper(int[][] grid, int r, int c, StringBuilder cur) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
                || grid[r][c] == 0 || grid[r][c] == 2) {
            return;
        }

        //Mark as visited
        grid[r][c] = 2;
        cur.append(1);
        numDistinctIslandsHelper(grid, r, c - 1, cur);
        cur.append(2);
        numDistinctIslandsHelper(grid, r, c + 1, cur);
        cur.append(3);
        numDistinctIslandsHelper(grid, r - 1, c, cur);
        cur.append(4);
        numDistinctIslandsHelper(grid, r + 1, c, cur);
    }
}
