package qinz;

public class MaximumAverageSubtreeSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    double maxAverage = Integer.MIN_VALUE;
    int numOfNodes = 0;

    public double maximumAverageSubtree(TreeNode root) {
        treeTraversal(root);
        return maxAverage;
    }

    private void treeTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        treeTraversal(root.left);
        numOfNodes = 0;
        int sum = maximumAverageSubtreeHelper(root);
        double average = (double)sum / numOfNodes;
        maxAverage = Math.max(maxAverage, average);
        treeTraversal(root.right);
    }

    private int maximumAverageSubtreeHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        numOfNodes += 1;
        return root.val + maximumAverageSubtreeHelper(root.left) +
                maximumAverageSubtreeHelper(root.right);
    }
}
