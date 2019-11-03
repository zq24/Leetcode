package qinz;

public class MaxAreaOfIslandSolution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = islandArea(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int islandArea(int[][] grid, int r, int c) {
        int area;
        if(boundaryCheck(grid, r, c) && (grid[r][c] == 2 || grid[r][c] == 0)) {
            area = 0;
            return area;
        } else if(boundaryCheck(grid, r, c) && (grid[r][c] == 1)) {
            area = 1;
            grid[r][c] = 2;
            return area + islandArea(grid, r, c - 1) + islandArea(grid, r, c + 1)
                    + islandArea(grid, r - 1, c) + islandArea(grid, r + 1, c);
        } else {
            area = 0;
            return area;
        }
    }

    private boolean boundaryCheck(int[][] grid, int r, int c) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length);
    }
}
