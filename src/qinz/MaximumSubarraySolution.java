package qinz;

public class MaximumSubarraySolution {
    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(sum < 0) {
                sum = nums[i];
                max = Math.max(max, sum);
            } else {
                sum += nums[i];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(test));
    }
}
