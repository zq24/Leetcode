package qinz;

public class OddEvenLinkedListSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        //The corner case
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode pointer = head.next;
        ListNode oddHead = head;
        while (oddHead != null) {
            oddHead.next = pointer.next;
            oddHead = oddHead.next;
            if(oddHead.next == null) {
                break;
            }
            pointer.next = oddHead.next;
            pointer = pointer.next;
        }
        oddHead.next = evenHead;
        return head;
    }
}
