package qinz;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversalSolution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(res, root, 0);
        return res;
    }

    private void levelOrder(List<List<Integer>> res, Node root, int height) {
        if (root == null) {
            return;
        }

        if (height >= res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(height).add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            levelOrder(res, root.children.get(i), height + 1);
        }
    }
}
