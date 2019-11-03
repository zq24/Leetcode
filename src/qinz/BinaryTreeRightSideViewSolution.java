package qinz;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideViewSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        rightSideView(res, root, 0);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < res.size(); i++) {
            result.add(res.get(i).get(res.get(i).size() - 1));
        }
        return result;
    }

    private void rightSideView(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        rightSideView(res, root.left, height + 1);
        rightSideView(res, root.right, height + 1);
    }
}
