package qinz;

public class UniqueBinarySearchTreesSolution {
    public int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //we could use 1 to i as root
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
