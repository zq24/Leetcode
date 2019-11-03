package qinz;

import java.util.ArrayList;
import java.util.List;

public class PathSumIISolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return result;
        }
        if(root.right == null && root.left == null) {
            if(root.val == sum) {
                list.add(root.val);
                result.add(list);
                return result;
            } else {
                return result;
            }
        } else if(root.right != null && root.left == null) {
            list.add(root.val);
            pathSum(root.right, sum, root.val, result, list);
        } else if(root.right == null && root.left != null) {
            list.add(root.val);
            pathSum(root.left, sum, root.val, result, list);
        } else {
            list.add(root.val);
            List<Integer> newList = new ArrayList<>(list);
            pathSum(root.left, sum, root.val, result, list);
            pathSum(root.right, sum, root.val, result, newList);
        }
        return result;
    }

    private void pathSum(TreeNode root, int sum, int current, List<List<Integer>> res, List<Integer> currentList) {
        if(root == null) {
            if(current == sum) {
                res.add(currentList);
                return;
            } else {
                return;
            }
        }
        if(root.left == null && root.right == null) {
            if((current + root.val) == sum) {
                currentList.add(root.val);
                res.add(currentList);
                return;
            } else {
                return;
            }
        } else if(root.left != null && root.right == null) {
            int updateCurrent = current + root.val;
            currentList.add(root.val);
            pathSum(root.left, sum, updateCurrent, res, currentList);
        } else if(root.left == null && root.right != null) {
            int updateCurrent = current + root.val;
            currentList.add(root.val);
            pathSum(root.right, sum, updateCurrent, res, currentList);
        } else {
            int updateCurrent = current + root.val;
            currentList.add(root.val);
            List<Integer> newList = new ArrayList<>(currentList);
            pathSum(root.left, sum, updateCurrent, res, currentList);
            pathSum(root.right, sum, updateCurrent, res, newList);
        }
    }
}
