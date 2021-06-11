public class BestTimeToBuyAndSellStock {

    /*
    @author: Linh Tran
    @version: Jun 11th, 2021

    Runtime and usage info of the first solution:
    Runtime: 3 ms, faster than 22.03% of Java online submissions for Best Time to Buy and Sell Stock.
    Memory Usage: 105.8 MB, less than 6.01% of Java online submissions for Best Time to Buy and Sell Stock.
 */
    public int maxProfit(int[] prices) {
        // find the min price so far
        // find the max price so far
        // constantly update the largest difference
        int diff = 0;
        int max = -1;
        int min = prices[0];
        for (int i=1; i<prices.length; i++){
            if (prices[i] > min) {
                max = prices[i];
                diff = Math.max(max - min, diff);
            } else {
                min = prices[i];
            }

        }

        return diff;
    }
}
