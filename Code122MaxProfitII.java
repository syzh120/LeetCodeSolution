/**
 * @Author: ybchen
 * @Date: 2021/8/11 10:05
 */
public class Code122MaxProfitII {

    /**
     * 买卖股票问题II,不限买卖次数
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - prices[0]);
            for (int k = 1; k < i; k++) {
                if (prices[k] > prices[i]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], prices[i] - prices[k] + dp[k - 1]);
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));

    }
}
