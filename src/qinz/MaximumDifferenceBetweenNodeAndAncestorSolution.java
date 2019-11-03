package qinz;

public class MaximumDifferenceBetweenNodeAndAncestorSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root != null) {
            maxAncestorDiff(root.right, root.val);
            maxAncestorDiff(root.left, root.val);
            maxAncestorDiff(root.left);
            maxAncestorDiff(root.right);
        }
        return max;
    }

    private void maxAncestorDiff(TreeNode root, int ancestor) {
        if (root == null) {
            return;
        }
        max = Math.max(max, Math.abs(root.val - ancestor));
        maxAncestorDiff(root.left, ancestor);
        maxAncestorDiff(root.right, ancestor);
    }
}
