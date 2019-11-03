package qinz;

public class TrappingRainWaterSolution {
    public int trap(int[] height) {
        int ptrOne = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                ptrOne = i;
            }
        }
        return 0;
    }
}
