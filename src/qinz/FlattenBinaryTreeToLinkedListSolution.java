package qinz;

public class FlattenBinaryTreeToLinkedListSolution {

    TreeNode endToStartNode = null;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        //The left and right are the sub-trees of this current "root"
        if(left == null && right == null) {
            return root;
        } else if (left == null && right != null ){
            return root;
        } else {
            root.left = null;
            root.right = left;
            while(left.right != null) {
                left = left.right;
            }
            left.right = right;
            return root;
        }
    }

}
