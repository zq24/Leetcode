package qinz;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        while(root != null) {
            ArrayList<Integer> newList = new ArrayList<>();
            root = findLeaves(root, newList);
            results.add(newList);
        }
        return results;
    }

    private TreeNode findLeaves(TreeNode root, List<Integer> leaves) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            leaves.add(root.val);
            return null;
        }else {
            root.left = findLeaves(root.left, leaves);
            root.right = findLeaves(root.right, leaves);
        }
        return root;
    }
}
