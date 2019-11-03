package qinz;

import java.util.ArrayList;
import java.util.List;

public class MaximumLevelSumOfABinaryTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxLevelSum(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        maxLevelSum(results, root, 0);
        int max = Integer.MIN_VALUE;
        int minLevel = 1;
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i) > max) {
                max = results.get(i);
                minLevel = i + 1;
            }
        }
        return minLevel;
    }

    private void maxLevelSum(List<Integer> result, TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (height >= result.size()) {
            result.add(0);
        }

        int originalSum = result.get(height);
        int newSum = originalSum + root.val;
        result.set(height, newSum);
        maxLevelSum(result, root.left, height + 1);
        maxLevelSum(result, root.right, height + 1);
    }
}