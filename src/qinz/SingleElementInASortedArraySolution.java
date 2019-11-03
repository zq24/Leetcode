package qinz;

public class SingleElementInASortedArraySolution {
    public int singleNonDuplicate(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
