package qinz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combinationSumHelper(candidates, new ArrayList<>(), res, target, 0, 0);
        return res;
    }

    private void combinationSumHelper(int[] candidates, List<Integer> combination, List<List<Integer>> res,
                                      int target, int currentSum, int startPosition) {
        if(currentSum > target) {
            return;
        }

        if(currentSum == target) {
            res.add(combination);
            return;
        }

        for(int i = startPosition; i < candidates.length; i++) {
            int newSum = currentSum + candidates[i];
            List<Integer> newCombination = new ArrayList<>(combination);
            newCombination.add(candidates[i]);
            combinationSumHelper(candidates, newCombination, res, target, newSum, i);
        }
    }
}
