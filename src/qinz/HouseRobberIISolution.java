package qinz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobberIISolution {

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] subProblemOne = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] subProblemTwo = Arrays.copyOfRange(nums, 1, nums.length);
        Map<Integer, Integer> mapOne = new HashMap<>();
        Map<Integer, Integer> mapTwo = new HashMap<>();
        return Math.max(robHelper(subProblemOne, 0, mapOne), robHelper(subProblemTwo, 0, mapTwo));
    }

    private static int robHelper(int[] nums, int index, Map<Integer, Integer> map) {
        if (index >= nums.length) {
            return 0;
        }

        if (map.containsKey(index)) {
            return map.get(index);
        }

        int robThisHouse = nums[index] + robHelper(nums, index + 2, map);
        int skipThisHouse = robHelper(nums, index + 1, map);
        int maxAmountOfMoney =  Math.max(robThisHouse, skipThisHouse);
        map.put(index, maxAmountOfMoney);
        return maxAmountOfMoney;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 2, 3, 1};
        System.out.println(rob(test));
    }
}