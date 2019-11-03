package qinz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PerfectSquaresSolution {

    /*Map<Integer, Integer> map = new HashMap<>();

    public int numSquares(int n) {
        return numSquaresHelper(n);
    }

    private int numSquaresHelper(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        double sqrt = Math.sqrt(n);
        int leastNum = Integer.MAX_VALUE;
        for (int i = (int)sqrt; i >= 1; i--) {
            int remain = n - i * i;
            int numOfSquares = numSquaresHelper(remain);
            if (numOfSquares != -1) {
                leastNum = Math.min(leastNum, numOfSquares + 1);
            }
        }
        map.put(n, leastNum);
        return leastNum;
    }*/

    //Using BFS
    /*public int numSquares(int n) {
        //Initialize the Queue
        List<Integer> neigh = new LinkedList<>();
        neigh.add(1);

        while (!neigh.isEmpty()) {
            //Get the current node
        }
    }*/

    //using DP
    /*public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {

        }
    }*/

    static int least = Integer.MAX_VALUE;

    public static int numSquares(int n) {
        int count = 0;
        int maxS = 1;
        while (maxS * maxS <= n) {
            maxS++;
        }
        maxS--;
        minNum(n, maxS, count);
        return least;
    }

    private static void minNum(int n, int maxS, int count) {

        if (n < 0) {
            return;
        } else if (n == 0) {
            least = Math.min(least, count);
            return;
        }

        int x = 1;
        while (x * x <= n) {
            x++;
        }
        x--;

        for (int i = 1; i <= x; i++) {
            int newN = n - i * i;
            if (newN >= 0) {
                int newV = count + 1;
                minNum(newN, maxS, newV);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(numSquares(2));
    }
}
