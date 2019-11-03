package qinz;

import java.util.Arrays;

public class HeightCheckerSolution {
    public int heightChecker(int[] heights) {
        int[] copy = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            copy[i] = heights[i];
        }
        Arrays.sort(copy);
        int num = 0;
        for (int i = 0; i < heights.length; i++) {
            num = (copy[i] != heights[i]) ? num + 1 : num;
        }
        return num;
    }
}
