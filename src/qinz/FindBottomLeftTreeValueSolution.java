package qinz;

import java.util.ArrayList;
import java.util.List;

public class FindBottomLeftTreeValueSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        findBottomLeftValue(root, res, 0);
        return res.get(res.size() - 1).get(0);
    }

    private void findBottomLeftValue(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null) {
            return;
        }

        if (height >= res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(height).add(root.val);
        findBottomLeftValue(root.left, res, height + 1);
        findBottomLeftValue(root.right, res, height + 1);
    }
}
