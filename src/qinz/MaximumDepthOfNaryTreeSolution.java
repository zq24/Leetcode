package qinz;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthOfNaryTreeSolution {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int height = 1;
        for (int i = 0; i < root.children.size(); i++) {
            height = Math.max(height, 1 + maxDepth(root.children.get(i)));
        }
        return height;
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        List<Node> childrenOfNodeOne = new ArrayList<>();
        childrenOfNodeOne.add(n3);
        childrenOfNodeOne.add(n2);
        childrenOfNodeOne.add(n4);
        List<Node> childrenOfNodeThree = new ArrayList<>();
        childrenOfNodeThree.add(n5);
        childrenOfNodeThree.add(n6);
        n1.children = childrenOfNodeOne;
        n2.children = new ArrayList<>();
        n4.children = new ArrayList<>();
        n5.children = new ArrayList<>();
        n6.children = new ArrayList<>();
        n3.children = childrenOfNodeThree;
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        n5.val = 5;
        n6.val = 6;

        System.out.println(maxDepth(n1));
    }
}
