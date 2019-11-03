package qinz;

public class SearchInABinarySearchTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode subTree;
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        } else if(root.val < val) {
            subTree = searchBST(root.right, val);
        } else {
            subTree = searchBST(root.left, val);
        }
        return subTree;
    }
}
