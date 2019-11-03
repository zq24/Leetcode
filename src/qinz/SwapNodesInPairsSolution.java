package qinz;

public class SwapNodesInPairsSolution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode temp = second.next;
        second.next = first;
        first.next = swapPairs(temp);

        return second;
    }
}
