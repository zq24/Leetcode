package qinz;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = start + k - 1;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for(int i = 1; i <= nums.length - k; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            max = Math.max(sum, max);
        }
        return max / k;
    }
}
