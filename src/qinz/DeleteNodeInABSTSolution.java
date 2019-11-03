package qinz;

public class DeleteNodeInABSTSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNodeHelper(root, key);
    }

    private TreeNode deleteNodeHelper(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNodeHelper(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNodeHelper(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else {
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = root.right;
                return root.left;
            }
        }

        return root;
    }
}
