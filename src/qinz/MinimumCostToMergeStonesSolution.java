package qinz;

import java.util.Arrays;

public class MinimumCostToMergeStonesSolution {
    public int mergeStones(int[] stones, int K) {
        if (stones.length < K) {
            return -1;
        }


        for (int i = 0; i <= stones.length - K; i++) {
            int merge = 0;
            int copyStart = i;
            for (int j = i; j < i + K; j++) {
                merge += stones[j];
            }

            // create the resulted array
            int[] newStones = new int[stones.length - K + 1];
            for (int k = 0; k < copyStart; k++) {
                newStones[k] = stones[k];
            }
            newStones[copyStart] = merge;
            //for (int k = copyStart;)
        }
        return 0;
    }
}
