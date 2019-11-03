package qinz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForestSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> delete = new HashSet<>();
        for (int numToDelete: to_delete) {
            delete.add(numToDelete);
        }
        delNodesHelper(root, delete, res, true);
        return res;
    }

    private TreeNode delNodesHelper(TreeNode root, Set<Integer> delete, List<TreeNode> res, boolean add) {
        if (root == null) {
            return null;
        }

        if (delete.contains(root.val)) {
            delNodesHelper(root.left, delete, res, true);
            delNodesHelper(root.right, delete, res, true);
            return null;
        } else {
            if (add) {
                res.add(root);
            }
        }

        TreeNode left = delNodesHelper(root.left, delete, res, false);
        TreeNode right = delNodesHelper(root.right, delete, res, false);
        if (left == null) {
            root.left = null;
        }
        if (right == null) {
            root.right = null;
        }
        return root;
    }
}
