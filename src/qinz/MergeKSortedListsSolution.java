package qinz;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedListsSolution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode res = null;
        ListNode itr = null;

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            if(temp != null) {
                queue.add(temp);
            }
        }

        while(!queue.isEmpty()) {
            if(res == null) {
                res = queue.poll();
                itr = res;
                if(itr.next != null) {
                    queue.add(itr.next);
                }
            } else {
                ListNode temp = queue.poll();
                itr.next = temp;
                itr = itr.next;
                if(temp.next != null) {
                    queue.add(temp.next);
                }
            }
        }

        return res;
    }
}
