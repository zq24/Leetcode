package qinz;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }
        levelOrder(result, root, 0);
        return result;
    }

    private void levelOrder(List<List<Integer>> result, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);
        levelOrder(result, root.left, height + 1);
        levelOrder(result, root.right, height + 1);
    }
}
