package qinz;

public class BinarySearchTreeToGreaterSumTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*public TreeNode bstToGst(TreeNode root) {
        if(root == null)
            return null;
        bstToGstHelper(root);
        return root;
    }

    private int bstToGstHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int nodeValueRight = bstToGstHelper(root.right);
        root.val = root.val + nodeValueRight;
        int nodeValueLeft = bstToGstHelper(root.left, root.val);
        return nodeValueLeft;
    }

    private int bstToGstHelper(TreeNode root, int parent) {
        if(root == null)
            return 0;
        root.val = root.val + parent;
        return root.val;
    }*/

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if(root == null)
            return null;
        bstToGstHelper(root);
        return root;
    }

    private int bstToGstHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int nodeValueRight = bstToGstHelper(root.right);
        root.val = root.val + nodeValueRight + sum;
        sum = root.val;
        int nodeValueLeft = bstToGstHelper(root.left);
        return nodeValueLeft;
    }
}
