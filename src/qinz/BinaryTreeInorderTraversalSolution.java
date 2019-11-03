package qinz;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversalSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> results) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left, results);
        results.add(root.val);
        inorderTraversal(root.right, results);
    }
}
