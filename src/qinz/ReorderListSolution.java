package qinz;

import java.util.HashMap;
import java.util.Map;

public class ReorderListSolution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode temp = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (temp != null) {
            map.put(index, temp);
            index += 1;
            temp = temp.next;
        }
        int endIndex = map.size() - 1;
        int startIndex = 1;
        ListNode itr = head;
        boolean flag = true;
        map.remove(0);
        while (map.size() != 0) {
            if (flag) {
                itr.next = map.get(endIndex);
                map.remove(endIndex);
                endIndex -= 1;
                itr = itr.next;
                flag = false;
            } else {
                itr.next = map.get(startIndex);
                map.remove(startIndex);
                startIndex += 1;
                itr = itr.next;
                flag = true;
            }
        }
        itr.next = null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2; n2.next = n3; n3.next = n4;
        reorderList(n1);
    }
}
