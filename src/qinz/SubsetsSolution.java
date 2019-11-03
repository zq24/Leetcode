package qinz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubsetsSolution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void subsets(List<List<Integer>> res, List<Integer> list, int[] nums, int startPosition) {
        if (res.size() < Math.pow(2, nums.length)) {
            res.add(list);
        }

        for (int i = startPosition; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            subsets(res, newList, nums, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 2, 3};
        System.out.println(subsets(test));
    }
}
