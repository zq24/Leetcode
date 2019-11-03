package qinz;

public class ConstructBinarySearchTreeFromPreorderTraversalSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++) {
            bstFromPreorderHelper(root, preorder[i]);
        }
        return root;
    }

    private void bstFromPreorderHelper(TreeNode root, int nodeValue) {
        if(nodeValue < root.val) {
            if(root.left == null) {
                root.left = new TreeNode(nodeValue);
            } else {
                bstFromPreorderHelper(root.left, nodeValue);
            }
        } else {
            if(root.right == null) {
                root.right = new TreeNode(nodeValue);
            } else {
                bstFromPreorderHelper(root.right, nodeValue);
            }
        }
    }
}
