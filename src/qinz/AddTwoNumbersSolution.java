package qinz;

public class AddTwoNumbersSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = addTwoNumbers(l1, l2, 0);
        return result;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        ListNode sumNode;
        if(l1 == null && l2 == null) {
            if(carry == 1) {
                sumNode = new ListNode(1);
            } else {
                sumNode = null;
            }
            return sumNode;
        }
        //ListNode sum;
        int carryBit = 0;
        if(l1 != null && l2 != null) {
            sumNode = new ListNode(l1.val + l2.val + carry);
            if(sumNode.val > 9) {
                sumNode.val -= 10;
                carryBit = 1;
            }
            sumNode.next = addTwoNumbers(l1.next, l2.next, carryBit);
        } else if(l1 != null && l2 == null) {
            sumNode = new ListNode(l1.val + carry);
            if(sumNode.val > 9) {
                sumNode.val -= 10;
                carryBit = 1;
            }
            sumNode.next = addTwoNumbers(l1.next, null, carryBit);
        } else {
            sumNode = new ListNode(l2.val + carry);
            if(sumNode.val > 9) {
                sumNode.val -= 10;
                carryBit = 1;
            }
            sumNode.next = addTwoNumbers(null, l2.next, carryBit);
        }
        return sumNode;
    }
}
