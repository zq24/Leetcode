package qinz;

public class BinaryTreeMaximumPathSumSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumTraverse(root);
        return max;
    }

    private void maxPathSumTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        int leftSum = maxPathSumHelper(root.left);
        int rightSum = maxPathSumHelper(root.right);
        int maximum = Math.max(root.val, root.val + rightSum + leftSum);
        maximum = Math.max(maximum, root.val + Math.max(rightSum, leftSum));

        max = Math.max(max, maximum);
        maxPathSumTraverse(root.left);
        maxPathSumTraverse(root.right);
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        return Math.max(root.val + Math.max(left, right), root.val);
    }
}
