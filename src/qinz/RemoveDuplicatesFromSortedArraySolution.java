package qinz;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArraySolution {
    public int removeDuplicates(int[] nums) {
        /*if (nums.length == 0) {
            return 0;
        }
        List<Integer> uniqueNum = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                uniqueNum.add(nums[i]);
            }
        }
        uniqueNum.add(nums[nums.length - 1]);
        for (int i = 0; i < uniqueNum.size(); i++) {
            nums[i] = uniqueNum.get(i);
        }
        return uniqueNum.size();*/

        //in place removing
         if (nums.length == 0) {
            return 0;
        }
        int switchPosition = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[switchPosition] = nums[i + 1];
                switchPosition++;
            }
        }
        return switchPosition;
    }
}
