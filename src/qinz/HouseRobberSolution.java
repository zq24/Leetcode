package qinz;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberSolution {

    /*int max = Integer.MIN_VALUE;

    public int rob(int[] nums) {
        robHelper(nums, 0, 0);
        return max;
    }

    private void robHelper(int[] nums, int location, int money) {
        if (location >= nums.length) {
            max = Math.max(max, money);
            return;
        }

        for (int i = location; i < nums.length; i++) {
            int collected = money + nums[i];
            robHelper(nums, i + 2, collected);
        }
    }*/

    Map<Integer, Integer> map = new HashMap<>();

    public int rob(int[] nums) {
        return robHelper(nums, 0);
    }

    private int robHelper(int[] nums, int location) {
        if (location >= nums.length) {
            return 0;
        }

        if (map.containsKey(location)) {
            return map.get(location);
        }

        /*int max = Integer.MIN_VALUE;
        for (int i = location; i < nums.length; i++) {
            int moneyFromRemainingHouses = robHelper(nums, i + 2);
            max = Math.max(max, nums[i] + moneyFromRemainingHouses);
        }*/
        int max = Math.max(nums[location] + robHelper(nums, location + 2),
                robHelper(nums, location + 1));
        map.put(location, max);
        return max;
    }
}
