package qinz;

import java.util.Stack;

public class AddTwoNumbersIISolution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stackOfListOne = new Stack<>();
        Stack<ListNode> stackOfListTwo = new Stack<>();
        Stack<ListNode> res = new Stack<>();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null || temp2 != null) {
            if (temp1 != null) {
                stackOfListOne.push(temp1);
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                stackOfListTwo.push(temp2);
                temp2 = temp2.next;
            }
        }
        int numOfDigits = (stackOfListOne.size() <= stackOfListTwo.size()) ? stackOfListOne.size() :
                stackOfListTwo.size();

        boolean carry = false;
        for (int i = 0; i < numOfDigits; i++) {
            ListNode node1 = stackOfListOne.pop();
            ListNode node2 = stackOfListTwo.pop();
            int sum = (!carry) ? node1.val + node2.val : node1.val + node2.val + 1;
            carry = sum >= 10;
            sum = (sum >= 10) ? sum - 10 : sum;
            ListNode result = new ListNode(sum);
            res.push(result);
        }

        if (stackOfListOne.isEmpty() && !stackOfListTwo.isEmpty()) {
            while (!stackOfListTwo.isEmpty()) {
                ListNode node = stackOfListTwo.pop();
                int sum = (!carry) ? node.val : node.val + 1;
                carry = sum >= 10;
                sum = (sum >= 10) ? sum - 10 : sum;
                ListNode result = new ListNode(sum);
                res.push(result);
            }
        } else if (stackOfListTwo.isEmpty() && !stackOfListOne.isEmpty()) {
            while (!stackOfListOne.isEmpty()) {
                ListNode node = stackOfListOne.pop();
                int sum = (!carry) ? node.val : node.val + 1;
                carry = sum >= 10;
                sum = (sum >= 10) ? sum - 10 : sum;
                ListNode result = new ListNode(sum);
                res.push(result);
            }
        }

        if (carry) {
            ListNode result = new ListNode(1);
            res.push(result);
        }

        ListNode head = res.pop();
        ListNode temp = head;
        while (!res.isEmpty()) {
            temp.next = res.pop();
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(6);
        //ListNode n4 = new ListNode(3);
        n1.next = n2; n2.next = n3; //n3.next = n4;

        ListNode n5 = new ListNode(0);
        //ListNode n6 = new ListNode(6);
        //ListNode n7 = new ListNode(4);
        //n5.next = n6; n6.next = n7;

        addTwoNumbers(n1, n5);
    }

}
