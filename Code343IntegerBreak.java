/**
 * @Author: ybchen
 * @Date: 2021/8/17 9:06
 */
public class Code343IntegerBreak {
    /**
     * 最暴力的dp解法
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[j] * (i - j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(15));
    }
}
