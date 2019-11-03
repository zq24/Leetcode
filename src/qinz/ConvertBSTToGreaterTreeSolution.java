package qinz;

public class ConvertBSTToGreaterTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convertBSTHelper(root);
        return root;
    }

    private void convertBSTHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST(root.right);
        int temp = root.val;
        root.val += sum;
        sum += temp;
        convertBST(root.left);
    }
}
