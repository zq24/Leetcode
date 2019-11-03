package qinz;

public class HouseRobberIIISolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int skipCurrent = rob(root.left) + rob(root.right);

        int robNext = 0;
        if (root.left != null) {
            robNext += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            robNext += rob(root.right.left) + rob(root.right.right);
        }
        int robCurrent = root.val + robNext;
        return Math.max(skipCurrent, robCurrent);
    }


}
