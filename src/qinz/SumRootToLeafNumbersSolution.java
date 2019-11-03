package qinz;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbersSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        sumNumbers(root, new StringBuilder(), res);
        int sum = 0;
        for (int i = 0; i < res.size(); i++) {
            sum += res.get(i);
        }
        return sum;
    }

    public void sumNumbers(TreeNode root, StringBuilder cur, List<Integer> nums) {
        if (root.left == null && root.right == null) {
            cur.append(root.val);
            nums.add(Integer.parseInt(cur.toString()));
            return;
        }
        cur.append(root.val);
        if (root.left != null && root.right == null) {
            StringBuilder possible = new StringBuilder(cur);
            sumNumbers(root.left, possible, nums);
        } else if (root.left == null && root.right != null) {
            StringBuilder possible = new StringBuilder(cur);
            sumNumbers(root.right, possible, nums);
        } else {
            StringBuilder possible1 = new StringBuilder(cur);
            StringBuilder possible2 = new StringBuilder(cur);
            sumNumbers(root.left, possible1, nums);
            sumNumbers(root.right, possible2, nums);
        }
    }
}
