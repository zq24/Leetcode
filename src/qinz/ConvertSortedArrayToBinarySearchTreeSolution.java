package qinz;

public class ConvertSortedArrayToBinarySearchTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(mid);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }*/
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        sortedArrayToBST(nums, 0, mid - 1, mid + 1, nums.length - 1, root);
        return root;
    }

    private void sortedArrayToBST(int[] nums, int lowLeft, int highLeft,
                                  int lowRight, int highRight, TreeNode root) {
        if(lowLeft > highLeft)
            return;
        if(lowRight > highRight)
            return;
        int left = (highLeft + lowLeft) / 2;
        int right = (highRight + lowRight) / 2;

        root.left = new TreeNode(nums[left]);
        root.right = new TreeNode(nums[right]);


        sortedArrayToBST(nums, lowLeft, left - 1, left + 1, highLeft, root.left);
        sortedArrayToBST(nums, lowRight, right - 1, right + 1, highRight, root.right);
    }
}
