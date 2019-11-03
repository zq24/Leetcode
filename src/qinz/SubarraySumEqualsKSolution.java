package qinz;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsKSolution {
    public static int subarraySum(int[] nums, int k) {
        /*int numOfContinuous = 0;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i < j) {
                    dp[i][j] = dp[i][j - 1] + dp[j][j];
                    if (dp[i][j] == k) {
                        numOfContinuous++;
                    }
                } else if (i == j) {
                    numOfContinuous++;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i <= j) {
                    numOfContinuous = (dp[i][j] == k) ? numOfContinuous + 1 : numOfContinuous;
                }
            }
        }
        return numOfContinuous;*/
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int numOfSubarray = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                int current = map.get(sum);
                map.put(sum, current + 1);
            }
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                numOfSubarray += map.get(sum);
            }
        }
        return numOfSubarray;
    }
}
