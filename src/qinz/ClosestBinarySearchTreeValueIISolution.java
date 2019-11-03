package qinz;

import java.util.*;

public class ClosestBinarySearchTreeValueIISolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, Double> map = new HashMap<>();
    PriorityQueue<Map.Entry<Integer, Double>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Double>>() {
        @Override
        public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
            if (o1.getValue() - o2.getValue() < 0) {
                return -1;
            } else if (o1.getValue() - o2.getValue() > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    });

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        closestKValues(root, target);
        priorityQueue.addAll(map.entrySet());
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll().getKey());
        }
        return res;
    }

    private void closestKValues(TreeNode root, double target) {
        if (root == null)
            return;
        closestKValues(root.left, target);
        double distance = Math.abs(root.val - target);
        map.put(root.val, distance);
        closestKValues(root.right, target);
    }
}
