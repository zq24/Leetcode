package qinz;

import java.util.Stack;

public class ReverseLinkedListIISolution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int start = 1;
        ListNode temp = head;
        if (m != 1) {
            while (start + 1 != m) {
                start += 1;
                temp = temp.next;
            }
        }

        ListNode itr = temp;
        ListNode starting = null;
        ListNode nextOfStarting = null;
        if (itr.next != null) {
            if (m == 1) {
                starting = itr;
                nextOfStarting = starting.next;
            } else {
                starting = itr.next;
                nextOfStarting = starting.next;
            }
        }
        int tempM = m, tempN = n;
        while (tempN - tempM != 0) {
            ListNode nextNode = changePosition(starting, nextOfStarting);
            starting = nextOfStarting;
            nextOfStarting = nextNode;
            tempM += 1;
        }

        if (m == 1) {
            itr.next = nextOfStarting;
            return starting;
        } else if (itr.next != null){
            itr.next.next = nextOfStarting;
            itr.next = starting;
        }
        return head;
    }

    private static ListNode changePosition(ListNode n1, ListNode n2) {
        ListNode next = n2.next;
        n2.next = n1;
        return next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = null;
        reverseBetween(n1, 1, 4);
    }
}
