package qinz;

public class MiddleOfTheLinkedListSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode middleNode(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1.next != null) {
            p1 = p1.next;
            if(p1.next != null) {
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        return p2;
    }
}
