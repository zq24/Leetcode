package qinz;

public class BestTimeToBuyAndSellStockSolution {
    public int maxProfit(int[] prices) {
        /*int max = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;*/
        if (prices.length == 0) {
            return 0;
        }
        int lowestPrice = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
                max = Math.max(max, prices[i] - lowestPrice);
            }
        }
        return max;
    }
}
