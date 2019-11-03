package qinz;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTreesSolution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) {
            return res;
        }
        TreeNode root = new TreeNode(0);
        return null;
    }

    private static void allPossibleFBT(int N, List<TreeNode> result, TreeNode root, TreeNode entireTree) {

        if (root == null) {
            return;
        }

        if (N == 0) {
            result.add(root);
            return;
        }

        TreeNode newRoot = new TreeNode(0);

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                root.left = new TreeNode(0);
                root.right = new TreeNode(0);
            }
        }
    }

    private static void copyTree(TreeNode original, TreeNode newTree) {
        if (original == null) {
            return;
        }

        if (original.left != null) {
            newTree.left = new TreeNode(0);
        }

        if (original.right != null) {
            newTree.right = new TreeNode(0);
        }

        copyTree(original.left, newTree.left);
        copyTree(original.right, newTree.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(0);
        n1.left = n2; n1.right = n3;
        n3.left = n4; n3.right = n5;
        n5.left = n6; n5.right = n7;

        TreeNode newRoot = new TreeNode(0);
        copyTree(n1, newRoot);
    }
}
