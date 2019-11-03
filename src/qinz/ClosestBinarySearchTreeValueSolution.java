package qinz;

public class ClosestBinarySearchTreeValueSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    double difference = Double.MAX_VALUE;
    int closest = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        closestValueHelper(root, target);
        return closest;
    }

    private void closestValueHelper(TreeNode root, double target) {
        if (root == null) {
            return;
        }

        double diff = Math.abs(root.val - target);
        if (diff < difference) {
            difference = diff;
            closest = root.val;
        }
        closestValueHelper(root.left, target);
        closestValueHelper(root.right, target);
    }
}
