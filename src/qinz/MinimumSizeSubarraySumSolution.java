package qinz;

public class MinimumSizeSubarraySumSolution {
    public static int minSubArrayLen(int s, int[] nums) {
        //Two Pointers
        int left = 0, right = 0;
        int sum = 0;
        int minimumSize = Integer.MAX_VALUE;
        for (right = 0; right <= nums.length;) {
            if (sum >= s) {
                minimumSize = Math.min(minimumSize, right - left);
                sum -= nums[left];
                left += 1;
            } else {
                if (right == nums.length)
                    break;
                sum += nums[right];
                right++;
            }
        }
        return (minimumSize == Integer.MAX_VALUE) ? 0 : minimumSize;
    }

    public static void main(String[] args) {
        int[] test = new int[] {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLen(213, test));
    }
}
