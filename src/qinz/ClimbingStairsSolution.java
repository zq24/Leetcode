package qinz;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsSolution {

    static Map<Integer, Integer> map = new HashMap<>();

    public static int climbStairs(int n) {
        return climbStairsHelper(n);
    }

    private static int climbStairsHelper(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int way1 = 0;
        int way2 = 0;
        for (int i = 0; i < 2; i++) {
            int remain = n - (i + 1);
            int waysForRemainingStairs = climbStairsHelper(remain);
            if (waysForRemainingStairs != 0) {
                map.put(remain, waysForRemainingStairs);
                if (i == 0) {
                    way1 = waysForRemainingStairs;
                } else {
                    way2 = waysForRemainingStairs;
                }
            }
            map.put(n, way1 + way2);
        }
        return way1 + way2;
    }

    /*public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n + 1];
    }*/

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}
