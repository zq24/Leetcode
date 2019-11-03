package qinz;

public class SubarraySumsDivisibleByKSolution {
    public static int subarraysDivByK(int[] A, int K) {
        /*int numOfDivisible = 0;
        int[][] sum = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            sum[i][i] = A[i];
            if (sum[i][i] % K == 0) {
                numOfDivisible += 1;
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j > i) {
                    sum[i][j] = sum[i][j - 1] + sum[j][j];
                    if (sum[i][j] % K == 0) {
                        numOfDivisible += 1;
                    }
                }
            }
        }
        return numOfDivisible;*/

        int sum = 0;
        int numOfDivisible = 0;
        int[] remainder = new int[K];
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int remain = sum % K;
            remain = (remain >= 0) ? remain : remain + K;
            remainder[remain] += 1;
        }
        for (int i = 1; i < K; i++) {
            if (remainder[i] != 0) {
                int num = remainder[i];
                num -= 1;
                numOfDivisible += (1 + num) * num / 2;
            }
        }
        return numOfDivisible + remainder[0];
    }

    public static void main(String[] args) {
        int[] test = new int[] {4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(test, 5));
    }
}
