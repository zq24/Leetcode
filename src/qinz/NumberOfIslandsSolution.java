package qinz;

public class NumberOfIslandsSolution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    numOfIslands++;
                    numIslands(grid, i ,j);
                }
            }
        }
        return numOfIslands;
    }

    private void numIslands(char[][] grid, int r, int c) {
        if(boundaryCheck(grid, r, c) && grid[r][c] == '1') {
            grid[r][c] = '2';
            numIslands(grid, r, c - 1);
            numIslands(grid, r, c + 1);
            numIslands(grid, r - 1, c);
            numIslands(grid, r + 1, c);
        } else {
            return;
        }
    }

    private boolean boundaryCheck(char[][] grid, int r, int c) {
        return (r >=0 && r < grid.length) && (c >= 0 && c < grid[0].length);
    }
}
