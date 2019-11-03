package qinz;

import java.util.ArrayList;
import java.util.List;

public class PermutationsSolution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        List<Integer> permutation = new ArrayList<>();
        permute(list, results, permutation);
        return results;
    }

    private static void permute(List<Integer> nums, List<List<Integer>> res, List<Integer> list) {
        if (nums.size() == 0) {
            res.add(list);
            return;
        }


        for(int i = 0; i < nums.size(); i++) {
            int temp = nums.remove(i);
            List<Integer> newList = new ArrayList<>(list);
            newList.add(temp);
            permute(nums, res, newList);
            nums.add(i, temp);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3};
        System.out.println(permute(test));
    }
}
