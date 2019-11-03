package qinz;

import java.util.TreeMap;

public class FindAnagramMappingsSolution {
    public int[] anagramMappings(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < A.length; i++) {
            map.put(B[i], i);
        }
        int[] mapping = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            mapping[i] = map.get(A[i]);
        }
        return mapping;
    }
}
