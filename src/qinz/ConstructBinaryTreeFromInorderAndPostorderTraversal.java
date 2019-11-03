package qinz;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(inorder, postorder);
    }

    public TreeNode constructTree(int[] inorder, int[] postorder) {
        if (postorder.length <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) break;
        }

        int[] newInOrderLeft = Arrays.copyOfRange(inorder,0, i);
        int[] newPostOrderLeft = Arrays.copyOfRange(postorder, 0, i);

        int[] newInOrderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        int[] newPostOrderRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);

        root.left = constructTree(newInOrderLeft, newPostOrderLeft);

        root.right = constructTree(newInOrderRight, newPostOrderRight);

        return root;
    }
}
