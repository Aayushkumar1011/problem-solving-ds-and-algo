/**
  Problem statement
  https://leetcode.com/problems/coin-change/
*/

class CoinChangeSolution{
    public static int[][] dp = new int [13][100005];
    // public static int mod = (int)Math.pow(10, 4) + 10;
    public static int mod = (int)1e4 + 10;
    public int coinChange(int[] coins, int amount) {
        for(int i = 0; i < 13; i++)
            for(int j = 0; j < 100005; j++)
                dp[i][j] = -1;
        int result = getCoin(coins, amount, 0);
        return result >= mod? - 1 : result;

    }

    int getCoin(int[] coins, int amount, int i){
        int n = coins.length;
        if(i >= n){
            if(amount == 0)
                return 0;
            else
                return mod;
        }
        if(dp[i][amount] != - 1){
            return dp[i][amount];
        }
        int pick = mod, nonpick = mod;
        if(amount >= coins[i]){
            pick = 1 + getCoin(coins, amount - coins[i], i);
        }
        nonpick = getCoin(coins, amount, i+1);

        int ans = Math.min(pick, nonpick);
        dp[i][amount] = ans;
        return ans;
    }
}
