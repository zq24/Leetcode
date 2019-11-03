package qinz;

public class FloodFillSolution {

    static int startingColor;

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        startingColor = image[sr][sc];
        floodFillHelper(image, sr, sc, newColor);
        return image;
    }

    private static void floodFillHelper(int[][] image, int r, int c, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length ||
                image[r][c] == Integer.MAX_VALUE || image[r][c] != startingColor) {
            return;
        }

        image[r][c] = newColor;
        int temp = image[r][c];
        image[r][c] = Integer.MAX_VALUE;
        floodFillHelper(image, r, c - 1, newColor);
        floodFillHelper(image, r, c + 1, newColor);
        floodFillHelper(image, r - 1, c, newColor);
        floodFillHelper(image, r + 1, c, newColor);
        image[r][c] = temp;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {{0, 0, 0}, {0, 1, 1}};
        floodFill(test, 1, 1, 1);
    }
}
