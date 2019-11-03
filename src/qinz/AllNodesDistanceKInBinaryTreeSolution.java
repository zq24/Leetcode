package qinz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllNodesDistanceKInBinaryTreeSolution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // create another class structure to store the parent info
    public static class TreeParentNode {
        int val;
        TreeParentNode parent;
        TreeParentNode left;
        TreeParentNode right;
        int dist = 0;
        boolean visited = false;
        TreeParentNode(int x) {
            val = x;
        }
    }

    static TreeParentNode targetNode = null;

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        TreeParentNode newRoot = new TreeParentNode(root.val);
        targetNode = newRoot;
        newRoot.parent = null;
        newRoot.left = buildTree(newRoot, root.left, target.val);
        newRoot.right = buildTree(newRoot, root.right, target.val);
        List<Integer> result = new ArrayList<>();
        if (K == 0) {
            result.add(target.val);
            return result;
        }

        // using bfs to find the right nodes
        // initialize the queue
        Queue<TreeParentNode> queue = new LinkedList<>();
        // add the starting point into the queue
        queue.add(targetNode);
        while (!queue.isEmpty()) {
            TreeParentNode node = queue.poll();
            // mark as visited
            node.visited = true;
            if (node.dist > K) {
                break;
            }
            if (node.left != null && !node.left.visited) {
                node.left.dist = node.dist + 1;
                queue.add(node.left);
                if (node.left.dist == K) {
                    result.add(node.left.val);
                }
            }
            if (node.right != null && !node.right.visited) {
                node.right.dist = node.dist + 1;
                queue.add(node.right);
                if (node.right.dist == K) {
                    result.add(node.right.val);
                }
            }
            if (node.parent != null && !node.parent.visited) {
                node.parent.dist = node.dist + 1;
                queue.add(node.parent);
                if (node.parent.dist == K) {
                    result.add(node.parent.val);
                }
            }
        }
        return result;
    }

    // build the tree using the TreeParentNode
    private static TreeParentNode buildTree(TreeParentNode parent, TreeNode root, int targetValue) {
        if (root == null) {
            return null;
        }
        TreeParentNode node = new TreeParentNode(root.val);
        if (root.val == targetValue) {
            targetNode = node;
        }
        node.parent = parent;
        node.left = buildTree(node, root.left, targetValue);
        node.right = buildTree(node, root.right, targetValue);
        return node;
    }

    public static void main(String[] args) {
        /*TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;*/
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        System.out.println(distanceK(node1, node1, 2));
    }
}
