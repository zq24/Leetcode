package qinz;

public class UnivaluedBinaryTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeHelper(root, root.val);
    }

    private boolean isUnivalTreeHelper(TreeNode root, int parentValue) {
        if (root == null) {
            return true;
        }
        if (root.val != parentValue) {
            return false;
        } else {
            return isUnivalTreeHelper(root.left, root.val) && isUnivalTreeHelper(root.right, root.val);
        }
    }
}
