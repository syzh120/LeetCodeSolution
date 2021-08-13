/**
 * @Author: ybchen
 * @Date: 2021/8/13 16:35
 */
public class Code714MaxProfitV {

    public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int maxDiff = Math.max(-prices[0], -prices[1]);
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - fee + maxDiff);
            maxDiff = Math.max(maxDiff, dp[i - 1] - prices[i]);
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(maxProfit(prices, fee));
    }
}
