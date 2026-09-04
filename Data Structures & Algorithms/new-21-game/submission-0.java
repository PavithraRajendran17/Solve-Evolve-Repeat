class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts - 1) {
            return 1.0;
        }

        double[] dp = new double[k + maxPts];
        dp[0] = 1.0;

        double window = 1.0;
        double result = 0.0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = window / maxPts;

            if (i < k) {
                window += dp[i];
            } else if (i <= n) {
                result += dp[i];
            }

            if (i - maxPts >= 0) {
                window -= dp[i - maxPts];
            }
        }

        return result;
        
    }
}