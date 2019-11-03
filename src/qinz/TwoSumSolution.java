package qinz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int numTwo = 0;
        for(; i < nums.length; i++) {
            map.put(nums[i], i);
            numTwo = target - nums[i];
            if(map.containsKey(numTwo))
                if((i != map.get(numTwo))) {
                    break;
                }
        }
        int[] res = new int[2];
        res[0] = i;
        res[1] = map.get(numTwo);
        return res;
        /*Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int rr = target - nums[i];
            if (map.containsKey(rr) && map.get(rr) < i) {
                result[0] = map.get(rr);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;*/
    }

    public static void main(String[] args) {
        int[] test = new int[] {3, 3, 6};
        System.out.println(twoSum(test, 6));
    }
}
