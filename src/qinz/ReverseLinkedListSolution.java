package qinz;

public class ReverseLinkedListSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode temp = head;
        int numOfNode = 0;
        while(temp.next != null) {
            temp = temp.next;
            numOfNode++;
        }
        ListNode root = new ListNode(temp.val);
        ListNode pointer = root;
        while(numOfNode != 0) {
            ListNode tempNode = head;
            for(int i = 0; i < numOfNode - 1; i++) {
                tempNode = tempNode.next;
            }
            pointer.next = new ListNode(tempNode.val);
            pointer = pointer.next;
            numOfNode--;
        }
        return root;
    }
}
