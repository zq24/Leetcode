package qinz;

public class DiameterOfBinaryTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        diameterOfBinaryTreeHelper(root);
        return max;
    }

    private int diameterOfBinaryTreeHelper(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 0;
        int left;
        int right;
        if(root.left != null) {
            left = 1 + diameterOfBinaryTreeHelper(root.left);
        } else {
            left = 0;
        }
        if(root.right != null) {
            right = 1 + diameterOfBinaryTreeHelper(root.right);
        } else {
            right = 0;
        }
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
