/**
 * @Author: ybchen
 * @Date: 2021/8/11 9:11
 */
public class CuttingRopes {

    /**
     * @param prices
     * @param n
     * @return
     */
    public static int cutting(int[] prices, int n) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = prices[0];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = prices[i - 1];
            for (int k = 1; k <= i; k++) {
                dp[i] = Math.max(dp[i], dp[i - k] + prices[k - 1]);
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {

    }
}
