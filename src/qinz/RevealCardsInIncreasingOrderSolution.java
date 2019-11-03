package qinz;

import java.util.ArrayList;
import java.util.Arrays;

public class RevealCardsInIncreasingOrderSolution {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        ArrayList<Integer> list = new ArrayList<>();
        int length = deck.length - 1;
        list.add(deck[length]);
        while(list.size() != deck.length) {
            int removedItem = list.remove(list.size() - 1);
            list.add(0,removedItem);
            list.add(0, deck[length - 1]);
            length--;
        }
        int[] res = new int[deck.length];
        for(int i = 0; i < deck.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{17, 13, 11, 2, 3, 5, 7};
        deckRevealedIncreasing(test);
    }
}
