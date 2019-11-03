package qinz;

import java.util.ArrayList;
import java.util.List;

public class DuplicateZerosSolution {
    public static void duplicateZeros(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                res.add(arr[i]);
            } else {
                res.add(arr[i]);
                res.add(arr[i]);
            }
            if (res.size() >= arr.length)
                break;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[] {1,2,3};
        duplicateZeros(test);
    }
}
