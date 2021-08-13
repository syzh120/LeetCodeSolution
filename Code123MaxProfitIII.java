/**
 * @Author: ybchen
 * @Date: 2021/8/11 12:18
 */
public class Code123MaxProfitIII {


    //dp[i][j]: 前i天最多买卖j笔的最大利润
    public static int maxProfit(int[] prices) {

        int row = prices.length;
        int[][] dp = new int[row][3];
        for (int i = 1; i <= 2; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < row; j++) {
                dp[j][i] = Math.max(dp[j - 1][i], maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff, dp[j - 1][i - 1] - prices[j]);

            }

        }
        return Math.max(dp[row - 1][1], dp[row - 1][2]);
    }
    //j>k
    //k<j

    public static int process(int[] prices) {
        int row = prices.length;
        int[][] dp = new int[row][3];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j <= Math.min(2, i); j++) {
                dp[i][j] = dp[i - 1][j];
                int temp = 0;
                for (int k = 0; k < i; k++) {
                    if (prices[k] > prices[i]) {
                        continue;
                    }
                    temp = (k >= 1 ? dp[k - 1][j - 1] : 0) - prices[k];
                    dp[i][j] = Math.max(temp + prices[i], dp[i][j]);
                }
                System.out.println(dp[i][j] - prices[i]);
            }

        }
        return Math.max(dp[row - 1][1], dp[row - 1][2]);
    }

    public int maxProfit(int K, int[] prices) {
        // write your code here
        int result = 0;
        int row = prices.length;
        int[][] dp = new int[row][K + 1];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j <= Math.min(K, i); j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k < i; k++) {
                    if (prices[k] > prices[i]) {
                        continue;
                    }
                    int temp = k >= 1 ? dp[k - 1][j - 1] : 0;
                    dp[i][j] = Math.max(temp + prices[i] - prices[k], dp[i][j]);
                    result = Math.max(result, dp[i][j]);
                }
            }

        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};//3;
        System.out.println(maxProfit(arr));
    }
}
