package qinz;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLaddersSolution {
    public static int snakesAndLadders(int[][] board) {

        int min = Integer.MAX_VALUE;

        // length of N; determine N is even or add
        int length = board.length;
        int parity = length % 2;

        // initialize the queue
        Queue<Integer> queue = new LinkedList<>();

        // initialize another board for recording the steps
        int[][] visited = new int[length][length];

        // add the starting point to the queue
        queue.add(1);

        while (!queue.isEmpty()) {

            // pop the board number
            int boardNum = queue.poll();
            System.out.println("The board number is: " + boardNum);

            // recover a coordinate from this number
            int[] coordinate = recoverCoordinate(boardNum, length, parity);
            int r = coordinate[0];
            int c = coordinate[1];
            System.out.println("The corresponding row and column, row: " + r + " column: " + c);
            if (boardNum == length * length) {
                min = Math.min(visited[r][c], min);
            }
            for (int i = 1; i <= 6; i++) {
                int destination = boardNum + i;
                if (destination <= length * length) {
                    int[] desCoordinate = recoverCoordinate(destination, length, parity);
                    int desRow = desCoordinate[0];
                    int desCol = desCoordinate[1];
                    System.out.println("The destination number is: " + destination);
                    System.out.println("The corresponding row and column, row: " + desRow + " column: " + desCol);
                    //if (visited[desRow][desCol] == 0) {
                        if (board[desRow][desCol] != -1) {
                            int jumpTo = board[desRow][desCol];
                            if (jumpTo != 1) {
                                int[] jumpToCoordinate = recoverCoordinate(jumpTo, length, parity);
                                int jumpToRow = jumpToCoordinate[0];
                                int jumpToCol = jumpToCoordinate[1];
                                //if (visited[jumpToRow][jumpToCol] == 0) {
                                    //visited[jumpToRow][jumpToCol] = (visited[jumpToRow][jumpToCol] < visited[r][c] + 1) ? visited[r][c] + 1 : visited[jumpToRow][jumpToCol];
                                    //queue.add(jumpTo);
                                //}
                                if (visited[jumpToRow][jumpToCol] > visited[r][c] + 1) {
                                    visited[jumpToRow][jumpToCol] = visited[r][c] + 1;
                                    queue.add(jumpTo);
                                }
                            }
                        } else {
                            //visited[desRow][desCol] = (visited[desRow][desCol] < visited[r][c] + 1) ? visited[r][c] + 1 : visited[desRow][desCol];
                            //queue.add(destination);
                            if (visited[desRow][desCol] > visited[r][c] + 1) {
                                visited[desRow][desCol] = visited[r][c] + 1;
                                queue.add(destination);
                            }
                        }
                    //}
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private static int[] recoverCoordinate(int boardNum, int length, int parity) {
        int verticalMove = (boardNum - 1) / length;
        int horizontalMove = (boardNum - 1) % length;
        int r = (length - 1) - verticalMove;
        int c;
        if (parity == 0) {
            if (r % 2 == 0) {
                c = length - 1 - horizontalMove;
            } else {
                c = horizontalMove;
            }
        } else {
            if (r % 2 == 0) {
                c = horizontalMove;
            } else {
                c = length - 1 - horizontalMove;
            }
        }
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{-1,-1},{-1,1}};
        System.out.println(snakesAndLadders(board));
    }
}