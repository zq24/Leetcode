package qinz;

import java.util.Stack;

public class NextGreaterNodeInLinkedListSolution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        int numOfNodes = 0;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
            numOfNodes += 1;
        }

        int[] res = new int[numOfNodes];
        int larger = stack.pop();
        for (int i = numOfNodes - 2; i >= 0; i--) {
            int current = stack.pop();
            if (larger > current) {
                res[i] = larger;
            } else {
                for (int j = i + 1; j < res.length; j++) {
                    if (current < res[j]) {
                        res[i] = res[j];
                        break;
                    }
                }
            }
            larger = current;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        l1.next = l2; l2.next = l3;
        l3.next = l4; l4.next = l5;
        int[] res = nextLargerNodes(l1);
    }
}
