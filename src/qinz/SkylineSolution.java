package qinz;

import java.util.ArrayList;

public class SkylineSolution {
    public static void main(String[] args) {
        int[][] test = {{2,7,9},{3,6,1}};
        int length = test.length;
        System.out.println(length);
        System.out.println(test[0].length);
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int maxIncrease = 0;
        int numOfRow = grid.length;
        int numOfColumn = grid[0].length;
        ArrayList<Integer> leftRight = new ArrayList<>();
        ArrayList<Integer> bottomUp = new ArrayList<>();
        for(int i = 0; i < numOfRow; i++) {
            int max = 0;
            for(int j = 0; j < numOfColumn; j++) {
                if(grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            leftRight.add(max);
        }

        for(int i = 0; i < numOfRow; i++) {
            int max = 0;
            for(int j = 0; j < numOfColumn; j++) {
                if(grid[j][i] > max) {
                    max = grid[j][i];
                }
            }
            bottomUp.add(max);
        }

        for(int i = 0; i < numOfRow; i++) {
            for(int j = 0; j < numOfColumn; j++) {
                if(leftRight.get(i) < bottomUp.get(j)) {
                    maxIncrease += (leftRight.get(i) - grid[i][j]);
                } else {
                    maxIncrease += (bottomUp.get(j) - grid[i][j]);
                }
            }
        }

        return maxIncrease;
    }
}
