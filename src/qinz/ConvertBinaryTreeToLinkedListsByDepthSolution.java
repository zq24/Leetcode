package qinz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertBinaryTreeToLinkedListsByDepthSolution {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //List<ListNode> lastNode = new ArrayList<>();
    Map<Integer, ListNode> map = new HashMap<>();

    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> res = new ArrayList<>();
        if(root == null)
            return res;
        binaryTreeToLists(res, root, 0);
        return res;
    }

    private void binaryTreeToLists(List<ListNode> result, TreeNode root, int height) {
        if(root == null) {
            return;
        }
        if(height >= result.size()) {
            ListNode levelHead = new ListNode(root.val);
            result.add(levelHead);
            map.put(height, levelHead);
        } else {
            ListNode newNode = new ListNode(root.val);
            map.get(height).next = newNode;
            map.put(height, newNode);
        }
        binaryTreeToLists(result, root.left, height + 1);
        binaryTreeToLists(result, root.right, height + 1);
    }

    private ListNode findLastNode(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}
