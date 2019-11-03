package qinz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArraySolution {
    public int repeatedNTimes(int[] A) {
        /*Arrays.sort(A);
        if(A[A.length / 2] == A[A.length / 2 + 1]) {
            return A[A.length / 2];
        } else {
            return A[A.length / 2 - 1];
        }*/

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if(!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                return A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 2);
    }
}
