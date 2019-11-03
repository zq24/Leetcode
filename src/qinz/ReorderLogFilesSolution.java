package qinz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ReorderLogFilesSolution {
    public static String[] reorderLogFiles(String[] logs) {
        List<String> digitLog = new ArrayList<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] stringOne = o1.split("\\s+");
                String[] stringTwo = o2.split("\\s+");
                int length = (stringOne.length <= stringTwo.length) ? stringOne.length : stringTwo.length;
                for (int i = 1; i < length; i++) {
                    if (stringOne[i].compareTo(stringTwo[i]) != 0) {
                        return stringOne[i].compareTo(stringTwo[i]);
                    }
                }
                if (stringOne.length == stringTwo.length) {
                    return stringOne[0].compareTo(stringTwo[0]);
                }
                return stringOne.length - stringTwo.length;
            }
        });

        for (int i = 0; i < logs.length; i++) {
            String[] check = logs[i].split("\\s+");
            for (int j = 0; j < check[1].length(); j++) {
                if (!Character.isDigit(check[1].charAt(j))) {
                    priorityQueue.add(logs[i]);
                    break;
                } else {
                    digitLog.add(logs[i]);
                    break;
                }
            }
        }

        String[] results = new String[logs.length];
        int currSize = priorityQueue.size();
        for (int i = 0; i < currSize; i++) {
            results[i] = priorityQueue.poll();
        }

        for (int i = currSize, j = 0; i < results.length; i++, j++) {
            results[i] = digitLog.get(j);
        }
        return results;
    }

    public static void main(String[] args) {
        String[] test = new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println(reorderLogFiles(test));
    }
}
