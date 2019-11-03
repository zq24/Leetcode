package qinz;

import java.util.Stack;

public class ConstructBinaryTreeFromStringSolution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode str2tree(String s) {
        if (s.equals("")) {
            return null;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        StringBuilder node = new StringBuilder();
        TreeNode currentRoot = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                int valueLength = searchNodeValue(node, s, i);
                TreeNode root = new TreeNode(Integer.parseInt(node.toString()));
                node.delete(0, node.length());
                if (currentRoot != null) {
                    if (currentRoot.left == null) {
                        currentRoot.left = root;
                    } else {
                        currentRoot.right = root;
                    }
                }
                treeNodes.push(currentRoot);
                treeNodes.push(root);
                i = i + valueLength - 1;
            } else if (Character.isDigit(s.charAt(i))) {
                int valueLength = searchNodeValue(node, s, i);
                TreeNode root = new TreeNode(Integer.parseInt(node.toString()));
                node.delete(0, node.length());
                if (currentRoot != null) {
                    if (currentRoot.left == null) {
                        currentRoot.left = root;
                    } else {
                        currentRoot.right = root;
                    }
                }
                treeNodes.push(currentRoot);
                treeNodes.push(root);
                i = i + valueLength - 1;
            } else if (s.charAt(i) == '(') {
                currentRoot = treeNodes.pop();
            } else if (s.charAt(i) == ')') {
                treeNodes.pop();
            }
        }
        return treeNodes.pop();
    }

    private static int searchNodeValue(StringBuilder nodeValue, String s, int start) {
        int temp = start;
        while (temp < s.length() && (s.charAt(temp) == '-' || Character.isDigit(s.charAt(temp)))) {
            nodeValue.append(s.charAt(temp));
            temp += 1;
        }
        return temp - start;
    }

    public static void main(String[] args) {
        str2tree("4");
    }
}
