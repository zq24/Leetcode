package qinz;

public class ProductOfArrayExceptSelfSolution {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = res[i] * right * nums[i + 1];
            right = right * nums[i + 1];
        }
        return res;
    }
}
