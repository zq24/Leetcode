package qinz;

import java.util.LinkedList;
import java.util.Stack;

public class SortWithThreeStacksSolution {
    public void sort(LinkedList<Integer> input) {
        if (input.size() == 0) {
            return;
        }

        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        int piviot = input.pop();
        for (int i = 0; i < input.size(); i++) {
            int num = input.peek();
        }
    }
}
