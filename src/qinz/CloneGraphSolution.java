package qinz;

import java.util.ArrayList;
import java.util.List;

public class CloneGraphSolution {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        List<Node> neighList = new ArrayList<>();
        Node newNode = new Node(node.val, neighList);
        for (int i = 0; i < node.neighbors.size(); i++) {
            List<Node> neigh = new ArrayList<>();
            Node neighbor = new Node(node.neighbors.get(i).val, neigh);
        }
        return null;
    }
}
