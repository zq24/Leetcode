package qinz;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTreeSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // separate this problem into three parts: left, leaf, right
        List<Integer> result = new ArrayList<>();
        leftBoundary(root.left, result);
        leafBoundary(root, result);
        rightBoundary(root.right, result);
        return result;
    }

    private void leftBoundary(TreeNode root, List<Integer> left) {
        if (root == null) {
            return;
        }

        // although it is on the left boundary, but is counted as a leaf node.
        if (root.left == null && root.right == null) {
            return;
        }
        left.add(root.val);
        leftBoundary(root.left, left);
    }

    private void leafBoundary(TreeNode root, List<Integer> leaf) {
        if (root == null) {
            return;
        }

        if (root.right == null && root.left == null) {
            leaf.add(root.val);
        }
        leafBoundary(root.left, leaf);
        leafBoundary(root.right, leaf);
    }

    private void rightBoundary(TreeNode root, List<Integer> right) {
        if (root == null) {
            return;
        }

        // although it is on the left boundary, but is counted as a leaf node.
        if (root.left == null && root.right == null) {
            return;
        }
        right.add(0, root.val);
        rightBoundary(root.right, right);
    }

}
