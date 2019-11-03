package qinz;

public class SubtreeOfAnotherTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            boolean isASubtree = isSubtreeHelper(s, t);
            if (isASubtree) {
                return true;
            } else {
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }

        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    private boolean isSubtreeHelper(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null && t != null) {
            return false;
        } else if (s != null && t == null) {
            return false;
        } else {
            if (s.val == t.val) {
                return isSubtreeHelper(s.left, t.left) && isSubtreeHelper(s.right, t.right);
            } else {
                return false;
            }
        }
    }
}
