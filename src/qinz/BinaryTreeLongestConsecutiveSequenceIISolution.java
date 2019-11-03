package qinz;

public class BinaryTreeLongestConsecutiveSequenceIISolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int longest = Integer.MIN_VALUE;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestConsecutiveHelper(root);
        return longest;
    }

    private void longestConsecutiveHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        int sequenceLength = 1 + Math.max(longestConsecutive(root.left, root.val, true) +
                longestConsecutive(root.right, root.val, false),
                longestConsecutive(root.left, root.val, false) +
                longestConsecutive(root.right, root.val, true));
        longest = Math.max(longest, sequenceLength);
        longestConsecutiveHelper(root.left);
        longestConsecutiveHelper(root.right);
    }

    private int longestConsecutive(TreeNode root, int prev, boolean increaseOrDecrease) {
        if (root == null) {
            return 0;
        }

        if (increaseOrDecrease) {
            if (root.val == prev - 1) {
                return 1 + Math.max(longestConsecutive(root.left, root.val, increaseOrDecrease),
                        longestConsecutive(root.right, root.val, increaseOrDecrease));
            } else {
                return 0;
            }
        } else {
            if (root.val == prev + 1) {
                return 1 + Math.max(longestConsecutive(root.left, root.val, increaseOrDecrease),
                        longestConsecutive(root.right, root.val, increaseOrDecrease));
            } else {
                return 0;
            }
        }
    }
}
