package qinz;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTreesSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> sequence1 = new ArrayList<>();
        List<Integer> sequence2 = new ArrayList<>();
        leafSimilar(root1, sequence1);
        leafSimilar(root2, sequence2);
        if (sequence1.size() != sequence2.size()) {
            return false;
        } else {
            for (int i = 0; i < sequence1.size(); i++) {
                if (sequence1.get(i) != sequence2.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    private void leafSimilar(TreeNode root, List<Integer> leafValue) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafValue.add(root.val);
            return;
        }
        leafSimilar(root.left, leafValue);
        leafSimilar(root.right, leafValue);
    }
}
