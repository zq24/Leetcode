package qinz;

public class PathSumIIISolution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int numOfPath = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        pathSumHelper(root, sum, 0, true);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return numOfPath;
    }

    private void pathSumHelper(TreeNode root, int sum, int cur, boolean continuous) {
        if (root == null) {
            return;
        }
        int currentSum = cur + root.val;
        if (currentSum == sum) {
            numOfPath += 1;
        }

        pathSumHelper(root.left, sum, currentSum, true);
        pathSumHelper(root.right, sum, currentSum, true);
    }
}
