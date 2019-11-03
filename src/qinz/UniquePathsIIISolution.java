package qinz;

public class UniquePathsIIISolution {

    static int numOfUniquePath = 0;
    static int numOfZero = 0;

    public static int uniquePathsIII(int[][] grid) {
        int startingR = 0;
        int startingC = 0;
        int endingR = 0;
        int endingC = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    numOfZero++;
                }
                if(grid[i][j] == 1) {
                    startingR = i;
                    startingC = j;
                }
                if(grid[i][j] == 2) {
                    endingR = i;
                    endingC = j;
                }
            }
        }
        uniquePathsIII(grid, startingR, startingC, endingR, endingC, 0);
        return numOfUniquePath;
    }

    private static void uniquePathsIII(int[][] grid, int startR, int startC, int endR, int endC, int num) {
        if((startR == endR) && (startC == endC) && (num == numOfZero)) {
            numOfUniquePath += 1;
            return;
        }

        if((startR >= grid.length) || (startC >= grid[0].length) || (startR < 0) || (startC < 0)
        || (grid[startR][startC] == 3) || (grid[startR][startC] == -1) || (grid[startR][startC] == 2)) {
            return;
        }

        //Mark as visited
        int temp = grid[startR][startC];
        grid[startR][startC] = 3;
        int visitedZero;
        if((temp != 1) && (temp != 2)) {
            visitedZero = num + 1;
        } else {
            visitedZero = num;
        }

        for(int i = 0; i < 4; i++) {
            if(i == 0) {
                int searchRight = startC + 1;
                uniquePathsIII(grid, startR, searchRight, endR, endC, visitedZero);
            }
            if(i == 1) {
                int searchLeft = startC - 1;
                uniquePathsIII(grid, startR, searchLeft, endR, endC, visitedZero);
            }
            if(i == 2) {
                int searchUp = startR - 1;
                uniquePathsIII(grid, searchUp, startC, endR, endC, visitedZero);
            }
            if(i == 3) {
                int searchDown = startR + 1;
                uniquePathsIII(grid, searchDown, startC, endR, endC, visitedZero);
            }
        }

        grid[startR][startC] = temp;

    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int[][] grid = new int[][]{{0, 1}, {2, 0}};
        System.out.println(uniquePathsIII(test));
    }
}
