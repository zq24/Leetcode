package qinz;

public class LowestCommonAncestorOfDeepestLeavesSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int deepest;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        deepest = heightOfTree(root);
        return lcaDeepestLeavesHelper(root, 1);
    }

    private TreeNode lcaDeepestLeavesHelper(TreeNode root, int height) {
        if (root == null) {
            return null;
        }

        if (height == deepest) {
            return root;
        }

        TreeNode left = lcaDeepestLeavesHelper(root.left, height + 1);
        TreeNode right = lcaDeepestLeavesHelper(root.right, height + 1);

        if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right != null) {
            return root;
        } else {
            return null;
        }
    }

    private int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }
}
