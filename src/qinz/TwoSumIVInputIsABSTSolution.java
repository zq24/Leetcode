package qinz;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIVInputIsABSTSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, Integer> map = new HashMap<>();
    boolean exist = false;

    public boolean findTarget(TreeNode root, int k) {
        findTargetHelper(root, k);
        return exist;
    }

    private void findTargetHelper(TreeNode root, int k) {
        if (root == null || exist) {
            return;
        }
        findTarget(root.left, k);
        if (map.containsKey(k - root.val))
            exist = true;
        map.put(root.val, 1);
        findTarget(root.right, k);
    }
}
