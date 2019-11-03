package qinz;

public class TheMazeSolution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return hasPathHelper(maze, start, destination);
    }

    private boolean hasPathHelper(int[][] maze, int[] start, int[] destination) {
        boolean hasPath;
        int startRow = start[0];
        int startColumn = start[1];
        int destRow = destination[0];
        int destColumn = destination[1];
        if (startRow == destRow && startColumn == destColumn) {
            return true;
        }

        if (maze[startRow][startColumn] == 2) {
            return false;
        }

        //Mark this cell as visited
        int temp = maze[startRow][startColumn];
        maze[startRow][startColumn] = 2;

        //select a direction
        int[] left = nextPosition(maze, startRow, startColumn, 1);
        int[] right = nextPosition(maze, startRow, startColumn, 2);
        int[] up = nextPosition(maze, startRow, startColumn, 3);
        int[] down = nextPosition(maze, startRow, startColumn, 4);

        hasPath = hasPathHelper(maze, left, destination) ||
                hasPathHelper(maze, right, destination) ||
                hasPathHelper(maze, up, destination) ||
                hasPathHelper(maze, down, destination);

        //No need to restore;
        //maze[startRow][startColumn] = temp;

        return hasPath;
    }

    //return the position of the next step
    private int[] nextPosition(int[][] maze, int r, int c, int direction) {
        int currentRow = r;
        int currentColumn = c;

        if (direction == 1) {
            //Move Left
            while (currentColumn - 1 >= 0 && maze[currentRow][currentColumn - 1] != 1) {
                currentColumn -= 1;
            }
        } else if (direction == 2) {
            //Move Right
            while (currentColumn + 1 < maze[0].length && maze[currentRow][currentColumn + 1] != 1) {
                currentColumn += 1;
            }
        } else if (direction == 3) {
            //Move Up
            while (currentRow - 1 >= 0 && maze[currentRow - 1][currentColumn] != 1) {
                currentRow -= 1;
            }
        } else {
            //Move Down
            while (currentRow + 1 < maze.length && maze[currentRow + 1][currentColumn] != 1) {
                currentRow += 1;
            }
        }
        return new int[] {currentRow, currentColumn};
    }
}
