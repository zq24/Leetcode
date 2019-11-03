package qinz;

public class LargestBSTSubtreeSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int largest = Integer.MIN_VALUE;
    int nodes = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        largestBSTSubtreeHelper(root);
        return largest;
    }

    private void largestBSTSubtreeHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        nodes = 0;
        if (largestBSTSubtreeHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            largest = Math.max(largest, nodes);
        }
        largestBSTSubtreeHelper(root.left);
        largestBSTSubtreeHelper(root.right);
    }

    private boolean largestBSTSubtreeHelper(TreeNode root, int lo, int hi) {
        if (root == null) {
            return true;
        }

        nodes += 1;

        if (root.val <= lo || root.val >= hi) {
            return false;
        } else {
            return largestBSTSubtreeHelper(root.left, lo, root.val) &&
                    largestBSTSubtreeHelper(root.right, root.val, hi);
        }
    }
}
