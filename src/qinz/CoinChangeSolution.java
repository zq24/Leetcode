package qinz;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeSolution {
    /*static int leastNumOfCoins = -1;

    public static int coinChange(int[] coins, int amount) {
        coinChange(coins, amount, 0);
        return leastNumOfCoins;
    }

    private static void coinChange(int[] coins, int amountLeft, int numOfCoins) {
        if(amountLeft < 0)
            return;
        if(amountLeft == 0) {
            if(leastNumOfCoins == -1) {
                leastNumOfCoins = numOfCoins;
                return;
            } else {
                leastNumOfCoins = Math.min(leastNumOfCoins, numOfCoins);
                return;
            }
        }
        for(int i = 0; i < coins.length; i++) {
            int updateNumOfCoins = numOfCoins + 1;
            int coinsLeft = amountLeft - coins[i];
            coinChange(coins, coinsLeft, updateNumOfCoins);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 5};
        System.out.println(coinChange(test, 100));
    }*/

    static Map<Integer, Integer> map = new HashMap<>();

    public static int coinChange(int[] coins, int amount) {
        int numOfFewest =  coinChangeHelper(coins, amount);
        return (numOfFewest == Integer.MAX_VALUE) ? -1 : numOfFewest;
    }

    public static int coinChangeHelper(int[] coins, int amount) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }

        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int fewestNumOfCoins = 0;
        for (int i = 0; i < coins.length; i++) {
            int remainAmount = amount - coins[i];
            int fewest = coinChangeHelper(coins, remainAmount);
            if (fewest != Integer.MAX_VALUE) {
                if (fewestNumOfCoins == 0) {
                    fewestNumOfCoins = fewest + 1;
                } else {
                    fewestNumOfCoins = Math.min(fewestNumOfCoins, 1 + fewest);
                }
            }
            if (!map.containsKey(remainAmount)) {
                map.put(remainAmount, fewest);
            } else {
                int old = map.get(remainAmount);
                if (fewest < old) {
                    map.put(remainAmount, fewest);
                }
            }
        }
        return (fewestNumOfCoins == 0) ? Integer.MAX_VALUE : fewestNumOfCoins;
    }

    public static void main(String[] args) {
        int[] test = new int[] {2};
        System.out.println(coinChange(test, 3));
    }
}
