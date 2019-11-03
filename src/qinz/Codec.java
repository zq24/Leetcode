package qinz;

public class Codec {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split("\\s+");
        //int rightPos = 0;
        String rootValInString = nodes[0];
        int length = rootValInString.length() + 1;
        if (rootValInString.equals("null")) {
            return null;
        }
        int rootVal = Integer.parseInt(rootValInString);
        TreeNode root = new TreeNode(rootVal);
        if (nodes[1].equals("null") && nodes[2].equals("null")) {
            return root;
        }
        root.left = deserialize(data.substring(length));
        if (nodes[1].equals("null") && !nodes[2].equals("null")) {
            int subStringIndex = nodes[0].length() + 1 + nodes[1].length() + 1;
            root.right = deserialize(data.substring(subStringIndex));
        } else {
            int subStringIndex = 0;
            for (int i = 0; i < nodes.length - 1; i++) {
                subStringIndex += nodes[i].length() + 1;
                if (nodes[i].equals("null") && nodes[i + 1].equals("null")) {
                    subStringIndex += nodes[i + 1].length() + 1;
                    break;
                }
            }
            root.right = deserialize(data.substring(subStringIndex));
        }
        return root;
    }

    public static void main(String[] args) {
        /*TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2; n1.right = n3;
        n3.left = n4; n3.right = n5;*/
        /*TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.right = n2;*/
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        System.out.println(serialize(n1));
        TreeNode result = deserialize(serialize(n1));
    }
}
