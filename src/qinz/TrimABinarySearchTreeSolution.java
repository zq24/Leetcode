package qinz;

public class TrimABinarySearchTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) {
            return null;
        }
        if(root.val < L) {
            root = root.right;
            root = trimBST(root, L, R);
        } else if(root.val > R) {
            root = root.left;
            root = trimBST(root, L, R);
        } else {
            root.right = trimBST(root.right, L, R);
            root.left = trimBST(root.left, L, R);
        }
        return root;
    }
}
