package qinz;

public class RemoveLinkedListElementsSolution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode itr = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode preItr = pre;
        while (itr != null) {
            if (itr.val == val) {
                preItr.next = itr.next;
            } else {
                preItr = itr;
            }
            itr = itr.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2; l2.next = l3;
        l3.next = l4; l4.next = l5;
        l5.next = l6; l6.next = l7;

        ListNode res = removeElements(l1, 6);
    }
}
