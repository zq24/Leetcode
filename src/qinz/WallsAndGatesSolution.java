package qinz;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGatesSolution {
    public void wallsAndGates(int[][] rooms) {
        //initialize the queue
        Queue<int[]> neigh = new LinkedList<>();

        //find all the starting points (all the Gates)
        //Push all the starting points into the queue
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    neigh.offer(new int[] {i, j});
                }
            }
        }

        //starting updating the rest of the node's shortest distance
        wallsAndGatesHelper(rooms, neigh);
    }

    private void wallsAndGatesHelper(int[][] rooms, Queue<int[]> neigh) {

        while (!neigh.isEmpty()) {
            //pop the node
            int[] current = neigh.poll();
            int r = current[0];
            int c = current[1];

            //loop and check all the current node's neighbor
            //Left neighbor
            if (checkValid(rooms, r, c - 1)) {
                //if the rooms has not been updated yet
                if (rooms[r][c - 1] == 2147483647) {
                    //push into the queue; update its distance
                    neigh.offer(new int[] {r, c - 1});
                    rooms[r][c - 1] = rooms[r][c] + 1;
                }
            }
            if (checkValid(rooms, r, c + 1)) {
                //if the rooms has not been updated yet
                if (rooms[r][c + 1] == 2147483647) {
                    //push into the queue; update its distance
                    neigh.offer(new int[] {r, c + 1});
                    rooms[r][c + 1] = rooms[r][c] + 1;
                }
            }
            if (checkValid(rooms, r - 1, c)) {
                //if the rooms has not been updated yet
                if (rooms[r - 1][c] == 2147483647) {
                    //push into the queue; update its distance
                    neigh.offer(new int[] {r - 1, c});
                    rooms[r - 1][c] = rooms[r][c] + 1;
                }
            }
            if (checkValid(rooms, r + 1, c)) {
                //if the rooms has not been updated yet
                if (rooms[r + 1][c] == 2147483647) {
                    //push into the queue; update its distance
                    neigh.offer(new int[] {r + 1, c});
                    rooms[r + 1][c] = rooms[r][c] + 1;
                }
            }
        }
    }

    private boolean checkValid(int[][] rooms, int r, int c) {
        return (r >= 0 && r < rooms.length) && (c >= 0 && c < rooms[0].length);
    }
}
