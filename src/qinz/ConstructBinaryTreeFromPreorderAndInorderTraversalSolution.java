package qinz;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, inorder);
    }

    private TreeNode constructTree(int[] preorder, int[] inorder) {

        if(preorder.length <= 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);

        int index;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == preorder[0]) break;
        }

        int[] newPreOrderLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] newInOrderLeft = Arrays.copyOfRange(inorder, 0, index);

        int[] newPreOrderRight = Arrays.copyOfRange(preorder, index + 1, inorder.length);
        int[] newInOrderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        root.left = constructTree(newPreOrderLeft, newInOrderLeft);

        root.right = constructTree(newPreOrderRight, newInOrderRight);

        return root;
    }
}
