package qinz;

public class PlusOneLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode plusOne(ListNode head) {
        boolean carry = false;
        int digit = 0;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            digit++;
        }
        temp.val++;
        if(temp.val > 9) {
            temp.val = 0;
            carry = true;
        }
        while (carry) {
            if(digit - 1 < 0) {
                ListNode newHead = new ListNode(1);
                newHead.next = head;
                return newHead;
            }
            ListNode tempNode = head;
            for(int i = 0; i < digit - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.val++;
            if(tempNode.val > 9) {
                digit--;
                tempNode.val = 0;
            } else {
                carry = false;
            }
        }
        return head;
    }
}
