/**
 * @Author: ybchen
 * @Date: 2021/8/10 10:05
 */
public class Code264UglyNumber {
    public static long nthUglyNumber(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int k = 0; k < i; k++) {
                if (dp[k] * 2 > dp[i - 1]) {
                    dp[i] = Math.min(dp[k] * 2, dp[i]);

                }
                if (dp[k] * 3 > dp[i - 1]) {
                    dp[i] = Math.min(dp[k] * 3, dp[i]);

                }
                if (dp[k] * 5 > dp[i - 1]) {
                    dp[i] = Math.min(dp[k] * 5, dp[i]);

                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 1600;
        long num = nthUglyNumber(n);

        System.out.print(num);


    }
}
