/**
 * @Author: ybchen
 * @Date: 2021/8/16 16:34
 */
public class Code309MaxProfit {

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;//卖
        dp[0][1] = 0;//不卖
        int maxDiff = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][0] = prices[i] + maxDiff;
            maxDiff = Math.max(maxDiff, (i < 1 ? 0 : dp[i - 1][1]) - prices[i]);
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

    public static int process(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;//卖
        dp[0][1] = 0;//不卖
        int maxDiff = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            for (int j = i - 1; j >= 0; j--) {
                dp[i][0] = Math.max(dp[i][0], prices[i] - prices[j] + (j == 0 ? 0 : dp[j - 1][1]));
                maxDiff = Math.max(maxDiff, dp[i - 1][1] - prices[i - 1]);
            }

        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

    public static void main(String[] args) {
        //
        int[] arr = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(arr));
    }
}
