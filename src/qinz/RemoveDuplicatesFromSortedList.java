package qinz;

import java.util.*;

public class RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        /*Set<Integer> set = new HashSet<>();
        ListNode pointer = head;
        while(pointer != null) {
            set.add(pointer.val);
            pointer = pointer.next;
        }
        ListNode result = null;
        Iterator<Integer> iterator = set.iterator();
        if(iterator.hasNext())
            result = new ListNode(iterator.next());
        ListNode temp = result;
        while(iterator.hasNext()) {
            temp.next = new ListNode(iterator.next());
            temp = temp.next;
        }
        return result;*/

        ListNode pointer = head;
        while (pointer != null) {
            if(pointer.next == null) {
                break;
            }
            if(pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return head;
    }
}
