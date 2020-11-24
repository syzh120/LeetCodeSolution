import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2020/11/23 9:49
 */
public class Code322CoinChange {


    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param coins
     * @param amount
     * @return
     */

    public static int coinChange(int[] coins, int amount) {
        return dpWays(coins,amount);
    }

    /**
     * approach1：记忆化搜索
     * coins[index...] 组成出amount这么多钱，最少的硬币数量返回
     * @param coins
     * @param amount
     * @param index
     * @return
     */

    public static int process(int[] coins, int amount, int index, int[][] dp) {
        if (amount < 0) {
            return -1;
        }
        if (dp[amount][index] != -2) {
            return dp[amount][index];
        }
        if (amount == 0) {
            dp[amount][index] = 0;
            return 0;
        }
        if (index == coins.length) {
            dp[amount][index] = -1;
            return -1;
        }
        int choose = process(coins, amount - coins[index], index, dp);
        int notChoose = process(coins, amount, index+1, dp);
        if (choose == -1 && notChoose == -1) {
            dp[amount][index] = -1;
            return -1;
        }
        if (choose == -1) {
            dp[amount][index] = notChoose;
            return notChoose;
        }
        if (notChoose == -1) {
            dp[amount][index] = choose + 1;
            return choose + 1;
        }
        dp[amount][index] = Math.min(choose + 1, notChoose);
        return dp[amount][index];
    }

    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */

    public static int dpWays(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int col = 0; col < coins.length + 1; col++) {
            dp[0][col] = 0;
        }
        for (int row = 1; row < amount + 1; row++) {
            dp[row][coins.length] = -1;
        }
        for (int row = 1; row < dp.length; row++) {
            for (int col = dp[0].length - 2; col >= 0; col--) {
                int choose = row - coins[col] >= 0 ? dp[row - coins[col]][col] : -1;
                int notChoose = dp[row][col + 1];
                if (choose == -1 && notChoose == -1) {
                    dp[row][col] = -1;
                } else if (choose == -1) {
                    dp[row][col] = notChoose;
                } else if (notChoose == -1) {
                    dp[row][col] = choose + 1;
                } else {
                    dp[row][col] = Math.min(choose + 1, notChoose);
                }
            }
        }

        return dp[amount][0];
    }

































    public static void main(String[] args) {

    }


}
