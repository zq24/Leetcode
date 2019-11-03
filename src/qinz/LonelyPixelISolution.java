package qinz;

public class LonelyPixelISolution {
    public int findLonelyPixel(char[][] picture) {

        int numOfLonely = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && lonelyCheck(picture, i, j - 1, 1) &&
                        lonelyCheck(picture, i - 1, j, 2) &&
                        lonelyCheck(picture, i, j + 1, 3) &&
                        lonelyCheck(picture, i + 1, j, 4)) {
                    numOfLonely += 1;
                }
            }
        }
        return numOfLonely;
    }

    private boolean lonelyCheck(char[][] picture, int r, int c, int direction) {
        if (r < 0 || r >= picture.length || c < 0 || c >= picture[0].length) {
            return true;
        }

        if (picture[r][c] == 'B') {
            return false;
        }

        if (direction == 1) {
            return lonelyCheck(picture, r, c - 1, 1);
        } else if (direction == 2) {
            return lonelyCheck(picture, r - 1, c, 2);
        } else if (direction == 3) {
            return lonelyCheck(picture, r, c + 1, 3);
        } else {
            return lonelyCheck(picture, r + 1, c, 4);
        }
    }
}
