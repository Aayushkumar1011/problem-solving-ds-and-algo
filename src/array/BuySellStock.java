public class BuySellStock {
    public int maxProfit(int[] prices) {
        var maxProfit = 0;
        var buy = 0;
        var sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = prices[i - 1];
            sell = prices[i];
            maxProfit += Math.max(0, sell - buy);
        }
        return maxProfit;
    }
}
/**
[7,1,5,3,6,4]
buy     sell    profit
7       1       -6
1       5       4
5       3       2
    


sell = 1, 5
    
    decision lena hai ki transaction vo profitable: 0, sell - buy > 0
 */