package qinz;

public class ArithmeticSlicesSolution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        boolean[][] dp = new boolean[A.length][A.length];
        int numOfArith = 0;
        for (int i = 0; i < A.length - 2; i++) {
            if ((A[i + 1] - A[i]) == (A[i + 2] - A[i + 1])) {
                dp[i][i + 2] = true;
                numOfArith += 1;
            }
        }

        for (int i = 4; i <= A.length; i++) {
            for (int j = 0; j + i - 1 < A.length; j++) {
                if (dp[j][j + i - 2]) {
                    if ((A[j + i - 1] - A[j + i - 2]) == (A[j + i - 2] - A[j + i - 3])) {
                        dp[j][j + i - 1] = true;
                        numOfArith += 1;
                    }
                }
            }
        }
        return numOfArith;
    }
}
