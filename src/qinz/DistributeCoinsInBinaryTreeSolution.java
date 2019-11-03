package qinz;

public class DistributeCoinsInBinaryTreeSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int numOfMoves = 0;

    public int distributeCoins(TreeNode root) {
        distributeCoinsHelper(root);
        return numOfMoves;
    }

    private int distributeCoinsHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = distributeCoinsHelper(root.left);
        int right = distributeCoinsHelper(root.right);
        numOfMoves += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
