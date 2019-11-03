package qinz;

public class PathSumSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.right == null && root.left == null) {
            if(root.val == sum) {
                return true;
            } else {
                return false;
            }
        } else if(root.right != null && root.left == null) {
            return hasPathSum(root.right, sum, root.val);
        } else if(root.right == null && root.left != null) {
            return hasPathSum(root.left, sum, root.val);
        } else {
            return (hasPathSum(root.left, sum, root.val)) || (hasPathSum(root.right, sum, root.val));
        }
    }

    private boolean hasPathSum(TreeNode root, int sum, int current) {
        boolean hasPath = true;
        if(root == null) {
            if(current == sum) {
                return true;
            } else {
                return false;
            }
        }
        if(root.left == null && root.right == null) {
            if((current + root.val) == sum) {
                return true;
            } else {
                return false;
            }
        } else if(root.left != null && root.right == null) {
            int updateCurrent = current + root.val;
            hasPath = hasPath && hasPathSum(root.left, sum, updateCurrent);
        } else if(root.left == null && root.right != null) {
            int updateCurrent = current + root.val;
            hasPath = hasPath && hasPathSum(root.right, sum, updateCurrent);
        } else {
            int updateCurrent = current + root.val;
            hasPath = hasPath && (hasPathSum(root.right, sum, updateCurrent) || hasPathSum(root.left, sum, updateCurrent));
        }
        return hasPath;
    }
}
