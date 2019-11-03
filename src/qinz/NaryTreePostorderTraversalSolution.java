package qinz;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversalSolution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i), res);
        }
        res.add(root.val);
    }
}
