package qinz;

import java.util.*;

public class HighFiveSolution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if (!map.containsKey(items[i][0])) {
                PriorityQueue<Integer> grades = new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                grades.add(items[i][1]);
                map.put(items[i][0], grades);
                id.add(items[i][0]);
            } else {
                map.get(items[i][0]).add(items[i][1]);
            }
        }

        int[][] res = new int[id.size()][2];
        for (int i = 0; i < id.size(); i++) {
            PriorityQueue<Integer> grades = map.get(id.get(i));
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += grades.poll();
            }
            int average = sum / 5;
            res[i][0] = id.get(i);
            res[i][1] = average;
        }
        return res;
    }
}
