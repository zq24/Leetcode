package qinz;

public class ConvertSortedListToBinarySearchTreeSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int numOfNode = 0;
        ListNode temp = head;
        while (temp != null) {
            numOfNode += 1;
            temp = temp.next;
        }
        temp = head;
        int[] array = new int[numOfNode];
        int index = 0;
        while (temp != null) {
            array[index] = temp.val;
            index += 1;
            temp = temp.next;
        }

        int mid = numOfNode / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = sortedListToBST(array, 0, mid - 1);
        root.right = sortedListToBST(array, mid + 1, numOfNode - 1);
        return root;
    }

    private TreeNode sortedListToBST(int[] array, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int mid = (lo + hi) / 2;
        TreeNode newRoot = new TreeNode(array[mid]);
        newRoot.left = sortedListToBST(array, lo, mid - 1);
        newRoot.right = sortedListToBST(array, mid + 1, hi);
        return newRoot;
    }
}
