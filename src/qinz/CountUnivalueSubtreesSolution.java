package qinz;

public class CountUnivalueSubtreesSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int numOfUnivalSubtrees = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        countUnivalSubtreesHelper(root);
        return numOfUnivalSubtrees;
    }

    public void countUnivalSubtreesHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (isUnivalue(root, root.val))
            numOfUnivalSubtrees += 1;
        countUnivalSubtreesHelper(root.left);
        countUnivalSubtreesHelper(root.right);
    }

    private boolean isUnivalue(TreeNode root, int parentValue) {
        if (root == null) {
            return true;
        }
        if (root.val != parentValue) {
            return false;
        } else {
            return isUnivalue(root.right, root.val) && isUnivalue(root.left, root.val);
        }
    }
}
