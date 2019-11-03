package qinz;

public class BalancedBinaryTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return false;
        }
        boolean isBalancedTree = isBalancedHelper(root);
        return isBalancedTree;
    }

    private boolean isBalancedHelper(TreeNode root) {
        if(root == null)
            return true;
        boolean isBalanced;
        int heightOfLeft = heightOfTree(root.left);
        int heightOfRight = heightOfTree(root.right);
        if(Math.abs(heightOfLeft - heightOfRight) > 1) {
            isBalanced = false;
        } else {
            isBalanced = true && isBalancedHelper(root.right) && isBalancedHelper(root.left);
        }
        return isBalanced;
    }

    //This helper function calculate the height of the tree
    private int heightOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int height;
        height = 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
        return height;
    }
}
