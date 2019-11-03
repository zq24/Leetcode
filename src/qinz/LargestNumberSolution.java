package qinz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LargestNumberSolution {

    /*String max = "0";

    public String largestNumber(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        largestNumberHelper(numsList, new StringBuilder());
        return max;
    }

    private void largestNumberHelper(List<Integer> nums, StringBuilder res) {
        if (nums.size() == 0) {
            max = (res.toString().compareTo(max) >= 0) ? res.toString() : max;
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            int temp = nums.get(i);
            int numLength = String.valueOf(temp).length();
            res.append(temp);
            nums.remove(i);
            StringBuilder possible = new StringBuilder(res);
            largestNumberHelper(nums, possible);
            nums.add(i, temp);
            res.delete(res.length() - numLength, res.length());
        }
    }*/
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String stringOne = String.valueOf(o1);
                String stringTwo = String.valueOf(o2);
                String one = stringOne + stringTwo;
                String two = stringTwo + stringOne;
                return two.compareTo(one);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        if (queue.peek() == 0)
            return "0";

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            res.append(queue.poll());
        }
        return res.toString();
    }
}
