package qinz;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructTree(pre, post);
    }

    private TreeNode constructTree(int[] pre, int[] post) {
        if (pre.length <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        int i;
        for (i = 0; i < post.length; i++) {
            if (pre.length > 1) {
                if (post[i] == pre[1]) {
                    break;
                }
            } else {
                return root;
            }
        }

        int[] newPreOrderLeft = Arrays.copyOfRange(pre, 1, 1 + i + 1);
        int[] newPostOrderLeft = Arrays.copyOfRange(post, 0, i + 1);

        int[] newPreOrderRight = Arrays.copyOfRange(pre, 2 + i, pre.length);
        int[] newPostOrderRight = Arrays.copyOfRange(post, i + 1, post.length - 1);

        root.left = constructTree(newPreOrderLeft, newPostOrderLeft);
        root.right = constructTree(newPreOrderRight, newPostOrderRight);

        return root;
    }
}
