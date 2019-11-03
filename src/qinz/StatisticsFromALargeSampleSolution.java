package qinz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StatisticsFromALargeSampleSolution {

    public static double[] sampleStats(int[] count) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double mean;
        double medium;
        double mode = Integer.MIN_VALUE;
        double modeNum = Integer.MIN_VALUE;
        List<Integer> list = new LinkedList<>();
        ListIterator<Integer> itr = list.listIterator();

        int twoStepPointer = 0;
        int middleNumOne = 0;

        double sum = 0;
        double numOfElement = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                if (count[i] > modeNum) {
                    modeNum = count[i];
                    mode = i;
                }
                for (int j = 0; j < count[i]; j++) {
                    list.add(i);
                    twoStepPointer += 1;
                    if (twoStepPointer % 2 == 0) {
                        middleNumOne = itr.next();
                    }
                }
            }
            sum += i * count[i];
            numOfElement += count[i];
        }
        mean = sum / numOfElement;
        if (numOfElement % 2 == 1) {
            medium = middleNumOne;
        } else {
            medium = (middleNumOne + itr.next()) / 2.0;
        }
        return new double[] {min, max, mean, medium, mode};
    }

    public static void main(String[] args) {
        int[] test = new int[] {0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(sampleStats(test));
    }
}
