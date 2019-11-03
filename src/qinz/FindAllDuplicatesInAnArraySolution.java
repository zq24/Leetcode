package qinz;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArraySolution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] map = new int[nums.length];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(map[nums[i] - 1] != 0) {
                res.add(nums[i]);
            } else {
                map[nums[i] - 1] = 1;
            }
        }
        return res;
    }
}
