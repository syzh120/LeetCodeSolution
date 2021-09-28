import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/9/27 18:58
 */
public class Code_CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        return process(coins, amount, dp);
    }

    public static int process(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != -2) {
            return dp[amount];
        }
        int answer = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = process(coins, amount - coin, dp);
            if (res != -1) {
                answer = Math.min(res + 1, answer);
            }
        }
        dp[amount] = answer == Integer.MAX_VALUE ? -1 : answer;
        return dp[amount];

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(arr, amount));
    }
}
