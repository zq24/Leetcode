package qinz;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycleSolution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    Map<ListNode, Integer> map = new HashMap<>();
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            if (!map.containsKey(temp)) {
                map.put(temp, temp.val);
            } else {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
