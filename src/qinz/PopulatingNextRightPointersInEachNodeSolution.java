package qinz;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeSolution {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        List<List<Node>> res = new ArrayList<>();
        connectHelper(root, res, 0);
        for (int i = 0; i < res.size(); i++) {
            int size = res.get(i).size();
            for (int j = 0; j < size; j++) {
                if (j == size - 1) {
                    res.get(i).get(j).next = null;
                } else {
                    res.get(i).get(j).next = res.get(i).get(j + 1);
                }
            }
        }
        return root;
    }

    private void connectHelper(Node root, List<List<Node>> res, int height) {
        if (root == null) {
            return;
        }
        if(height >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root);
        connectHelper(root.left, res, height + 1);
        connectHelper(root.right, res, height + 1);
    }
}
