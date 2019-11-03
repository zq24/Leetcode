package qinz;

public class IncreasingOrderSearchTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode newRoot = null;
    TreeNode temp = null;

    public TreeNode increasingBST(TreeNode root) {
        increasingBSTHelper(root);
        return newRoot;
    }

    private void increasingBSTHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        increasingBSTHelper(root.left);
        if (newRoot == null) {
            newRoot = root;
            temp = newRoot;
        } else {
            root.left = null;
            temp.right = root;
            temp = temp.right;
        }
        increasingBSTHelper(root.right);
    }
}
