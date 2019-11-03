package qinz;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsSolution {
    public boolean canAttendMeetings(int[][] intervals) {
        /*if(intervals.length == 1){
            return true;
        }

        boolean flag = false;
        for(int i  = 0; i < intervals.length; i++) {
            if(!flag) {
                for (int j = i + 1; j < intervals.length; j++) {
                    if (intervals[i][0] > intervals[j][0]) {
                        flag = true;
                        int temp1 = intervals[i][0];
                        int temp2 = intervals[i][1];
                        intervals[i][0] = intervals[j][0];
                        intervals[i][1] = intervals[j][1];
                        intervals[j][0] = temp1;
                        intervals[j][1] = temp2;
                    }
                }
                if(flag) {
                    flag = false;
                }
            } else {
                break;
            }
        }
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;*/

        if (intervals.length == 1) {
            return true;
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            priorityQueue.add(intervals[i]);
        }

        int[] start = priorityQueue.poll();
        while (priorityQueue.size() != 0) {
            int[] temp =priorityQueue.poll();
            if (start[1] > temp[0]) {
                return false;
            }
            start = temp;
        }
        return true;
    }
}
