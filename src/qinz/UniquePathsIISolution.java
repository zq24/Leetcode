package qinz;

import java.util.List;
import java.util.Set;

public class UniquePathsIISolution {

    /*int numOfUniquePath = 0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            return 0;
        }
        uniquePathsWithObstacles(obstacleGrid, 0 , 0);
        return numOfUniquePath;
    }

    private void uniquePathsWithObstacles(int[][] obstacleGrid, int r, int c) {

        if (r >= obstacleGrid.length || c >= obstacleGrid[0].length)
            return;

        if(r == obstacleGrid.length - 1 && c == obstacleGrid[0].length - 1) {
            numOfUniquePath++;
            return;
        }

        if(obstacleGrid[r][c] == 1) {
            return;
        }

        for(int i = 0; i < 2; i++) {
            if(i == 0) {
                //move right
                int moveRight = c + 1;
                uniquePathsWithObstacles(obstacleGrid, r, moveRight);
            }
            if(i == 1) {
                //move down
                int moveDown = r + 1;
                uniquePathsWithObstacles(obstacleGrid, moveDown, c);
            }
        }
    }*/

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        obstacleGrid[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        for(int i = 1; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] != 1) {
                if(obstacleGrid[0][i - 1] != 0) {
                    obstacleGrid[0][i] = 1;
                }
            } else {
                obstacleGrid[0][i] = 0;
            }
        }

        for(int i = 1; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] != 1) {
                if(obstacleGrid[i - 1][0] != 0) {
                    obstacleGrid[i][0] = 1;
                }
            } else {
                obstacleGrid[i][0] = 0;
            }
        }
        for(int i = 1; i < obstacleGrid.length; i++) {
            for(int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
