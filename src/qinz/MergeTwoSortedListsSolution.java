package qinz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeTwoSortedListsSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        ListNode p1= l1;
        ListNode p2 = l2;
        while(p1 != null) {
            list.add(p1.val);
            p1 = p1.next;
        }
        while(p2 != null) {
            list.add(p2.val);
            p2 = p2.next;
        }
        list = list.stream().sorted().collect(Collectors.toList());
        if(list.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        ListNode pointer = head;
        for(int i = 1; i < list.size(); i++) {
            pointer.next = new ListNode(list.get(i));
            pointer = pointer.next;
        }
        return head;
    }
}
