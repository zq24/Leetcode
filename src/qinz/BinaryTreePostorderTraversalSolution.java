package qinz;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversalSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        postOrderTraversal(root, res);
        return res;
    }

    private void postOrderTraversal(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left, res);
        postOrderTraversal(root.right, res);
        res.add(root.val);
    }
}
