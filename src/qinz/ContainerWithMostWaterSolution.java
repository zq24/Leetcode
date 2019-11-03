package qinz;

public class ContainerWithMostWaterSolution {
    public static int maxArea(int[] height) {
        /*int max = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int containerHeight = (height[i] > height[j]) ? height[j] : height[i];
                max = Math.max(max, (j - i) * containerHeight);
            }
        }
        return max;*/
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        boolean flag = false;

        while(start != end) {
            int containerHeight = (height[start] > height[end]) ? height[end] : height[start];
            int newMax = (end - start) * containerHeight;
            if(newMax < max) {
                if(flag) {
                    start++;
                } else {
                    end++;
                    start++;
                    flag = true;
                }
            } else {
                max = newMax;
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(input));
    }
}
