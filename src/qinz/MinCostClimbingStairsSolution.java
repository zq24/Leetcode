package qinz;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairsSolution {

    static Map<Integer, Integer> map = new HashMap<>();

    public static int minCostClimbingStairs(int[] cost) {
        minCostClimbingStairs(cost, 0);
        return Math.min(map.get(0), map.get(1));
    }

    private static int minCostClimbingStairs(int[] cost, int stepIndex) {
        if (stepIndex > cost.length) {
            return -1;
        }

        if (stepIndex == cost.length) {
            return 0;
        }

        if (map.containsKey(stepIndex)) {
            return map.get(stepIndex);
        }

        int min = Integer.MAX_VALUE;
        int oneStep = minCostClimbingStairs(cost, stepIndex + 1);
        if (oneStep != -1) {
            min = Math.min(min, cost[stepIndex] + oneStep);
        }
        int twoStep = minCostClimbingStairs(cost, stepIndex + 2);
        if (twoStep != -1) {
            min = Math.min(min, cost[stepIndex] + twoStep);
        }
        map.put(stepIndex, min);
        return min;
    }

    public static void main(String[] args) {
        int[] test = new int[] {10, 15, 20};
        System.out.println(minCostClimbingStairs(test));
    }
}
