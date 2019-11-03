package qinz;

import java.util.*;

public class TopKFrequentElementsSolution {
    //The algorithm's time complexity must be better than O(n log n)
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map  = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int frequency = map.get(nums[i]);
                frequency++;
                map.put(nums[i], frequency);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        queue.addAll(map.entrySet());

        for(int i = 0; i < k; i++) {
            res.add(queue.poll().getKey());
        }

        return res;
    }
}
