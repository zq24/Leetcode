package qinz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequencesSolution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        findSubsequences(nums, res, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }

    private void findSubsequences(int[] nums, Set<List<Integer>> res, List<Integer> increaseSeq, int index) {
        if (increaseSeq.size() >= 2) {
            res.add(increaseSeq);
        }

        for (int i = index; i < nums.length; i++) {
            if (increaseSeq.size() >= 1) {
                if (increaseSeq.get(increaseSeq.size() - 1) <= nums[i]) {
                    List<Integer> newPossible = new ArrayList<>(increaseSeq);
                    newPossible.add(nums[i]);
                    findSubsequences(nums, res, newPossible, i + 1);
                } else {
                    findSubsequences(nums, res, increaseSeq, i + 1);
                }
            } else {
                List<Integer> newStart = new ArrayList<>();
                newStart.add(nums[i]);
                findSubsequences(nums, res, newStart, i + 1);
            }
        }
    }
}
