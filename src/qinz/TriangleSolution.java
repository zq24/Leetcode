package qinz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriangleSolution {

    /*int min = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        minimumTotalHelper(triangle, 0, 0, 0);
        return min;
    }

    private void minimumTotalHelper(List<List<Integer>> triangle, int height, int prevIndex, int sum) {
        if (height >= triangle.size()) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                int newSum = sum + triangle.get(height).get(prevIndex);
                minimumTotalHelper(triangle, height + 1, prevIndex, newSum);
            } else {
                if (prevIndex + 1 < triangle.get(height).size()) {
                    int newSum = sum + triangle.get(height).get(prevIndex + 1);
                    minimumTotalHelper(triangle, height + 1, prevIndex + 1, newSum);
                }
            }
        }
    }*/

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        for (int i = 2; i < triangle.size(); i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(triangle.get(i).get(j) + dp[i - 1][j - 1],
                        triangle.get(i).get(j) + dp[i - 1][j]);
            }
        }
        int res = dp[dp.length - 1][0];
        for (int i = 1; i < triangle.get(triangle.size() - 1).size(); i++) {
            res = Math.min(res, dp[dp.length - 1][i]);
        }
        return res;
    }
}
