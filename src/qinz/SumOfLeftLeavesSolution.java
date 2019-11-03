package qinz;

public class SumOfLeftLeavesSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int nodeSum = sumOfLeftLeavesHelper(root);
        return nodeSum;
    }

    private int sumOfLeftLeavesHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if(root.left == null && root.right == null) {
            sum += root.val;
        } else {
            if(root.right != null) {
                sum = sum + sumOfLeftLeavesHelper(root.left) + sumOfLeftLeavesHelper(root.right.left);
            }
        }
        return sum;
    }
}
