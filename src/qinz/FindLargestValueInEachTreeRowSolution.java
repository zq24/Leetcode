package qinz;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRowSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        largestValues(root, res, 0);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            result.add(res.get(i).get(0));
        }
        return result;
    }

    private void largestValues(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null)
            return;
        if (height >= res.size()) {
            res.add(new ArrayList<>());
        }
        if (res.get(height).size() == 0) {
            res.get(height).add(root.val);
        } else {
            int current = res.get(height).get(0);
            res.get(height).remove(0);
            res.get(height).add(Math.max(current, root.val));
        }
        largestValues(root.left, res, height + 1);
        largestValues(root.right, res, height + 1);
    }
}
