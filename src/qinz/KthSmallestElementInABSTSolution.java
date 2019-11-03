package qinz;

public class KthSmallestElementInABSTSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int kthSmallestIndex = 0;
    int kthSmallestValue = 0;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return kthSmallestValue;
    }

    private void kthSmallestHelper(TreeNode root, int k) {
        if (root == null)
            return;
        kthSmallestHelper(root.left, k);
        kthSmallestIndex += 1;
        if (kthSmallestIndex == k) {
            kthSmallestValue = root.val;

        }
        kthSmallestHelper(root.right, k);
    }
}
