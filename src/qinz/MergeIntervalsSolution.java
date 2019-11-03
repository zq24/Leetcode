package qinz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervalsSolution {
    public static int[][] merge(int[][] intervals) {
        /*List<int[]> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                int[] merge = new int[2];
                merge[0] = intervals[i][0];
                merge[1] = intervals[i + 1][1];
                intervalList.add(merge);
            }
        }
        return null;*/
        if (intervals.length == 0) {
            return new int[0][0];
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        for(int i = 0; i < intervals.length; i++) {
            queue.add(intervals[i]);
        }

        List<int[]> res = new ArrayList<>();
        int[] interval = queue.poll();
        while (!queue.isEmpty()) {
            int[] nextInterval = queue.poll();
            if(interval[1] >= nextInterval[0]) {
                interval[1] = nextInterval[1];
            } else {
                int[] newInterval = new int[2];
                newInterval[0] = interval[0];
                newInterval[1] = interval[1];
                res.add(newInterval);
                interval[0] = nextInterval[0];
                interval[1] = nextInterval[1];
            }
        }

        res.add(interval);

        int[][] result = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        merge(test);
    }
}
