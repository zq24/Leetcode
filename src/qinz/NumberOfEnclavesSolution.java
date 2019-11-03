package qinz;

public class NumberOfEnclavesSolution {
    /*int numOfEnclaves = 0;

    public int numEnclaves(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1 && !numEnclaves(A, i , j)) {
                    numOfEnclaves += 1;
                }
            }
        }
        return numOfEnclaves;
    }

    private boolean numEnclaves(int[][] A, int r, int c) {
        if (r == 0 || r == A.length - 1 || c == 0 || c == A[0].length - 1) {
            if (A[r][c] == 1) {
                return true;
            } else {
                return false;
            }
        }

        if (A[r][c] == 0 || A[r][c] == 2) {
            return false;
        }

        int temp = A[r][c];
        A[r][c] = 2;
        boolean right = numEnclaves(A, r, c + 1);
        boolean left = numEnclaves(A, r, c - 1);
        boolean down = numEnclaves(A, r + 1, c);
        boolean up = numEnclaves(A, r - 1, c);
        A[r][c] = temp;
        return left || right || down || up;
    }*/

    int numOfNonEnclsves = 0;

    public int numEnclaves(int[][] A) {
        int numOfLands = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                numOfLands = (A[i][j] == 1) ? numOfLands + 1 : numOfLands;
            }
        }

        for (int i = 0; i < A[0].length; i++) {
            numEnclaves(A, 0, i);
            numEnclaves(A, A.length - 1, i);
        }

        for (int i = 0; i < A.length; i++) {
            numEnclaves(A, i, 0);
            numEnclaves(A, i, A[0].length - 1);
        }

        return numOfLands - numOfNonEnclsves;
    }

    private void numEnclaves(int[][] A, int r, int c) {
        if (r < 0 || r >= A.length || c < 0 || c >= A[0].length || A[r][c] == 0) {
            return;
        }

        //mark as visited
        A[r][c] = 0;
        numOfNonEnclsves += 1;
        numEnclaves(A, r, c - 1);
        numEnclaves(A, r, c + 1);
        numEnclaves(A, r - 1, c);
        numEnclaves(A, r + 1, c);
    }
}
