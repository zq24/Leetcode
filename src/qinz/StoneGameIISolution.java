package qinz;

import java.util.Arrays;

public class StoneGameIISolution {

    static int maxAlex = Integer.MIN_VALUE;

    public static int stoneGameII(int[] piles) {
        stoneGameIIHelper(piles, 1, 0 , 0, true);
        return maxAlex;
    }

    private static void stoneGameIIHelper(int[] piles, int M, int alexTotal, int leeTotal, boolean turn) {

        if (piles.length == 0) {
            maxAlex = Math.max(maxAlex, alexTotal);
            return;
        }

        if (turn) {
            for (int i = 1; i <= 2 * M; i++) {
                int firstX = 0;
                for (int j = 0; j < i && j < piles.length; j++) {
                    firstX += piles[j];
                }
                if (i > piles.length) {
                    break;
                }
                int newM = Math.max(i, M);
                int[] remainPiles = Arrays.copyOfRange(piles, i, piles.length);
                int newAlexTotal = alexTotal + firstX;
                stoneGameIIHelper(remainPiles, newM, newAlexTotal, leeTotal, !turn);
            }
        } else {
            int firstX = 0;
            for (int j = 0; j < 2 * M && j < piles.length; j++) {
                firstX += piles[j];
            }
            int[] remainPiles;
            if (2 * M >= piles.length) {
                remainPiles = new int[]{};
            } else {
                remainPiles = Arrays.copyOfRange(piles, 2 * M, piles.length);
            }
            int newLeeTotal = leeTotal + firstX;
            stoneGameIIHelper(remainPiles, 2 * M, alexTotal, newLeeTotal, !turn);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[] {2,7,9,4,4};
        System.out.println(stoneGameII(test));
    }
}