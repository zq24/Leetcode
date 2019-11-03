package qinz;

import java.util.*;

public class TaskSchedulerSolution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            if(!map.containsKey(tasks[i])) {
                map.put(tasks[i], 1);
            } else {
                int prev = map.get(tasks[i]);
                prev++;
                map.put(tasks[i], prev);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        queue.addAll(map.entrySet());
        int result = 0;
        //Keep track of how many tasks have already being scheduled.
        int task = 0;
        while (!queue.isEmpty()) {
            List<Map.Entry<Character, Integer>> interval = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                if(task == tasks.length)
                    break;
                if(!queue.isEmpty()) {
                    Map.Entry<Character, Integer> head = queue.poll();
                    task++;
                    int times = head.getValue();
                    times--;
                    if(times != 0) {
                        head.setValue(times);
                        interval.add(head);
                    }
                }
                result++;
            }
            queue.addAll(interval);
        }
        return result;
    }
}
