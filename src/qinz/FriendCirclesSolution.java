package qinz;

public class FriendCirclesSolution {
    public static int findCircleNum(int[][] M) {
        int numOfCircles = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                numOfCircles += 1;
                findCircleNum(M, i);
            }
        }
        return numOfCircles;
    }

    private static void findCircleNum(int[][] M, int r) {
        for (int i = 0; i < M[0].length; i++) {
            if (M[r][i] == 1) {
                M[r][i] = 0;
                if (r != i) {
                    findCircleNum(M, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(test));
    }
}
