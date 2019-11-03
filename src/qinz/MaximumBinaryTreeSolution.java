package qinz;

import java.util.Arrays;

public class MaximumBinaryTreeSolution {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //base case
        if(nums == null) {
            return null;
        }

        if(nums.length == 1) {
            TreeNode root = new TreeNode(nums[0]);
            return root;
        }

        int max = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);

        int left[] = null;
        if(index != 0) {
            left = Arrays.copyOf(nums, index);
        }
        int right[] = null;
        if(index != nums.length - 1) {
            right = Arrays.copyOfRange(nums, index + 1, nums.length);
        }

        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;
    }
}
