package qinz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversalSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int leftMost = 0;
    int rightMost = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // calculate how many columns left from the root
        numOfColumns(root, 0);
        int totalColumns = 1 + Math.abs(leftMost) + rightMost;
        for (int i = 0; i < totalColumns; i++) {
            result.add(new ArrayList<>());
        }

        // use the bfs to make sure the sequence of traversal is from top to bottom
        // initialize the queue
        // need another queue to keep track of which column the current node belongs to
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> columnNum = new LinkedList<>();
        queue.add(root);
        columnNum.add(Math.abs(leftMost));
        if (root == null) {
            return new ArrayList<>();
        }
        verticalOrderHelper(result, columnNum, queue);
        return result;
    }

    private void numOfColumns(TreeNode root, int current) {
        if (root == null) {
            return;
        }
        leftMost = (current < leftMost) ? current : leftMost;
        rightMost = (current > rightMost) ? current : rightMost;
        numOfColumns(root.left, current - 1);
        numOfColumns(root.right, current + 1);
    }

    // use the bfs to make sure the sequence of traversal is from top to bottom
    private void verticalOrderHelper(List<List<Integer>> result, Queue<Integer> columnNum, Queue<TreeNode> queue) {
        if (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int column = columnNum.poll();
            result.get(column).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                columnNum.add(column - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                columnNum.add(column + 1);
            }
        }
        verticalOrderHelper(result, columnNum, queue);
    }
}
