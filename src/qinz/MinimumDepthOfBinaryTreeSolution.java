package qinz;

public class MinimumDepthOfBinaryTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        int minHeight;
        if(root == null)
            return 0;
        if(root.left == null && root.right == null) {
            return 1;
        } else if(root.left == null && root.right != null) {
            minHeight = 1 + minDepth(root.right);
        } else if (root.left != null && root.right == null) {
            minHeight = 1 + minDepth(root.left);
        } else {
            minHeight = 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        return minHeight;
    }
}
