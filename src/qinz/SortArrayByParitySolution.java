package qinz;

import java.util.ArrayList;

public class SortArrayByParitySolution {
    public int[] sortArrayByParity(int[] A) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                even.add(A[i]);
            } else {
                odd.add(A[i]);
            }
        }
        even.addAll(odd);
        int[] returnArray = new int[even.size()];
        for(int i = 0; i < even.size(); i++) {
            returnArray[i] = even.get(i);
        }
        return returnArray;
    }
}
