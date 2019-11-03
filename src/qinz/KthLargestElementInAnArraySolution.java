package qinz;

import java.util.Arrays;

public class KthLargestElementInAnArraySolution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
