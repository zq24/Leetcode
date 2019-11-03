package qinz;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathsSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        binaryTreePaths(root, res, 0);
        return res;
    }

    private void binaryTreePaths(TreeNode root, List<String> res, int branch) {
        if(root == null) {
            return;
        }

        if(root.left != null && root.right != null) {
            if(res.size() == 0) {
                res.add(Integer.toString(root.val));
                binaryTreePaths(root.left, res, branch);
                res.add(Integer.toString(root.val));
                binaryTreePaths(root.right, res, res.size());
            } else {
                String changeString = res.get(branch);
                changeString += "->" + root.val;
                res.set(branch, changeString);
                binaryTreePaths(root.left, res, branch);
                res.add(changeString);
                binaryTreePaths(root.right, res, res.size());
            }
        } else if(root.left != null && root.right == null) {
            if(res.size() == 0) {
                res.add(Integer.toString(root.val));
                binaryTreePaths(root.left, res, branch);
            } else {
                String changeString = res.get(branch);
                changeString += "->" + root.val;
                res.set(branch, changeString);
                binaryTreePaths(root.left, res, branch);
            }
        } else if(root.left == null && root.right != null) {
            if(res.size() == 0) {
                res.add(Integer.toString(root.val));
                binaryTreePaths(root.right, res, branch);
            } else {
                String changeString = res.get(branch);
                changeString += "->" + root.val;
                res.set(branch, changeString);
                binaryTreePaths(root.right, res, branch);
            }
        } else {
            if(res.size() == 0) {
                res.add(Integer.toString(root.val));
            } else {
                String changeString = res.get(branch);
                changeString += "->" + root.val;
                res.set(branch, changeString);
            }
        }
    }
}
