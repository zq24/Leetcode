package qinz;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        spiralOrder(res, matrix, 0, 0, 1);
        return res;
    }

    private void spiralOrder(List<Integer> res, int[][] matrix, int r, int c, int direction) {
        res.add(matrix[r][c]);
        matrix[r][c] = Integer.MIN_VALUE;
        //Right direction: 1
        if (direction == 1) {
            //Calculate the next position
            if (c + 1 < matrix[0].length && matrix[r][c + 1] != Integer.MIN_VALUE) {
                spiralOrder(res, matrix, r, c + 1, 1);
            } else if (r + 1 < matrix.length && matrix[r + 1][c] != Integer.MIN_VALUE) {
                spiralOrder(res, matrix, r + 1, c, 2);
            } else {
                return;
            }
        } else if (direction == 2) {
            //Down direction: 2
            if (r + 1 < matrix.length && matrix[r + 1][c] != Integer.MIN_VALUE) {
                spiralOrder(res, matrix, r + 1, c, 2);
            } else if (c - 1 >= 0 && matrix[r][c - 1] != Integer.MIN_VALUE) {
                spiralOrder(res, matrix, r, c - 1, 3);
            } else {
                return;
            }
        } else if (direction == 3) {
            if (c - 1 >= 0 && matrix[r][c - 1] != Integer.MIN_VALUE) {
                spiralOrder(res, matrix, r, c - 1, 3);
            } else if (r - 1 >= 0 && matrix[r - 1][c] != Integer.MIN_VALUE) {
                spiralOrder(res, matrix, r - 1, c, 4);
            } else {
                return;
            }
        } else {
            if (r - 1 >= 0 && matrix[r - 1][c] != Integer.MIN_VALUE) {
                spiralOrder(res, matrix, r - 1, c, 4);
            } else if (c + 1 < matrix[0].length && matrix[r][c + 1] != Integer.MIN_VALUE) {
                spiralOrder(res, matrix, r, c + 1, 1);
            }
        }
    }
}
