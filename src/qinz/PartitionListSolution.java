package qinz;

public class PartitionListSolution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode itr = head;
        ListNode firstPartHead = new ListNode(0);
        ListNode firstPartItr = firstPartHead;

        ListNode secondPartHead = new ListNode(0);
        ListNode secondPartItr = secondPartHead;

        while (itr != null) {
            if (itr.val < x) {
                ListNode temp = itr;
                firstPartItr.next = temp;
                firstPartItr = firstPartItr.next;
            } else {
                ListNode temp = itr;
                secondPartItr.next = temp;
                secondPartItr = secondPartItr.next;
            }
            itr = itr.next;
        }
        secondPartItr.next = null;
        firstPartItr.next = secondPartHead.next;
        return firstPartHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2; l2.next = l3;
        l3.next = l4; l4.next = l5;
        l5.next = l6;

    }
}
