package ITCCoderpad;

public class StockBuySelltoMaximizeProfit {
    public static void main(String[] args) {

    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = prices[0], max = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            } else if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}