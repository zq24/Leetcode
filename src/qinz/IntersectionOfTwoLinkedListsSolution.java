package qinz;

import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoLinkedListsSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            map.put(tempA, 1);
            tempA = tempA.next;
        }
        while (tempB != null && !map.containsKey(tempB)) {
            tempB = tempB.next;
        }
        return tempB;
    }
}
