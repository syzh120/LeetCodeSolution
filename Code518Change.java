import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2020/11/24 14:07
 */
public class Code518Change {

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process(amount, coins, 0, dp);
    }

    /**
     * approach1:记忆化搜索
     * @param amount
     * @param coins
     * @param index
     * @param dp
     * @return
     */
    public static int process(int amount, int[] coins, int index, int[][] dp) {
        if (amount < 0) {
            return 0;
        }
        if (dp[amount][index] != -1) return dp[amount][index];
        if (amount == 0) {
            dp[0][index] = 1;
            return 1;
        }
        if (index == coins.length) {
            dp[amount][index] = 0;
            return 0;
        }
        int choose = process(amount - coins[index], coins, index, dp);
        int notChoose = process(amount, coins, index + 1, dp);
        dp[amount][index] = choose + notChoose;
        return choose + notChoose;
    }

    /**
     * approach2:动态规划
     * @param amount
     * @param coins
     * @return
     */
    public static int dpWays(int amount,int[] coins){
        int[][] dp=new int[amount+1][coins.length+1];
        for(int col=0;col<coins.length+1;col++){
            dp[0][col]=1;
        }
        for(int row=1;row<dp.length;row++){
            dp[row][coins.length]=0;
        }
        for (int row = 1; row < dp.length; row++) {
            for (int col = dp[0].length - 2; col >= 0; col--) {
                int choose = amount - coins[col] >= 0 ? dp[amount - coins[col]][col] : 0;
                dp[row][col] = choose + dp[row][col + 1];

            }
        }
        return dp[amount][0];
    }


}
