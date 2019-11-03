package qinz;

import java.util.ArrayList;
import java.util.List;

public class FlipEquivalentBinaryTreesSolution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        flipEquivHelper(root1, list1, 0);
        flipEquivHelper(root2, list2, 0);
        if (list1.size() != list2.size()) {
            return false;
        } else {
            for (int i = 1; i < list1.size(); i++) {
                if (list1.get(i).size() != list2.get(i).size()) {
                    return false;
                } else {
                    for (int j = 0; j < list1.get(i).size(); j++) {
                        if (list1.get(i).get(j).equals(list2.get(i).get(j))) {
                            if (!list1.get(i).get(j).equals(list2.get(i).get(j + 1))) {
                                return false;
                            } else {
                                j++;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static void flipEquivHelper(TreeNode root, List<List<Integer>> levelNum, int height) {
        if (height >= levelNum.size()) {
            levelNum.add(new ArrayList<>());
        }
        if (root == null) {
            levelNum.get(height).add(-1);
        } else {
            levelNum.get(height).add(root.val);
        }

        if (root != null && (root.left != null || root.right != null)) {
            flipEquivHelper(root.left, levelNum, height + 1);
            flipEquivHelper(root.right, levelNum, height + 1);
        }
    }*/

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null && root2 != null) {
            return false;
        }

        if (root1 != null && root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        //TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6;
        //n5.left = n7;
        n5.right = n8;

        TreeNode n11 = new TreeNode(1);
        TreeNode n21 = new TreeNode(2);
        TreeNode n31 = new TreeNode(3);
        TreeNode n41 = new TreeNode(4);
        TreeNode n51 = new TreeNode(5);
        TreeNode n61 = new TreeNode(6);
        //TreeNode n71 = new TreeNode(7);
        TreeNode n81 = new TreeNode(8);
        n11.left = n31; n11.right = n21;
        n31.right = n61;
        n21.left = n41; n21.right = n51;
        n51.left = n81;
        //n51.right = n71;

        //flipEquiv(n1, n11);
    }
}
