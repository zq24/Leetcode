package qinz;

public class DecreaseElementsToMakeArrayZigzagSolution {
    public static int movesToMakeZigzag(int[] nums) {

        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        // calculate for both cases
        int numOfMovesEven = 0;
        for (int i = 0; i < nums.length; i+=2) {
            int adjacentSmall = i - 1;
            int adjacentLarge = i + 1;
            if (adjacentSmall >= 0) {
                while (nums[adjacentSmall] >= nums[i]) {
                    numOfMovesEven += 1;
                    nums[adjacentSmall]--;
                }
            }

            if (adjacentLarge < nums.length) {
                while (nums[adjacentLarge] >= nums[i]) {
                    numOfMovesEven += 1;
                    nums[adjacentLarge]--;
                }
            }
        }

        int numOfMovesOdd = 0;
        for (int i = 1; i < copy.length; i+=2) {
            int adjacentSmall = i - 1;
            int adjacentLarge = i + 1;
            if (adjacentSmall >= 0) {
                while (copy[adjacentSmall] >= copy[i]) {
                    numOfMovesOdd += 1;
                    copy[adjacentSmall]--;
                }
            }

            if (adjacentLarge < copy.length) {
                while (copy[adjacentLarge] >= copy[i]) {
                    numOfMovesOdd += 1;
                    copy[adjacentLarge]--;
                }
            }
        }

        return (numOfMovesEven < numOfMovesOdd) ? numOfMovesEven : numOfMovesOdd;

    }

    public static void main(String[] args) {
        int[] test = new int[] {9,6,1,6,2};
        System.out.println(movesToMakeZigzag(test));
    }
}
