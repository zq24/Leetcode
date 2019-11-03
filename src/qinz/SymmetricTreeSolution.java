package qinz;

public class SymmetricTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(root.left != null && root.right == null) {
            return false;
        }

        if(root.left == null && root.right != null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        boolean result;
        result = (root.left.val == root.right.val) && isSymmetric(root.left, root.right);
        return result;
    }

    private boolean isSymmetric(TreeNode n1, TreeNode n2) {

        if(n1 == null && n2 == null) {
            return true;
        }

        if(n1 != null && n2 == null) {
            return false;
        }

        if(n1 == null && n2 != null) {
            return false;
        }

        boolean result;
        if(n1.left != null && n1.right != null && n2.left != null && n2.right != null) {
            if (n1.left.val == n2.right.val && n1.right.val == n2.left.val) {
                result = true && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
            } else {
                result = false;
            }
        } else if(n1.left == null && n1.right == null && n2.left == null && n2.right == null){
            result = true;
        } else if(n1.left != null && n1.right == null && n2.left == null && n2.right != null) {
            if (n1.left.val == n2.right.val) {
                result = true && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
            } else {
                result = false;
            }
        } else if(n1.left == null && n1.right != null && n2.left != null && n2.right == null) {
            if (n1.right.val == n2.left.val) {
                result = true && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
            } else {
                result = false;
            }
        } else {
            return false;
        }
        return result;
    }
}
