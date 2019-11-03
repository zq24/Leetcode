package qinz;

public class FlippingAnImageSolution {
    public static int[][] flipAndInvertImage(int[][] A) {
        /*for(int i  = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(j > A[0].length - 1 - j) {
                    break;
                } else {
                    int temp = A[i][j];
                    A[i][j] = (A[i][A[0].length - 1 - j] == 0) ? 1 : 0;
                    A[i][A[0].length - 1 - j] = (temp == 0) ? 1 : 0;
                }
            }
        }
        return A;*/

        for(int i  = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if((j < A[0].length - 1 - j) && (A[i][j] == A[i][A[0].length - 1 - j])) {
                    A[i][j] = A[i][j] ^ 1;
                    A[i][A[0].length - 1 - j] = A[i][A[0].length - 1 - j] ^ 1;
                } else if((j == A[0].length - 1 - j) && (A[i][j] == A[i][A[0].length - 1 - j])) {
                    A[i][j] = A[i][j] ^ 1;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(test);
    }
}
