package qinz;

public class SplitLinkedListInPartsSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int numOfNodes = 0;
        ListNode temp = root;
        while (temp != null) {
            numOfNodes += 1;
            temp = temp.next;
        }
        int nodesInEachPart = numOfNodes / k;
        int partsNeedExtra = numOfNodes % k;

        ListNode[] res = new ListNode[k];

        ListNode itr = root;
        for (int i = 0; i < k; i++) {
            ListNode partHead = itr;
            ListNode partItr = itr;
            res[i] = partHead;
            int numNodesInThisPart = (i < partsNeedExtra) ? nodesInEachPart + 1 : nodesInEachPart;
            for (int j = 0; j < numNodesInThisPart; j++) {
                itr = itr.next;
                if (j < numNodesInThisPart - 1) {
                    partItr = partItr.next;
                } else {
                    partItr.next = null;
                }
            }
        }
        return res;
    }
}
