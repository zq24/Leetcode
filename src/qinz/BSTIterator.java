package qinz;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> list = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        treeNodeValue(root, list);
    }

    /** @return the next smallest number */
    public int next() {
        int remove = list.remove(0);
        return remove;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }

    private void treeNodeValue(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        treeNodeValue(root.left, result);
        result.add(root.val);
        treeNodeValue(root.right, result);
    }
}
