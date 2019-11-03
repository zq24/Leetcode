package qinz;

import java.util.*;

public class FindDuplicateSubtreesSolution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, TreeNode> treeStructure = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        findDuplicateSubtrees(root, treeStructure, times, res);
        return res;
    }

    private void findDuplicateSubtrees(TreeNode root, Map<String, TreeNode> treeStructure,
                                       Map<String, Integer> times, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        String traverse = checkTree(root);
        if (!treeStructure.containsKey(traverse)) {
            treeStructure.put(traverse, root);
            times.put(traverse, 1);
        } else {
            if (times.get(traverse) == 1) {
                res.add(treeStructure.get(traverse));
                times.put(traverse, times.get(traverse) + 1);
            } else {
                times.put(traverse, times.get(traverse) + 1);
            }
        }
        findDuplicateSubtrees(root.left, treeStructure, times, res);
        findDuplicateSubtrees(root.right, treeStructure, times, res);
    }

    private String checkTree(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = checkTree(root.left);
        String right = checkTree(root.right);
        return root.val + left + right;
    }

    /*public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2; n1.right = n3;
        n2.left = n4;
        n3.left = n5; n3.right = n6;
        n5.left = n7;
        findDuplicateSubtrees(n1);
    }*/
}
