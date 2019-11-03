package qinz;

public class SparseMatrixMultiplicationSolution {
    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] results = new int[A.length][B[0].length];
        for(int i = 0; i < results.length; i++) {
            for(int j = 0; j < results[0].length; j++) {
                for(int k  = 0; k < B.length; k++) {
                    results[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 0, 0}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        multiply(A, B);
    }
}
