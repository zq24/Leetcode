package qinz;

import java.util.Map;
import java.util.TreeMap;

public class SingleNumberSolution {
    public int singleNumber(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) != null) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }
        for(Map.Entry m: map.entrySet()) {
            if((int)m.getValue() == 1) {
                return (int)m.getKey();
            }
        }
        return 0;
    }
}
