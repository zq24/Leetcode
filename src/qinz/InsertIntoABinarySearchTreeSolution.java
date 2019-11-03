package qinz;

public class InsertIntoABinarySearchTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            TreeNode newRoot = new TreeNode(val);
            return newRoot;
        }
        if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if(root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
