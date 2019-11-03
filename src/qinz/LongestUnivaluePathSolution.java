package qinz;

public class LongestUnivaluePathSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int longest = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestUnivaluePath(root, root.val);
        return longest;
    }

    private int longestUnivaluePath(TreeNode root, int parentValue) {
        if (root == null) {
            return 0;
        }

        int left = longestUnivaluePath(root.left, root.val);
        int right = longestUnivaluePath(root.right, root.val);
        longest = Math.max(longest, left + right);

        if (root.val == parentValue) {
            return Math.max(left + 1, right + 1);
        }
        return 0;
    }
}
