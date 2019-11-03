package qinz;

import java.util.*;

public class OpenTheLockSolution {

    static Map<String, Integer> map = new HashMap<>();
    static Set<String> deadLock = new HashSet<>();

    public static int openLock(String[] deadends, String target) {
        //initialize the queue
        Queue<String> neigh = new LinkedList<>();
        for (int i = 0; i < deadends.length; i++) {
            deadLock.add(deadends[i]);
        }
        if (deadLock.contains("0000"))
            return -1;
        map.put("0000", 0);
        neigh.offer("0000");
        openLock(deadends, target, neigh);
        if (!map.containsKey(target)) {
            return -1;
        } else {
            return map.get(target);
        }
    }

    private static void openLock(String[] deadends, String target, Queue<String> neigh) {
        while (!neigh.isEmpty()) {
            String current = neigh.poll();

            //Loop and check all the neighbors of this current lock
            List<String> neighbors = possibleNeighbors(current);
            for (int i = 0; i < neighbors.size(); i++) {
                String checkValid = neighbors.get(i);
                if (!deadLock.contains(checkValid) && !map.containsKey(checkValid)) {
                    neigh.offer(checkValid);
                    int turns = map.get(current);
                    map.put(checkValid, turns + 1);
                    if (map.containsKey(target))
                        return;
                }
            }

        }
    }

    private static List<String> possibleNeighbors(String current) {
        StringBuilder res = new StringBuilder(current);
        List<String> neigh = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char turn = res.charAt(i);
            if (turn - '0' == 0) {
                res.deleteCharAt(i);
                res.insert(i, 1);
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, 9);
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, turn);
            } else if (turn - '0' == 9) {
                res.deleteCharAt(i);
                res.insert(i, 0);
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, 8);
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, turn);
            } else {
                res.deleteCharAt(i);
                res.insert(i, turn + 1 - '0');
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, turn - 1 - '0');
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, turn);
            }
        }
        return neigh;
    }

    public static void main(String[] args) {
        String[] test = new String[] {"0201","0101","0102","1212","2002"};
        System.out.println(openLock(test, "0202"));

        /*StringBuilder res = new StringBuilder("1111");
        List<String> neigh = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char turn = res.charAt(i);
            if (turn - '0' == 0) {
                res.deleteCharAt(i);
                res.insert(i, 1);
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, 9);
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, turn);
            } else if (turn - '0' == 9) {
                res.deleteCharAt(i);
                res.insert(i, 0);
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, 8);
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, turn);
            } else {
                res.deleteCharAt(i);
                res.insert(i, turn + 1 - '0');
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, turn - 1 - '0');
                neigh.add(res.toString());
                res.deleteCharAt(i);
                res.insert(i, turn);
            }
        }
        System.out.println(neigh);*/
    }
}
