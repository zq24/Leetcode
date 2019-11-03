package qinz;

import java.util.Arrays;

public class WiggleSortSolution {
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if(nums.length >= 3) {
            for(int i = 1; i < nums.length - 1; i += 2) {
                if(i + 1 < nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {3, 5, 2, 1, 6, 4};
        wiggleSort(test);
        System.out.println(test);
        System.out.println();
    }
}
