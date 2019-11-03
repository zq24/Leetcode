package qinz;

public class BinaryTreeColoringGameSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int[] arr;
    int leftChildOfFirstPlayer = 0;
    int rightChildOfFirstPlayer = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // create an array to record the number of node a subtree has(include itself)
        arr = new int[n];
        traverseTree(root, x);
        int totalNumOfNodes = arr[root.val - 1];
        int numOfNodesFirstPlayer = arr[x - 1];
        int remain = totalNumOfNodes - numOfNodesFirstPlayer;
        if (remain > numOfNodesFirstPlayer) {
            return true;
        } else {
            int leftChildOfX = (leftChildOfFirstPlayer == 0) ? 0 : arr[leftChildOfFirstPlayer - 1];
            int rightChildOfX = (rightChildOfFirstPlayer == 0) ? 0 : arr[rightChildOfFirstPlayer - 1];
            if (leftChildOfX > totalNumOfNodes - leftChildOfX || rightChildOfX > totalNumOfNodes - rightChildOfX) {
                return true;
            }
        }
        return false;
    }

    private void traverseTree(TreeNode root, int x) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            if (root.left != null) {
                leftChildOfFirstPlayer = root.left.val;
            }
            if (root.right != null) {
                rightChildOfFirstPlayer = root.right.val;
            }
        }

        // calculated how many nodes this subtree has
        int nodes = numOfNodesInSubtree(root);
        arr[root.val - 1] = nodes;
        traverseTree(root.left, x);
        traverseTree(root.right, x);
    }

    private int numOfNodesInSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + numOfNodesInSubtree(root.left) + numOfNodesInSubtree(root.right);
    }
}
