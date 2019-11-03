package qinz;

public class TargetSumSolution {

    static int numOfWays = 0;

    public static int findTargetSumWays(int[] nums, int S) {
        findTargetSumWaysHelper(nums, S, 0, 0);
        return numOfWays;
    }

    private static void findTargetSumWaysHelper(int[] nums, int S, int index, int curSum) {
        //multiply by -1 is equivalent to the negative sign
        //multiply by 1 is equivalent to the positive sign
        if (index > nums.length - 1) {
            if (curSum == S) {
                numOfWays += 1;
                return;
            } else {
                return;
            }
        }

        int newSum = curSum + nums[index];
        findTargetSumWaysHelper(nums, S, index + 1, newSum);
        newSum = curSum + nums[index] * -1;
        findTargetSumWaysHelper(nums, S, index + 1, newSum);
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(test, 3));
    }
}
