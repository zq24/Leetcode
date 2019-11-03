package qinz;

public class NextPermutationSolution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int index = nums.length - 1;
        int temp = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[index] > nums[i]) {
                for (int j = i; j <= index; j++) {
                    int shift = nums[j];
                    nums[j] = temp;
                    temp = shift;
                }
                nums[i] = temp;
                break;
            }
        }
    }
}
