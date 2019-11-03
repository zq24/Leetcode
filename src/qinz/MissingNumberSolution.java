package qinz;

public class MissingNumberSolution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (1 + length) * length / 2;
        for(int i = 0; i < length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
