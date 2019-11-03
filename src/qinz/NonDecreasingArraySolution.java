package qinz;

public class NonDecreasingArraySolution {
    public static boolean checkPossibility(int[] nums) {
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (!flag) {
                    flag = true;
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    if (i >= 2) {
                        if (nums[i - 1] < nums[i - 2]) {
                            nums[i - 1] = temp;
                            nums[i] = nums[i - 1];
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2, 3, 3, 2, 4};
        System.out.println(checkPossibility(test));
    }
}
