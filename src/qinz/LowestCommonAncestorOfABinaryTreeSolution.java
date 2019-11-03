package qinz;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTreeSolution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        List<List<TreeNode>> resultP = new ArrayList<>();
        List<List<TreeNode>> resultQ = new ArrayList<>();
        lowestCommonAncestor(resultP, pathP, root, p.val);
        lowestCommonAncestor(resultQ, pathQ, root, q.val);
        int length = (resultP.get(0).size() <= resultQ.get(0).size()) ? resultP.get(0).size() : resultQ.get(0).size();
        for (int i = 0; i < length; i++) {
            if (resultP.get(0).get(i).val != resultQ.get(0).get(i).val) {
                return resultP.get(0).get(i - 1);
            }
        }
        return resultP.get(0).get(length - 1);
    }

    private static void lowestCommonAncestor(List<List<TreeNode>> res, List<TreeNode> path, TreeNode root, int target) {
        if (root == null) {
            return;
        }

        if (root.val == target) {
            path.add(root);
            List<TreeNode> result = new ArrayList<>(path);
            res.add(result);
            return;
        }

        path.add(root);
        lowestCommonAncestor(res, path, root.left, target);
        lowestCommonAncestor(res, path, root.right, target);
        path.remove(root);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);

        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n5.left = n8; n5.right = n9;
        n3.left = n6; n3.right = n7;

        lowestCommonAncestor(n1, n2, n9);
    }
}
