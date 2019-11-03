package qinz;

import java.util.*;

public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
        /*PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (int) (Math.pow(o1[0], 2) + Math.pow(o1[1], 2) - Math.pow(o2[0], 2) - Math.pow(o2[1], 2));
            }
        });

        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
        }

        int[] temp;
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            temp = queue.poll();
            int first = temp[0];
            int second = temp[1];
            res[i][0] = first;
            res[i][1] = second;
        }

        return res;*/
        int[][] lists= new int[K][2];
        double[] list = new double[points.length];

        List<Integer> p = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            double sqrt = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            list[i] = sqrt;
        }
        Arrays.sort(list);

        for (int i = 0; i < K; i++) {
            double m = list[i];

            int[] point = new int[2];

            for (int j = 0; j < points.length; j++) {
                if (Math.sqrt(points[j][0]*points[j][0] + points[j][1]*points[j][1]) == m) {
                    if (!p.contains(j)) {
                        p.add(j);
                        point[0] = points[j][0];
                        point[1] = points[j][1];
                        break;
                    }
                }
            }
            lists[i] = point;
        }
        return lists;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 1}, {1, 0}};
        System.out.println(kClosest(points, 2));
    }
}
