package qinz;

public class IslandPerimeterSolution {
    public int islandPerimeter(int[][] grid) {
        int islandPerimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    islandPerimeter += singleIslandPerimeter(grid, i, j);
                }
            }
        }
        return islandPerimeter;
    }

    private int singleIslandPerimeter(int[][] grid, int r, int c) {
        int perimeter = 4;
        if(hasNeighbor(grid, r, c + 1)) {
            perimeter--;
        }
        if (hasNeighbor(grid, r, c - 1)) {
            perimeter--;
        }
        if (hasNeighbor(grid, r - 1, c)) {
            perimeter--;
        }
        if (hasNeighbor(grid, r + 1, c)) {
            perimeter--;
        }
        return perimeter;
    }

    private boolean hasNeighbor(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }
        if (grid[r][c] == 1) {
            return true;
        } else {
            return false;
        }
    }
}
