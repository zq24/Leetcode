package qinz;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversalSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrderHelper(root, res, 0);
        return res;
    }

    public void zigzagLevelOrderHelper(TreeNode root, List<List<Integer>> list, int height) {
        if (root == null) {
            return;
        }

        if (height >= list.size()) {
            list.add(new ArrayList<>());
        }
        if (height % 2 == 0) {
            list.get(height).add(root.val);
        } else {
            list.get(height).add(0, root.val);
        }
        zigzagLevelOrderHelper(root.left, list, height + 1);
        zigzagLevelOrderHelper(root.right, list, height + 1);

        /*if (height % 2 == 0) {
            zigzagLevelOrderHelper(root.left, list, height + 1);
            zigzagLevelOrderHelper(root.right, list, height + 1);
        } else {
            zigzagLevelOrderHelper(root.right, list, height + 1);
            zigzagLevelOrderHelper(root.left, list, height + 1);
        }*/
    }
}
