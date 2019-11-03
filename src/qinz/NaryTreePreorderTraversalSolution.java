package qinz;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversalSolution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(Node root, List<Integer> traversal) {
        if (root == null) {
            return;
        }
        traversal.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i), traversal);
        }
    }
}
