package qinz;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthNodeFromEndOfListSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    Map<Integer, ListNode> map = new HashMap<>();
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode temp = head;
        int index = 1;
        while (temp != null) {
            map.put(index, temp);
            index += 1;
            temp = temp.next;
        }
        int size = map.size();
        int before = size - n;
        int after = before + 2;
        ListNode l1 = map.get(before);
        ListNode l2 = map.get(after);
        if (before == 0) {
            return l2;
        }
        l1.next = l2;
        return head;
    }
}
