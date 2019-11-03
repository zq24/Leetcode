package qinz;

public class SearchA2DMatrixIISolution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int col = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = col; j < matrix[0].length; j++) {
                int num = matrix[i][j];
                if (num == target) {
                    return true;
                } else if (num > target) {
                    col = j - 1;
                    if (col < 0) {
                        return false;
                    }
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{-1}, {-1}};
        System.out.println(searchMatrix(test, -2));
    }
}