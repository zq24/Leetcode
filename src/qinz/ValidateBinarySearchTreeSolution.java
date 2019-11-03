package qinz;

public class ValidateBinarySearchTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*int compare = Integer.MIN_VALUE;
    boolean valid = true;
    int sameValue = 0;

    public boolean isValidBST(TreeNode root) {
        isValidBSTHelper(root);
        return valid;
    }

    public void isValidBSTHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        isValidBST(root.left);
        if (!valid)
            return;
        if (root.val > compare || (root.val == Integer.MIN_VALUE && sameValue == 0)) {
            compare = root.val;
            sameValue += 1;
        } else {
            valid = false;
        }
        isValidBST(root.right);
    }*/
}
