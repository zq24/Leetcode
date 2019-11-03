package qinz;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointerSolution {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    // have a map to record the mapping from the original linked list to the copied linked list
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node itr = head;
        Node newHead = new Node();
        newHead.val = head.val;
        map.put(head, newHead);
        Node itrCopy = newHead;
        newHead.next = copyRandomListHelper(itr.next);
        while (itr != null) {
            // get random pointer
            Node tempRandom = itr.random;
            itrCopy.random = map.get(tempRandom);
            itr = itr.next;
            itrCopy = itrCopy.next;
        }
        return newHead;
    }

    private Node copyRandomListHelper(Node itr) {
        if (itr == null) {
            return null;
        }
        Node newNode = new Node();
        newNode.val = itr.val;
        map.put(itr, newNode);
        newNode.next = copyRandomListHelper(itr.next);
        return newNode;
    }
}