class Solution {

    int[][] dp;   // <-- declare here

    public int maxProfit(int[] prices) {

        int n = prices.length;
        dp = new int[n][2];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(0, 1, prices);
    }

    private int solve(int i, int buy, int[] prices){

        if(i >= prices.length)
            return 0;

        if(dp[i][buy] != -1)
            return dp[i][buy];

        int profit;

        if(buy == 1){

            int take = -prices[i] + solve(i + 1, 0, prices);
            int skip = solve(i + 1, 1, prices);

            profit = Math.max(take, skip);

        } else {

            int sell = prices[i] + solve(i + 2, 1, prices);
            int hold = solve(i + 1, 0, prices);

            profit = Math.max(sell, hold);
        }

        return dp[i][buy] = profit;
    }
}
