package qinz;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIISolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //calculate the height of the tree first
        int height = heightOfTree(root);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            List<Integer> newLevel = new ArrayList<>();
            res.add(newLevel);
        }
        levelOrderBottom(res, root, height - 1);
        return res;
    }

    private void levelOrderBottom(List<List<Integer>> result, TreeNode root, int height) {
        if(root == null)
            return;
        result.get(height).add(root.val);
        levelOrderBottom(result, root.left, height - 1);
        levelOrderBottom(result, root.right, height - 1);
    }

    private int heightOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int height;
        height = 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
        return height;
    }
}
